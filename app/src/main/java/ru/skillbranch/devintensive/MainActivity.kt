package ru.skillbranch.devintensive

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.extensions.hideKeyboard
import ru.skillbranch.devintensive.models.Bender
import  android.view.inputmethod.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var benderImage: ImageView
    lateinit var textTXT: TextView
    lateinit var messageEt: EditText
    lateinit var sendBtn: ImageView
    lateinit var benderObj: Bender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click_on_done()
        benderImage = iv_bender
        textTXT = tv_text
        messageEt = et_message
        sendBtn = iv_send
        val status = savedInstanceState?.getString("STATUS") ?: Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION") ?: Bender.Question.NAME.name

        //                         /
        val nn = savedInstanceState?.getInt("N") ?: Bender().n
        //                          /

        benderObj = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question), nn)
        Log.d("M_MainActivity", "onCreate $status $question $nn")
        val (r, g, b) = benderObj.status.color
        benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)
        textTXT.text = benderObj.askQuestion()
        sendBtn.setOnClickListener(this)


    }


    override fun onRestart() {
        super.onRestart()
        Log.d("M_MainActivity", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("M_MainActivity", "onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.d("M_MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("M_MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("M_MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("M_MainActivity", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        benderObj.n?.let { outState?.putInt("N", it) }
        outState?.putString("STATUS", benderObj.status.name)
        outState?.putString("QUESTION", benderObj.question.name)
        Log.d("M_MainActivity", "onSaveInstanceState ${benderObj.status.name} ${benderObj.question.name}")

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.iv_send) {
            val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
            messageEt.setText("")
            val (r, g, b) = color
            benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)
            textTXT.text = phrase
        }
    }

    fun click_on_done()
    {
        et_message.setOnEditorActionListener() { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
                messageEt.setText("")
                val (r, g, b) = color
                benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)
                textTXT.text = phrase
                hideKeyboard()
                Log.d("M_MainActivity", "Клик по DONE")
                true
            } else {
                false
            }
        }
    }
}
