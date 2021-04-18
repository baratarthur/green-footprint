package com.iesb.greenfootprint.domain

import com.google.firebase.auth.FirebaseAuth

open class AuthUser {

    private val auth = FirebaseAuth.getInstance()

    fun Auth_Cadastro(email : String , senha : String ) : Boolean {


        val taskDeCadastro = auth.createUserWithEmailAndPassword(email , senha)
        taskDeCadastro.addOnCompleteListener{
                resultado ->
            if (resultado.isSuccessful){


            }
            else{
                // Toast.makeText(this, "Falha no cadastro" , Toast.LENGTH_LONG).show()
            }
        }

        return true
    }

    fun Auth_login(email: String , senha: String) : Boolean{


        val taskdeLogin = auth.signInWithEmailAndPassword(email , senha)
        taskdeLogin.addOnCompleteListener{

        }
        return true
    }

    fun Auth_forgot(email: String): Boolean{

        val taskforgot = auth.sendPasswordResetEmail(email)
        taskforgot.addOnCompleteListener{

        }

        return true
    }


}