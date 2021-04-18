package com.iesb.greenfootprint.interector

import android.widget.Toast
import com.iesb.greenfootprint.domain.AuthEmail
import com.iesb.greenfootprint.domain.AuthUser

class SignUpInteractor  {

    fun validaSignUp(email : String? , senha : String? , confirmSenha : String?) {
        val authUser = AuthUser()
        val validador = AuthEmail()

        if (senha != confirmSenha) {
            // Toast.makeText(this, "Senha inválida", Toast.LENGTH_LONG).show()
            return
        }
        if (!validador.isEmailValid(email.toString())) {  // colocar condição de email inválido aqui dentro
            //Toast.makeText(this, "Email inválido", Toast.LENGTH_LONG).show()
            return
        } else {
            authUser.Auth_Cadastro( email.toString(), senha.toString() )

        }
    }
}