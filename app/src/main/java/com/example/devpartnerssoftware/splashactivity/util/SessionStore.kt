package com.example.devpartnerssoftware.splashactivity.util

import android.content.Context

/**
 * Created by DEVPARTNERS SOFTWARE on 9/26/2017.
 */
class SessionStore {
    val KEY_USER_EMAIL = "email"

    fun saveEmail(email: String, context: Context){

        val editor = context
                .getSharedPreferences(KEY_USER_EMAIL,
                                        Context.MODE_PRIVATE)
                .edit()
        editor.putString(KEY_USER_EMAIL, email)
        editor.apply()
    }

    fun restoreEmail(context: Context) : String {
        val prefs = context.getSharedPreferences(KEY_USER_EMAIL,
                                                Context.MODE_PRIVATE)
        return prefs.getString(KEY_USER_EMAIL,"")
    }

    fun clearEmail(context: Context){
        val editor = context
                .getSharedPreferences(KEY_USER_EMAIL,
                        Context.MODE_PRIVATE)
                .edit()
        editor.clear()
        editor.apply()
    }
}