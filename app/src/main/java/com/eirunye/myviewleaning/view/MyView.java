package com.eirunye.myviewleaning.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.eirunye.myviewleaning.R;

/**
 * Author Eirunye
 * Created by on 2018/10/16.
 * Describe
 */
public class MyView extends View {

    private String myText;

    private int textColor;

    private int myTextSize;

    private Paint paint;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView, defStyleAttr, 0);
        myText = typedArray.getString(R.styleable.MyView_myText);
        textColor = typedArray.getColor(R.styleable.MyView_textColor, Color.BLUE);
        myTextSize = typedArray.getInteger(R.styleable.MyView_myTextSize,20);
        typedArray.recycle();//回收
        paint = new Paint();
        paint.setAntiAlias(true); //是否抗锯齿
        paint.setStrokeWidth(4);  //画笔大小
        paint.setStyle(Paint.Style.FILL); //画笔填充样式:STROKE、FILL、FILL_AND_STROKE
        paint.setTextSize(myTextSize); //设置文字大小
        paint.setColor(textColor); //设置文字颜色
        paint.setUnderlineText(true);//设置下划线
        //paint.setFakeBoldText(false);//是否为粗体
        //paint.setTextScaleX(0.13f);//设置斜体
        //paint.setAlpha(24);//透明度[0..255]
        //.....

    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawText(myText, 10, 200, paint);
    }
}
