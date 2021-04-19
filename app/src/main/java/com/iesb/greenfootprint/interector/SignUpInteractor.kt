package com.iesb.greenfootprint.interector

import android.util.Log
import com.iesb.greenfootprint.domain.Email
import com.iesb.greenfootprint.domain.AuthUser

class SignUpInteractor  {

    val authUser: AuthUser = AuthUser("", "")
    val emailValidator: Email = Email("")

    fun createUserAndSignIn(email : String , pass : String , confirmPass : String) {
        authUser.email = email
        emailValidator.email = email
        authUser.password = pass

        if (pass != confirmPass) {
            Log.d("AUTH", "Wrong Password")
            throw Error("Confirm password is diferent than password")
        }

        if (emailValidator.isValid())
            authUser.createUserAndAuthenticate()
        else {
            Log.d("AUTH", "Invalid Email")
            throw Error("Invalid Email format")
        }
    }
}