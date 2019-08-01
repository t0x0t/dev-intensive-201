package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.widget.ImageView
import ru.skillbranch.devintensive.R
import androidx.annotation.Dimension
//import kotlinx.android.synthetic.main.activity_profile.view.*
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
//import androidx.core.content.res.ResourcesCompat.getColor
//import androidx.core.content.res.ResourcesCompat.getColorStateList
import androidx.core.graphics.drawable.toBitmap
//import androidx.core.graphics.toColor
//import ru.skillbranch.devintensive.App


class CircleImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) :
    ImageView(context, attrs, defStyleAttr) {


    private var f: Int = Color.WHITE
    private var CV_BORDERWIDTH = toDP(2)


    init {
        if (attrs != null) {
            Log.d("M_ProfileActivity", "$CV_BORDERWIDTH brd")

            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            f = a.getColor(R.styleable.CircleImageView_cv_borderColor, f)
            CV_BORDERWIDTH = a.getDimension(R.styleable.CircleImageView_cv_borderWidth, CV_BORDERWIDTH.toFloat()).toInt()

            Log.d("M_ProfileActivity", "$CV_BORDERWIDTH brd")

            a.recycle()
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var a = Paint(Paint.ANTI_ALIAS_FLAG)

        a.color = f

        var b = CV_BORDERWIDTH.toFloat()
        a.strokeWidth = b
        a.setStyle(Paint.Style.STROKE)


        var dra: Drawable? = ContextCompat.getDrawable(context, R.drawable.avatar_default)
        var bit = dra?.toBitmap(width, height) //width, height заменяют getWidth(), getHeight()



        var path = Path()
        path.addCircle((getWidth() / 2).toFloat(), (getHeight() / 2).toFloat(), (getHeight().toFloat() / 2), Path.Direction.CW)
        canvas.clipPath(path)

        canvas.drawBitmap(bit, 0f, 0f, a)
        canvas.drawCircle((getWidth() / 2).toFloat(), (getHeight() / 2).toFloat(), (toDP(getHeight()).toFloat() - (b / 2)), a)

    }

    @Dimension
    fun getBorderWidth(): Int = dpInPx2DpInDp(CV_BORDERWIDTH)

    fun setBorderWidth(@Dimension dp: Int) {
        CV_BORDERWIDTH = dp
        invalidate()
    }

    fun getBorderColor(): Int = f

    fun setBorderColor(hex: String) {
        f = Color.parseColor(hex)
        invalidate()
    }

    fun setBorderColor(@ColorRes colorId: Int) {
        f = ResourcesCompat.getColor(resources, colorId, context.theme)
            //ContextCompat.getColor(context, colorId)
        invalidate()
    }
//TODO вынести в утилитные методы
    //то, что ниже
    fun toDP(px: Int): Int {
        return (px * Resources.getSystem().displayMetrics.density).toInt()
    }

    fun dpInPx2DpInDp(dp: Int): Int {
        return (dp / Resources.getSystem().displayMetrics.density.toInt())
    }

}

