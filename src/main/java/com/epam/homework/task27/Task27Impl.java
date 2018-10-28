package com.epam.homework.task27;

public class Task27Impl implements Task27 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    class Graph extends AbstractGraph {

        int[][] matrix;

        public Graph(int numberNodes) {
            super(numberNodes);
            matrix = new int[numberNodes][numberNodes];
            for (int i = 0; i < numberNodes; i++) {
                for (int j = 0; j < numberNodes; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        @Override
        public void addEdge(int first, int second) {
            matrix[first][second] = 1;
            matrix[second][first] = 1;
        }

        @Override
        public void removeEdge(int first, int second) {
            matrix[first][second] = 0;
            matrix[second][first] = 0;
        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            return matrix[first][second] != 0;
        }
    }

}
