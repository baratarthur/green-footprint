package com.iesb.greenfootprint.repository

import com.google.firebase.auth.FirebaseAuth
import com.iesb.greenfootprint.domain.*
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthRepository @Inject constructor() {

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun registerUser(form: RegisterForm): RegisterResult = suspendCoroutine { nextStep ->
        auth.createUserWithEmailAndPassword(form.email , form.password)
            .addOnCompleteListener { task ->
                val result = if (task.isSuccessful) {
                    RegisterResult.Success()
                } else {
                    RegisterResult.Fail("usuario ja registrado")
                }
                nextStep.resume(result)
            }
    }

    suspend fun login(form: LoginForm): LoginResult = suspendCoroutine { nextStep ->
        auth.signInWithEmailAndPassword(form.email , form.password)
            .addOnCompleteListener { task ->
                val result = if (task.isSuccessful) {
                    LoginResult.Success()
                } else {
                    LoginResult.Fail("usuario ou senha incorretos")
                }
                nextStep.resume(result)
            }
    }

    suspend fun requestPassword(form: ForgotPasswordForm): ForgotPasswordResult = suspendCoroutine {
            nextStep ->
            auth.sendPasswordResetEmail(form.email)
                .addOnCompleteListener { task ->
                    val result = if (task.isSuccessful) {
                        ForgotPasswordResult.Success()
                    } else {
                        ForgotPasswordResult.Fail("usuario ou senha incorretos")
                    }
                    nextStep.resume(result)
                }
    }
}