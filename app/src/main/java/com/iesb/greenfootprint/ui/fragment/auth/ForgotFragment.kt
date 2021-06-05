package com.iesb.greenfootprint.ui.fragment.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentForgotBinding
import com.iesb.greenfootprint.databinding.FragmentLoginBinding
import com.iesb.greenfootprint.interector.ForgotInteractor

class ForgotFragment : Fragment() {

    private lateinit var Forgotbinding : FragmentForgotBinding

    @Suppress("UNUSED_PARAMETER")
    fun enviar(v : View){

        envio()
        findNavController().navigate(R.id.action_forgotFragment_to_loginFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Forgotbinding = FragmentForgotBinding.inflate(inflater , container , false)
        Forgotbinding.fragment = this
        Forgotbinding.lifecycleOwner = this


        return Forgotbinding.root

    }

    private fun envio(){

        val email = Forgotbinding.twEmailForgotPassword.text.toString()
        val ForgotinInteractor = ForgotInteractor()

        try {
            ForgotinInteractor.signinWithUser(email)
            Log.d("auth", "")
        } catch (err: Error) {
            Log.d("ERROR", err.message.toString())
           // Toast.makeText(this, "Erro no envio do Email", Toast.LENGTH_LONG).show()

        }
    }

}