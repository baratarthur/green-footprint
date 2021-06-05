package com.iesb.greenfootprint.ui.fragment.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentLoginBinding
import com.iesb.greenfootprint.interector.SigninInteractor


class LoginFragment : Fragment() {

    private lateinit var Loginbinding: FragmentLoginBinding

    @Suppress("UNUSED_PARAMETER")
    fun loginButton(v : View) {
        login()
        findNavController().navigate(R.id.action_loginFragment_to_nav_app)
    }
    @Suppress("UNUSED_PARAMETER")
    fun Forgot(v: View){
        findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Loginbinding = FragmentLoginBinding.inflate(inflater , container , false)
        Loginbinding.fragmento = this
        Loginbinding.lifecycleOwner = this

        return Loginbinding.root
    }

    private fun login(){
        val email = Loginbinding.twEmailLogin.text.toString()
        val senha = Loginbinding.twPasswordLogin.text.toString()
        val signinInteractor = SigninInteractor()

        try {
            signinInteractor.signinWithUser(email, senha)
            Log.d("auth", "user logged with success")
            //val ChamadaMenu = Intent(this, MenuAppActivity::class.java)
            //startActivity(ChamadaMenu)

        } catch (err: Error) {
            Log.d("ERROR", err.message.toString())
            //Toast.makeText(this, "Email ou Senha errados", Toast.LENGTH_LONG).show()
        }
    }

}