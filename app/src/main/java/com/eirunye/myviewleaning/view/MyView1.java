package com.eirunye.myviewleaning.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author Eirunye
 * Created by on 2018/10/22.
 * Describe
 */
public class MyView1 extends View {

    Path path;

    Paint paint;

    RectF rectf, rect1, rect2;

    public MyView1(Context context) {
        this(context, null);
    }

    public MyView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        path = new Path();

        rectf = new RectF(100, 100, 400, 300);

        rect1 = new RectF(100, 500, 400, 700);

        rect2 = new RectF(100, 800, 400, 1000);


        path.addRect(rectf, Path.Direction.CCW); //CCW表示逆时针，CW表示顺时针

//        path.addRect(rect1, Path.Direction.CW);


        /**
         * rx：表示圆角横坐标的半径
         * ry：表示圆角纵坐标的半径
         */
        path.addRoundRect(rect1, 20, 5, Path.Direction.CW);

        /**
         * 想画各个坐标的角度都不一样则可以根据数组来定义
         * radii：表示四个点的坐标
         */

        float[] radii = {10, 20, 40, 30, 50, 50, 40, 50}; //表示四个点的坐标
        path.addRoundRect(rect2, radii, Path.Direction.CW);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
        String text = "哈哈，这是自定义View,一起来学习吧";
        paint.setColor(Color.RED);
        paint.setTextSize(30);

        /**
         * hOffset: 表示的是距离原点的距离，即左上角的坐标的距离
         * vOffset：表示的是上方（ - ）或下方（+）距离文本位置的距离，以该实例，矩形：则表示，如果负数表示在线的上方，数值越大距离越远反之
         */
        canvas.drawTextOnPath(text, path, 0, -30, paint);

    }
}
