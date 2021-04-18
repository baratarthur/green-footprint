package com.iesb.greenfootprint.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.domain.AuthUser
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    bt_Login.setOnClickListener{
        login()
    }
    tw_forgot.setOnClickListener{

    }

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    private fun login() {

        val email = tw_Email.text.toString()
        val senha = tw_Senha.text.toString()
        val auth = AuthUser()

        auth.Auth_login(email , senha)

    }

}