package com.example.lecture2_colorchanger

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

/**
 * TODO: document your custom view class.
 */
class ColorSimonView : View, GestureDetector.OnGestureListener {

    private var gestureDetector: GestureDetector? = null

    private val topLeftColor = Color.GREEN
    private val topRightColor = Color.RED
    private val bottomLeftColor = Color.BLUE
    private val bottomRightColor = Color.YELLOW

    private lateinit var leftTop: Rect
    private lateinit var leftBottom: Rect
    private lateinit var rightTop: Rect
    private lateinit var rightBottom: Rect

    var circlePaint: Paint = Paint()





    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        setOnTouchListener { _, event ->
            gestureDetector?.onTouchEvent(event)
            true
        }
        gestureDetector = GestureDetector(getContext(), this)
        circlePaint.color = Color.WHITE
    }

    override fun onDown(e: MotionEvent?): Boolean {

        var x = e!!.getX().toInt()
        var y = e!!.getY().toInt()

        var rect = Rect(x,y,x,y)

        if(leftTop.intersect(rect)) {
            circlePaint.color = topLeftColor
        } else if (leftBottom.intersect(rect)) {
            circlePaint.color = bottomLeftColor
        } else if (rightTop.intersect(rect)) {
            circlePaint.color = topRightColor
        } else if (rightBottom.intersect(rect)) {
            circlePaint.color = bottomRightColor
        }

        invalidate()
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        leftTop = Rect(0,0,width/2,height/2)
        leftBottom = Rect(0, height/2, width/2, height)
        rightTop = Rect(width/2, 0, width, height/2)
        rightBottom = Rect(width/2, height/2, width, height)

        val leftTopPaint = Paint()
        val leftBottomPaint = Paint()
        val rightTopPaint = Paint()
        val rightBottomPaint = Paint()

        leftTopPaint.style = Paint.Style.FILL
        leftTopPaint.color = topLeftColor
        canvas?.drawRect(leftTop, leftTopPaint)

        leftBottomPaint.style = Paint.Style.FILL
        leftBottomPaint.color = bottomLeftColor
        canvas?.drawRect(leftBottom, leftBottomPaint)

        rightTopPaint.style = Paint.Style.FILL
        rightTopPaint.color = topRightColor
        canvas?.drawRect(rightTop, rightTopPaint)

        rightBottomPaint.style = Paint.Style.FILL
        rightBottomPaint.color = bottomRightColor
        canvas?.drawRect(rightBottom, rightBottomPaint)

        canvas?.drawCircle((width/2).toFloat(), (height /2).toFloat(),
            (width /5).toFloat(), circlePaint)

    }
}