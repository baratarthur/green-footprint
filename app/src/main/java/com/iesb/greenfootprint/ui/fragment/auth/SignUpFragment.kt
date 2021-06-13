package com.iesb.greenfootprint.ui.fragment.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentSignUpBinding
import com.iesb.greenfootprint.interector.SignUpInteractor
import javax.inject.Inject

class SignUpFragment : Fragment() {

    private lateinit var SignUpbinding : FragmentSignUpBinding
    @Inject lateinit var auth : FirebaseAuth

    @Suppress("UNUSED_PARAMETER")
    fun gotoLogin(view : View) {
        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment )
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAccountAndGotoLogin(view : View) {
        createAccount()
        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        SignUpbinding = FragmentSignUpBinding.inflate(inflater , container , false)
        SignUpbinding.lifecycleOwner = this
        SignUpbinding.signUpFragment = this

        return SignUpbinding.root
    }

    private fun createAccount(){
        val email = SignUpbinding.twEmail.text.toString()
        val senha = SignUpbinding.twPassword.text.toString()
        val confirmSenha = SignUpbinding.twConfirmPassword.text.toString()
        val signUpInteractor = SignUpInteractor()

        try {
            signUpInteractor.createUserAndSignIn(email, senha, confirmSenha)
        } catch (err: Error) {
            Log.d("ERROR", err.message.toString())
            //Toast.makeText(this, "Problemas na criacao de conta", Toast.LENGTH_LONG).show()
        }
    }

}