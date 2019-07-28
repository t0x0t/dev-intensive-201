package ru.skillbranch.devintensive.extensions
import  android.app.*
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager


fun Activity.hideKeyboard(){
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Activity.isKeyboardOpen():Boolean
{
    /* ТАК ПОНЯТНЕЕ
    val viewFrame = findViewById<View>(android.R.id.content) либо findViewById(android.R.id.content) as View
        val rect = Rect()
    viewFrame.getWindowVisibleDisplayFrame(rect)*/

    var visibleBounds = Rect()
    var test = Rect()
    Log.d("M_MainActivity", "$visibleBounds")
    this.findViewById<View>(android.R.id.content).getWindowVisibleDisplayFrame(visibleBounds)
    Log.d("M_MainActivity", "visDispFram $visibleBounds")



    var VB = Rect()
    this.findViewById<View>(android.R.id.content).getGlobalVisibleRect(VB)
    Log.d("M_MainActivity", "globVisRect $visibleBounds")

    Log.d("M_MainActivity", "android.R.id.content height ${this.findViewById<View>(android.R.id.content).height}")

    val heightDiff = this.findViewById<View>(android.R.id.content).height - visibleBounds.height ()
    val isOpen = heightDiff>0
        Log.d("M_MainActivity", "SoftKB_Open = $isOpen")
    return isOpen

    }

    fun Activity.isKeyboardClosed():Boolean
    {
        return !this.isKeyboardOpen()
    }

