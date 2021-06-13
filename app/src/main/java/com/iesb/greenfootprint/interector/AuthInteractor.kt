package com.iesb.greenfootprint.interector

import android.util.Log
import com.iesb.greenfootprint.domain.*
import com.iesb.greenfootprint.repository.AuthRepository
import java.util.regex.Pattern
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val repo: AuthRepository
) {
    suspend fun registerUser(form: RegisterForm): RegisterResult {
        return if (form.password == form.confirmPassword) {
            if (isValid(form.email)) {
                repo.registerUser(form)
            } else {
                Log.d("AUTH", "Invalid Email")
                RegisterResult.Fail("Invalid Email")
            }
        } else {
            Log.d("AUTH", "Passwords don't match")
            RegisterResult.Fail("Passwords don't match")
        }
    }

    suspend fun login(form: LoginForm): LoginResult {
        return if(isValid(form.email)){
            repo.login(form)
        } else {
            Log.d("AUTH", "email dont match")
            LoginResult.Fail("Email incoreto, por favor verifique o formato do email!")
        }
    }

    suspend fun requestPassword(form: ForgotPasswordForm): ForgotPasswordResult {
        return if(isValid(form.email)) {
            repo.requestPassword(form)
        } else {
            Log.d("AUTH", "email dont match")
            ForgotPasswordResult.Fail("Email incoreto, por favor verifique o formato do email!")
        }
    }

    private fun isValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }
}