package com.example.goodminesweeperapp.views.grid;

import android.content.Context;
import android.view.View;

import com.example.goodminesweeperapp.Engine;

public abstract class baseCell extends View {


    private int val;

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked() {
        this.clicked=true;
        this.revealed=true;

        invalidate();
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getXpos() {
        return x;
    }


    public int getYpos() {
        return y;
    }



    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;

        x=position%Engine.width;
        y=position/Engine.height;
        invalidate();
    }

    private boolean bomb;
    private boolean revealed;
    private boolean clicked;
    private boolean flagged;
    private int x;
    private int y;
    private int position;

    public baseCell(Context context){
        super(context);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        bomb=false;
        revealed=false;
        clicked=false;
        flagged=false;

        if(val==-1){
            bomb=true;
        }
        this.val = val;
    }

}
