package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.widget.ImageView
import ru.skillbranch.devintensive.R
//import kotlinx.android.synthetic.main.activity_profile.view.*
import android.graphics.*
import android.graphics.drawable.Drawable
import android.media.Image
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.widget.EditText
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.createBitmap
//import androidx.core.content.res.ResourcesCompat.getColor
//import androidx.core.content.res.ResourcesCompat.getColorStateList
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.drawToBitmap
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.view.*
import ru.skillbranch.devintensive.models.Profile
import ru.skillbranch.devintensive.ui.profile.ProfileActivity
import android.graphics.*
import android.graphics.Bitmap.Config
import android.graphics.PorterDuff.Mode
import android.graphics.drawable.BitmapDrawable

import androidx.annotation.ColorRes

import ru.skillbranch.devintensive.App
import ru.skillbranch.devintensive.utils.Utils
import kotlin.math.min
//import androidx.core.graphics.toColor
//import ru.skillbranch.devintensive.App


class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) :
    ImageView(
        context,
        attrs,
        defStyleAttr
    ) {


    var f: Int = Color.WHITE
    var CV_BORDERWIDTH = dpToPx(context, 2)

    var holstBmp = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
    var canvas = Canvas(holstBmp)
    var text: String? = null


    init {
        if (attrs != null) {
            Log.d("M_ProfileActivity", "$CV_BORDERWIDTH brd")

            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            f = a.getColor(R.styleable.CircleImageView_cv_borderColor, f)
            CV_BORDERWIDTH =
                a.getDimension(R.styleable.CircleImageView_cv_borderWidth, CV_BORDERWIDTH.toFloat()).toInt()
            Log.d("M_ProfileActivity", "$CV_BORDERWIDTH brd")

            a.recycle()

        }
    }


    override fun onDraw(canvas: Canvas) {

        holstBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        this.canvas = Canvas(holstBmp)

        canvas.drawBitmap(holstBmp, 0f ,0f ,null)
        //iv_avatar.setImageDrawable(BitmapDrawable(getResources(), holstBmp))


        if (text != null) {
            createAvatar(text)
        } else {
            defAvatarWithBorder()

        }
    }



    fun defAvatarWithBorder() {
        Log.d("M_ProfileActivity", "Tama!!!")
        var a = Paint(Paint.ANTI_ALIAS_FLAG)
        Log.d("M_ProfileActivity", "$CV_BORDERWIDTH brd1")
        a.color = f

        var b = CV_BORDERWIDTH.toFloat()
        a.strokeWidth = b
        a.setStyle(Paint.Style.STROKE)


        var dra: Drawable? = ContextCompat.getDrawable(context, R.drawable.avatar_default)
        var bit = dra?.toBitmap(width, height) //width, height заменяют getWidth(), getHeight()


        var path = Path()
        path.addCircle(
            (getWidth() / 2).toFloat(),
            (getHeight() / 2).toFloat(),
            (getHeight().toFloat() / 2),
            Path.Direction.CW
        )
        canvas.clipPath(path)
        canvas.drawBitmap(bit!!, 0f, 0f, a)
        canvas.drawCircle(
            (getWidth()).toFloat() / 2,
            (getHeight()).toFloat() / 2,
            ((getHeight()).toFloat() / 2) - (b / 2),
            a
        )
    }

    fun createAvatar(initials: String?, theme:Resources.Theme = context.theme) {

            //var outputBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            //canvas = Canvas(outputBmp)
            /*var a = Paint(Paint.ANTI_ALIAS_FLAG)
            a.setStyle(Paint.Style.FILL)
            val color = TypedValue()

            theme.resolveAttribute(R.attr.colorAccent, color, true)
            a.setColor(color.data)

            canvas.drawCircle(height.toFloat() / 2, width.toFloat() / 2, height.toFloat() / 2, a)

            a.color = Color.WHITE
            a.textSize = (height / 2).toFloat()
            a.textAlign = Paint.Align.CENTER

            canvas.drawText(initials!!, (height.toFloat() / 2), ((height / 2) - ((a.descent() + a.ascent()) / 2)), a)
            canvas.drawBitmap(holstBmp, 0f, 0f, null)
        Log.d("M_ProfileActivity", ":: $height :: $width ::")
            //setImageDrawable(BitmapDrawable(getResources(), holstBmp))
    */
        iv_avatar.drawable.draw(canvas)
    }

    @Dimension
    fun getBorderWidth(): Int {
        Log.d("M_ProfileActivity", "getBorder = ${pxToDp(context, CV_BORDERWIDTH)}")
        return pxToDp(context, CV_BORDERWIDTH)
    }

    fun setBorderWidth(@Dimension dp: Int) {
        Log.d("M_ProfileActivity", "setBorder = ${dpToPx(context, CV_BORDERWIDTH)}")
        CV_BORDERWIDTH = dpToPx(context, dp)
        this.invalidate()
    }

    fun getBorderColor(): Int = f

    fun setBorderColor(hex: String) {
        f = Color.parseColor(hex)
        invalidate()
    }

    fun setBorderColor(@ColorRes colorId: Int) {
        f = ContextCompat.getColor(context, colorId)
        invalidate()
    }

////////////////////////////////
//
//
//TODO вынести в утилитные методы
    //то, что ниже

    fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density + 0.5f).toInt()
    }

    fun pxToDp(context: Context, px: Int): Int {

        return (px / context.resources.displayMetrics.density + 0.5f).toInt()
    }

}


