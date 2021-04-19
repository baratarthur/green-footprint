package com.iesb.greenfootprint.domain

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.iesb.greenfootprint.ui.activity.MainActivity

open class AuthUser(var email: String, var password: String) {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun createUserAndAuthenticate() {
        if (email == "" || password == "") {
            throw Error("email or password are empty")
        } else {
            auth.createUserWithEmailAndPassword(email , password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        Log.d("FIRE", "User created successfully")
                        this.signIn()
                    } else {
                        Log.d("FIRE", "Problems with creation")
                        throw Error(task.exception?.message.toString())
                    }
                }
        }
    }

    fun signIn() {
        if (email == "" || password == "") {
            throw Error("email or password are empty")
        } else {
            val loginTask = auth.signInWithEmailAndPassword(email, password)
            loginTask.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FIRE", "User signed in successfully")
                }
            }
        }
    }

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