package com.iesb.greenfootprint.domain

import android.content.Intent
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
        val loginTask = auth.signInWithEmailAndPassword(email , password)
        loginTask.addOnCompleteListener{ task ->
            if(task.isSuccessful){
                Log.d("FIRE", "User signed in successfully")
            }
        }
    }

    fun requestPassword() {
        val taskforgot = auth.sendPasswordResetEmail(email)
        taskforgot.addOnCompleteListener{

        }
    }


}