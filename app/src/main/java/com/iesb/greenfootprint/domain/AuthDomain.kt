package com.iesb.greenfootprint.domain

data class RegisterForm (
    var email: String,
    var password: String,
    var confirmPassword: String
)

data class LoginForm (
    var email: String,
    var password: String
)

data class ForgotPasswordForm (
    var email: String
)


sealed class RegisterResult {
    data class Success(val value: Boolean = true): RegisterResult()
    data class Fail(val msg: String? = null, val value: Boolean = false): RegisterResult()
}

sealed class LoginResult {
    data class Success(val value: Boolean = true): LoginResult()
    data class Fail(val msg: String? = null, val value: Boolean = false): LoginResult()
}

sealed class ForgotPasswordResult {
    data class Success(val value: Boolean = true): ForgotPasswordResult()
    data class Fail(val msg: String? = null, val value: Boolean = false): ForgotPasswordResult()
}

