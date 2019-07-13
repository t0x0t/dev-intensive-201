package ru.skillbranch.devintensive.extensions
import  android.app.*
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.MainActivity


fun Activity.hideKeyboard(){
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Activity.isKeyboardOpen():Boolean
{
    var visibleBounds = Rect()
    this.findViewById<View>(android.R.id.content).getWindowVisibleDisplayFrame(visibleBounds)
    Log.d("M_MainActivity", "$visibleBounds")
    val heightDiff = this.findViewById<View>(android.R.id.content).height - visibleBounds.height ()
    Log.d("M_MainActivity", "${this.findViewById<View>(android.R.id.content)}")
    val isOpen = heightDiff>0
        Log.d("M_MainActivity", "SoftKB_Open = $isOpen")
    return isOpen

    }

    fun Activity.isKeyboardClosed():Boolean
    {
        return !this.isKeyboardOpen()
    }

