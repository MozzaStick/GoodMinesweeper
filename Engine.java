package com.example.goodminesweeperapp;

import android.content.Context;
import android.view.View;

import com.example.goodminesweeperapp.util.Generator;
import com.example.goodminesweeperapp.views.grid.Cell;

public class Engine {

    private static Engine instance;
    public static final int bombs=9;
    public static final int width=9;
    public static final int height=9;

    private Context context;
    private Cell[][] gameBoard=new Cell[width][height];

    public static Engine getInstance() {
        if (instance == null){
            instance = new Engine();
        }

        return instance;
    }

    private Engine(){}

    public void createGrid(Context context) {
        this.context = context;

        int[][] newGrid= Generator.generate(bombs, width, height); //creates the game grid
        setBoard(context, newGrid);

    }

    private  void setBoard (final Context context, final int[][] grid){
        for (int x=0; x<width; x++){
            for (int y=0; y<height; y++){
                if(gameBoard[x][y]==null){
                    gameBoard[x][y]=new Cell(context, y*height+x);
                }

                gameBoard[x][y].setVal(grid[x][y]);
                gameBoard[x][y].invalidate();
            }
        }
    }
    public Cell getCellAt(int position){
        int x=position % width;
        int y=position/height;
        return gameBoard[x][y];
    }

    public Cell getCellAt(int x, int y){
        return gameBoard[x][y];
    }

    public void click (int Xpos, int Ypos){
        if(Xpos>=0 && Ypos>=0 && Xpos<width && Ypos<height && !getCellAt(Xpos,Ypos).isClicked() ){
            getCellAt(Xpos,Ypos).setClicked();

            if(getCellAt(Xpos, Ypos).getVal()==0){
                for(int n=-1;n<=1;n++){
                    for (int m=-1;m<=1;m++){
                        if(n!=m){
                            click(Xpos+n,Ypos+m);
                        }
                    }

                }
            }
            if(getCellAt(Xpos,Ypos).isBomb()) {
                gameOver();

            }
        }

    }

    private void gameOver(){

    }

    public void flag(int x, int y){
        boolean flagged = getCellAt(x, y).isFlagged();
        getCellAt(x,y).setFlagged(!flagged);

        getCellAt(x, y).invalidate();
    }
}
