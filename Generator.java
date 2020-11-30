package com.example.goodminesweeperapp.util;

import java.util.Random;

public class Generator {

    public static int[][] generate(int bombNum, final int w, final int h){
        Random rando = new Random();
        int [][] grid = new int[w][h];
        for (int x=0; x<w; x++){
            grid[x]= new int[h]; //generates grid for the game
        }

        while (bombNum>0){
            int x=rando.nextInt(w);
            int y=rando.nextInt(h);
            if (grid[x][y] != -1){
                grid[x][y] = -1;
                bombNum=bombNum-1; //place bombs

            }
        }
        grid = surroundings(grid,w,h);
        return grid;

    }

    private static int[][] surroundings( int[][] grid, final int w, final int h){

        for (int x=0; x<w; x++){

            for(int y=0; y<h; y++){

                grid[x][y]=neighborNum(grid, x, y, w, h);
            }

        }
        return grid;
    }

    private static int neighborNum(final int grid[][], final int x, final int y, final int w, final int h){
        if (grid[x][y]==-1){ //-1 is a bomb
            return -1;
        }

        int count=0;

        //checks surrounding cells


        if (locationMine(grid, x-1, y+1, w, h)){
            count++;
        }
        if (locationMine(grid, x, y+1, w, h)){
            count++;
        }
        if (locationMine(grid, x+1, y+1, w, h)){
            count++;
        }
        if (locationMine(grid, x-1, y, w, h)){
            count++;
        }
        if (locationMine(grid, x+1, y, w, h)){
            count++;
        }
        if (locationMine(grid, x-1, y-1, w, h)){
            count++;
        }
        if (locationMine(grid, x, y-1, w, h)){
            count++;
        }
        if (locationMine(grid, x+1, y-1, w, h)){
            count++;
        }

        return count;

    }
    private static boolean locationMine (final int[][] grid, final int x, final int y, final int w, final int h){

        if (x>=0 && y>=0 && x<w && y<h){

            if (grid[x][y] == -1){
                return true;
            }

        }
        return false;

    }
}
