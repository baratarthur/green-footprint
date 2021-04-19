package com.iesb.greenfootprint.interector

import android.util.Log
import com.iesb.greenfootprint.domain.AuthUser
import com.iesb.greenfootprint.domain.Email

class ForgotInteractor {

    val authUser: AuthUser = AuthUser("", "")
    val emailValidator: Email = Email("")

    fun signinWithUser(email : String ) {
        authUser.email = email
        emailValidator.email = email

        if (emailValidator.isValid())
            authUser.requestPassword()
        else {
            Log.d("AUTH", "Invalid Email")
            throw Error("Invalid Email format")
        }
    }

}