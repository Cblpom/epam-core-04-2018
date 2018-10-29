package com.epam.homework.task28;

import java.util.Set;

public class Task28Impl implements Task28 {



    @Override
    public int getNumberOvertaking(Set<Car> cars, int lengthLap, int numberLaps) {

        int ans = 0;
        double t;

        for (Car McQueen: cars) {
            double T=(lengthLap*numberLaps+McQueen.getStartPosition())/McQueen.getSpeed();
            for (Car Sally: cars){
                t = 0;
                if (McQueen.getSpeed()>Sally.getSpeed()){
                    if (Sally.getStartPosition()>=McQueen.getStartPosition()){
                        t =  -(Sally.getStartPosition()-McQueen.getStartPosition())/(McQueen.getSpeed()-Sally.getSpeed());

                    }else{
                        t = (McQueen.getStartPosition()-Sally.getStartPosition())/(McQueen.getSpeed()-Sally.getSpeed());
                        if (t<T){
                            ans++;
                        }
                    }
                    while (t<T){
                        t = t + lengthLap/(McQueen.getSpeed()-Sally.getSpeed());
                        ans++;
                    }


                }
            }
        }
        return ans;


    }
}
