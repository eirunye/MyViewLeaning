package com.eirunye.myviewleaning.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.eirunye.myviewleaning.R;

/**
 * Author Eirunye
 * Created by on 2018/10/20.
 * Describe
 */
public class MyRectView extends View {
    private int rectStyle;
    private int rectWidth;
    private int rectColor;

    private Paint paint;

    private Rect rect;

    public MyRectView(Context context) throws Exception {
        this(context, null);
    }

    public MyRectView(Context context, @Nullable AttributeSet attrs) throws Exception {
        this(context, attrs, 0);
    }

    public MyRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) throws Exception {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyRectView, defStyleAttr, 0);
        rectColor = typedArray.getColor(R.styleable.MyRectView_rect_color, Color.RED);
        rectWidth = typedArray.getInt(R.styleable.MyRectView_rect_width, -1);
        rectStyle = typedArray.getInt(R.styleable.MyRectView_rect_Style, 1);
        if (rectWidth == -1) {
            throw new RuntimeException("请设置画笔的宽度！");
        }
        typedArray.recycle();
        paint = new Paint();

        paint.setColor(rectColor);
        paint.setStrokeWidth(rectWidth);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(rect, paint);
        super.onDraw(canvas);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rect.right += rectWidth; //将画笔大小入矩形边距中
                rect.bottom += rectWidth;
                System.out.println("rect.right:" + rect.right + "  rect.bottom:" + rect.bottom);
                rect.left = x;
                rect.top = y;
                rect.right = rect.left;
                rect.bottom = rect.top;
                break;
            case MotionEvent.ACTION_MOVE:
                Rect oldRect = new Rect(rect.left, rect.top, rect.right, rect.bottom);
                rect.right = x;
                rect.bottom = y;
                System.out.println("X:" + x + "   y:" + y);
                oldRect.union(x, y);
                invalidate(oldRect);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        return true;
    }
}

