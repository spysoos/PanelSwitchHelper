package com.effective.android.panel.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.effective.android.panel.Constants
import com.effective.android.panel.LogTracker
import com.effective.android.panel.utils.DisplayUtil.dip2px
import com.effective.android.panel.utils.DisplayUtil.isPortrait
import com.effective.android.panel.view.PanelSwitchLayout

/**
 * panel helper
 * Created by yummyLau on 18-7-07
 * Email: yummyl.lau@gmail.com
 * blog: yummylau.com
 */
object PanelUtil {

    @JvmStatic
    fun showKeyboard(context: Context, view: View) {
        view.requestFocus()
        val mInputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        mInputManager.showSoftInput(view, 0)
    }

    @JvmStatic
    fun hideKeyboard(context: Context, view: View) {
        val mInputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        mInputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    @JvmStatic
    fun getKeyBoardHeight(context: Context): Int {
        val sp = context.getSharedPreferences(Constants.KB_PANEL_PREFERENCE_NAME, Context.MODE_PRIVATE)
        val isPortrait = isPortrait(context)
        val key = if (isPortrait) Constants.KEYBOARD_HEIGHT_FOR_P else Constants.KEYBOARD_HEIGHT_FOR_L
        val defaultHeight = if (isPortrait) Constants.DEFAULT_KEYBOARD_HEIGHT_FOR_P else Constants.DEFAULT_KEYBOARD_HEIGHT_FOR_L
        return sp.getInt(key, dip2px(context, defaultHeight))
    }

    @JvmStatic
    fun setKeyBoardHeight(context: Context, height: Int): Boolean {
        val sp = context.getSharedPreferences(Constants.KB_PANEL_PREFERENCE_NAME, Context.MODE_PRIVATE)
        val key = if (isPortrait(context)) Constants.KEYBOARD_HEIGHT_FOR_P else Constants.KEYBOARD_HEIGHT_FOR_L
        return sp.edit().putInt(key, height).commit()
    }
}