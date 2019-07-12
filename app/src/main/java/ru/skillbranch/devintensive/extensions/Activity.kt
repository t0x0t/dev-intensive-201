package ru.skillbranch.devintensive.extensions
import  android.app.*
import android.content.Context
import android.view.inputmethod.InputMethodManager




fun Activity.hideKeyboard(){
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

