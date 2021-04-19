package com.iesb.greenfootprint.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iesb.greenfootprint.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    btLogin.setOnClickListener{
        login()
    }
    tvForgotPassword.setOnClickListener{

    }

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    private fun login() {

        val email = twEmailLogin.text.toString()
        val senha = twPasswordLogin.text.toString()

    }

}