package com.example.goodminesweeperapp.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.goodminesweeperapp.Engine;

public class Grid extends GridView {

    public Grid(Context context, AttributeSet att){
        super(context, att);
        Engine.getInstance().createGrid(context);

        setNumColumns(Engine.width);
        setAdapter(new gridAd());

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    private class gridAd extends BaseAdapter{

        @Override
        public int getCount() {
            return Engine.getInstance().width*Engine.getInstance().height;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return Engine.getInstance().getCellAt(i);
        }
    }
}
