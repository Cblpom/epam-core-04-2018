package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        List<ISegment> segmentList = new ArrayList<>(segments);
        TreeMap<Double, Set<I2DPoint>> intersections = new TreeMap<>();

        for (int i = 0; i < segmentList.size(); i++) {
            for (int j = i + 1; j < segmentList.size(); j++) {

                I2DPoint point;

                ISegment segment1 = segmentList.get(i);
                ISegment segment2 = segmentList.get(j);

                I2DPoint dir1 = new Point(segment1.second().getX() - segment1.first().getX(), segment1.second().getY() - segment1.first().getY());
                I2DPoint dir2 = new Point(segment2.second().getX() - segment2.first().getX(), segment2.second().getY() - segment2.first().getY());

                double a1 = -dir1.getY();
                double b1 = dir1.getX();

                double d1 = -(a1 * segment1.first().getX() + b1 * segment1.first().getY());

                double a2 = -dir2.getY();
                double b2 = dir2.getX();
                double d2 = -(a2 * segment2.first().getX() + b2 * segment2.first().getY());

                double seg1Start = a2 * segment1.first().getX() + b2 * segment1.first().getY() + d2;
                double seg1End = a2 * segment1.second().getX() + b2 * segment1.second().getY() + d2;

                double seg2Start = a1 * segment2.first().getX() + b1 * segment2.first().getY() + d1;
                double seg2End = a1 * segment2.second().getX() + b1 * segment2.second().getY() + d1;

                if (seg1Start * seg1End > 0 || seg2End * seg2End > 0)
                    point = null;
                else {
                    double u = seg1Start / (seg1Start - seg1End);
                    point = new Point(segment1.first().getX() + u * dir1.getX(), segment1.first().getY() + u * dir1.getY());
                }

                 if (point != null) {
                    double key = point.getX();
                    if (intersections.containsKey(key) == false) {
                        Set<I2DPoint> hashSet = new HashSet<>();
                        hashSet.add(point);
                        intersections.put(key, hashSet);
                    } else {
                        intersections.merge(key, intersections.get(key),
                                (a, b) -> {
                                    intersections.get(key).add(point);
                                    return intersections.get(key);
                                });
                    }
                }
            }
        }
        return intersections.firstEntry().getValue();
    }



}

class Point implements Task26.I2DPoint {

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}

class IntersectionPoint implements Task26.ISegment {

    private Task26.I2DPoint first;
    private Task26.I2DPoint second;

    IntersectionPoint(Task26.I2DPoint first, Task26.I2DPoint second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Task26.I2DPoint first() {
        return first;
    }

    @Override
    public Task26.I2DPoint second() {
        return second;
    }
}
