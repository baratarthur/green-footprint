package com.iesb.greenfootprint.interector

import android.util.Log
import com.iesb.greenfootprint.domain.AuthUser

class ForgotInteractor {

    val authUser: AuthUser = AuthUser("", "")
    lateinit var emailValidator: String

    fun signinWithUser(email : String ) {
        authUser.email = email
        emailValidator = email


            authUser.requestPassword()
    }

}