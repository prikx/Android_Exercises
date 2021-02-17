package com.example.lecture2_colorchanger

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

/**
 * TODO: document your custom view class.
 */
class ColorChangeView : View, GestureDetector.OnGestureListener{

    private var gestureDetector: GestureDetector? = null
    private lateinit var paint: Paint
    private var right : Boolean = true
    private var blue : Float = 0f
    private var red : Float = 0f

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        setOnTouchListener { _, event ->
            gestureDetector?.onTouchEvent(event)
            true
        }
        gestureDetector = GestureDetector(getContext(), this)
        paint = Paint()
        paint.color = Color.BLACK
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        blue += velocityX/100
        if(blue > 255f) {
            blue = 255f
        } else if (blue < 0) {
            blue = 0f
        }

        red += velocityY/100
        if(red > 255f) {
            red = 255f
        } else if (red < 0) {
            red = 0f
        }

        //Log.d("deb", "blue: $blue")
        //Log.d("deb", "red: $red")
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.setARGB(paint.alpha, (paint.color.red + red).toInt(), paint.color.green,
            (paint.color.blue + blue).toInt()
        )
        Log.d("cinfo", "color:   " + paint.color.red + " " + paint.color.green + " " + paint.color.blue)
        paint.style = Paint.Style.FILL
        canvas?.drawPaint(paint)
    }
}