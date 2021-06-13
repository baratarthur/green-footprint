package com.iesb.greenfootprint.domain

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.iesb.greenfootprint.ui.activity.MainActivity

open class AuthUser(var email: String, var password: String) {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun requestPassword() {
        if(email == ""){
            throw Error("Email are empty")
        }
        else {
            val taskforgot = auth.sendPasswordResetEmail(email)
            taskforgot.addOnCompleteListener {
                if (taskforgot.isSuccessful) {
                    Log.d("FIRE", "Email Sent")
                }
            }
        }
    }


}