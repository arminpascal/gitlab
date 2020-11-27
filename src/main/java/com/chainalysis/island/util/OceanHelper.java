package com.chainalysis.island.util;

public class OceanHelper {

    private static void deepSearchRecursion(int xCurrent, int yCurrent, int[][] ocean) {

        // saving the index of the 2d stencil as two arrays instead of of one 3x3 2d array
        // to save memory and simplify the following code from two to one loop
        int[] xStencil = new int[]{-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] yStencil = new int[]{-1, -1, -1, 0, 0, 0, 1, 1, 1};

        // using loop to find all valid neighour cells to continue deep search in all these directions
        for (int i = 0; i < xStencil.length; i++) {
            int xNext = xCurrent + xStencil[i];
            int yNext = yCurrent + yStencil[i];
            // validate if next cell is n the grid, an island and unexplored
            if (xNext >= 0
                && xNext < ocean.length
                && yNext >= 0
                && yNext < ocean[xNext].length // using xNext here to support non-rectangular 2d array
                && ocean[xNext][yNext] != -1
                && ocean[xNext][yNext] == 1
            ) {
                // using -1 to mark part of island as visited
                ocean[xNext][yNext] = -1;
                // descend deeper into the recursion
                deepSearchRecursion(xNext, yNext, ocean);
            }
        }


    }

    public static int countIslands(int[][] ocean) {
        int count = 0;

        // iterating over the grid and starting a new deep search
        // whenever a non visited island was found
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                if (ocean[i][j] == 1) {
                    deepSearchRecursion(i, j, ocean);
                    count++;
                }
            }
        }
        return count;
    }
}
