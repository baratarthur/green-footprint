package com.iesb.greenfootprint.interector

import android.util.Log
import com.iesb.greenfootprint.domain.AuthUser
import com.iesb.greenfootprint.domain.Email

class SigninInteractor {

    val authUser: AuthUser = AuthUser("", "")
    val emailValidator: Email = Email("")

    fun signinWithUser(email : String , pass : String) {
        authUser.email = email
        emailValidator.email = email
        authUser.password = pass

        if (emailValidator.isValid())
            authUser.signIn()
        else {
            Log.d("AUTH", "Invalid Email")
            throw Error("Invalid Email format")
        }
    }

}