package ru.skillbranch.devintensive.ui.profile

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.view.*
import ru.skillbranch.devintensive.App
import ru.skillbranch.devintensive.models.Bender
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.Profile
import ru.skillbranch.devintensive.ui.custom.CircleImageView
import ru.skillbranch.devintensive.utils.Utils
import ru.skillbranch.devintensive.viewmodels.ProfileViewModel


class ProfileActivity : AppCompatActivity() {
    companion object {
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }

    private lateinit var viewModel: ProfileViewModel
    var isEditMode = false
    lateinit var viewFields: Map<String, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        //TODO set custom Theme This before super and setContentView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        //var a1 = findViewById<EditText>(R.id.et_first_name)
        //var t = et_first_name.text
        //Log.d("M_ProfileActivity", "${t}")
        //Log.d("M_ProfileActivity", "test ${R.id.et_first_name}")
        //a1.setBorderWidth(50)
        initViews(savedInstanceState)
        initViewModel()


        Log.d("M_ProfileActivity", "$viewFields")
        Log.d("M_ProfileActivity", " ")


    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putBoolean(IS_EDIT_MODE, isEditMode)

    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        viewModel.getProfileData().observe(this, Observer { updateUI(it) })
        viewModel.getTheme().observe(this, Observer { updateTheme(it) })


    }

    private fun updateTheme(mode: Int) {
        Log.d("M_ProfileActivity", "updateTheme")
        delegate.setLocalNightMode(mode)

    }

    private fun updateUI(profile: Profile) {
       // profile.toMap()
            for ((k, v) in viewFields) {
                v.text = profile.toMap()[k].toString()
                }

        //genAvaColorBmp(Utils.toInitials(profile.firstName, profile.lastName))
        iv_avatar.text = Utils.toInitials(profile.firstName, profile.lastName)
        genDrawable(Utils.toInitials(profile.firstName, profile.lastName))
        //var a = iv_avatar.getDrawable()
        var b = 0


        Log.d("M_ProfileActivity", "updateUI :: ${Utils.toInitials(profile.firstName, profile.lastName)}")
        //Log.d("M_ProfileActivity", "null A? :: $a")
    }



    private fun initViews(savedInstanceState: Bundle?) {

        viewFields = mapOf(
            "nickname" to tv_nick_name,
            "rank" to tv_rank,
            "firstName" to et_first_name,
            "lastName" to et_last_name,
            "about" to et_about,
            "repository" to et_repository,
            "rating" to tv_rating,
            "respect" to tv_respect
        )

        isEditMode = savedInstanceState?.getBoolean(IS_EDIT_MODE, false) ?: false
        showCurrentMode(isEditMode)

        //var a1 = findViewById<CircleImageView>(R.id.iv_avatar)
        //a1.setBackgroundColor(Color.BLACK)
        //var bb = 1

        btn_edit.setOnClickListener {
            if(isEditMode) saveProfileInfo()
            isEditMode = !isEditMode
            showCurrentMode(isEditMode)


            //a1.setBorderWidth(10)
            //a1.getBorderWidth()
            //bb++
            //Log.d("M_ProfileActivity", "bordWidd: $a1")
            //var bb1 = a1.getBorderWidth()
            //Log.d("M_ProfileActivity", "bordWidd1: $bb1")
            //a1.setBorderColor(R.color.color_gray_dark)

        }

        btn_switch_theme.setOnClickListener {
            viewModel.switchTheme()

        }
    }

    private fun showCurrentMode(isEdit: Boolean) {

        val info = viewFields.filter { setOf("firstName", "lastName", "about", "repository").contains(it.key) }
        for ((_, v) in info) {
            v as EditText
            v.isFocusable = isEdit
            v.isFocusableInTouchMode = isEdit
            v.isEnabled = isEdit
            v.background.alpha = if (isEdit) 255 else 0

        }

        ic_eye.visibility = if (isEdit) View.GONE else View.VISIBLE
        wr_about.isCounterEnabled = isEdit

        with(btn_edit) {
            val filter: ColorFilter? = if (isEdit) {
                PorterDuffColorFilter(
                    resources.getColor(R.color.color_accent, theme),
                    PorterDuff.Mode.SRC_IN
                )
            } else {
                null
            }

            val icon = if (isEdit) {
                resources.getDrawable(R.drawable.ic_save_black_24dp, theme)
            } else {
                resources.getDrawable(R.drawable.ic_edit_black_24dp, theme)
            }

            background.colorFilter = filter
            setImageDrawable(icon)
        }
    }

    private fun saveProfileInfo() {
        Profile(
            firstName = et_first_name.text.toString(),
            lastName = et_last_name.text.toString(),
            about = et_about.text.toString(),
            repository = et_repository.text.toString()
        ).apply {
                viewModel.saveProfileData(this)
        }
    }

    private fun genDrawable(initials:String?) {
        if (initials == null) return
        else {
            var px = Utils.convertDpToPx(App.applicationContext(), 112)
            var holstBmp = Bitmap.createBitmap(px, px, Bitmap.Config.ARGB_8888)
            var canvas = Canvas(holstBmp)
            var a = Paint(Paint.ANTI_ALIAS_FLAG)
            a.setStyle(Paint.Style.FILL)
            val color = TypedValue()

            theme.resolveAttribute(R.attr.colorAccent, color, true)
            a.setColor(color.data)

            canvas.drawCircle(px.toFloat()/2, px.toFloat()/2, (px.toFloat() / 2), a)

            a.color = Color.WHITE
            a.textSize = px.toFloat()/2
            a.textAlign = Paint.Align.CENTER

            canvas.drawText(initials!!, (px.toFloat() / 2), ((px.toFloat() / 2) - ((a.descent() + a.ascent()) / 2)), a)
            canvas.drawBitmap(holstBmp, 0f, 0f, a)
            iv_avatar.setImageDrawable(BitmapDrawable(getResources(), holstBmp))
        }
    }

}
