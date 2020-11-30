package com.example.goodminesweeperapp.views.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.example.goodminesweeperapp.Engine;
import com.example.goodminesweeperapp.R;

import androidx.core.content.ContextCompat;

public class Cell extends baseCell implements View.OnClickListener, View.OnLongClickListener{

    public Cell(Context context, int position){
        super(context);
        setPosition(position);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {

        Engine.getInstance().flag(getXpos(), getYpos());

        return true;
    }

    @Override
    protected void onMeasure (int wMeasureSpec, int hMeasureSpec) {
        super.onMeasure(wMeasureSpec, wMeasureSpec );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawButton(canvas);

        if (isFlagged()){
            drawFlag(canvas);

        }else if (isRevealed() &&isBomb()&&!isClicked()){
            drawBomb(canvas);
        }else {
            if (isClicked()) {

                if (getVal() == -1) {
                    drawDead(canvas);
                } else {
                    drawNum(canvas);
                }
            }else {
                drawButton(canvas);
            }
        }
    }

    private void drawDead (Canvas canvas){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.dead);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawFlag (Canvas canvas){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.flag);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawButton(Canvas canvas){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawBomb(Canvas canvas){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb2);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    @Override
    public void onClick(View view) {
        Engine.getInstance().click(getXpos(), getYpos());
    }

    private void drawNum(Canvas canvas){
        Drawable drawable=null;

        switch (getVal()){
            case 0:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
                break;
            case 1:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button1);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button2);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button3);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button4);
                break;
            case 5:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button5);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button6);
                break;
            case 7:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button7);
                break;
            case 8:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.button8);
                break;
        }

        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }
}
