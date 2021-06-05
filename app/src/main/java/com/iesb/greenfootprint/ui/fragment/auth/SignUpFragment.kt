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

    private lateinit var binding : FragmentSignUpBinding
    @Inject lateinit var auth : FirebaseAuth

    @Suppress("UNUSED_PARAMETER")
    fun cadastroLogin(view : View){

        cadastramento()
        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSignUpBinding.inflate(inflater , container , false)
        binding.lifecycleOwner = this
        binding.btSingUp.setOnClickListener{

        }
        return binding.root
    }

    private fun cadastramento(){
        val email = binding.twEmail.text.toString()
        val senha = binding.twPassword.text.toString()
        val confirmSenha = binding.twConfirmPassword.text.toString()
        val signUpInteractor = SignUpInteractor()

        try {
            signUpInteractor.createUserAndSignIn(email, senha, confirmSenha)
        } catch (err: Error) {
            Log.d("ERROR", err.message.toString())
            //Toast.makeText(this, "Problemas na criacao de conta", Toast.LENGTH_LONG).show()
        }
    }

}