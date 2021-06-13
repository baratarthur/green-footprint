package com.iesb.greenfootprint.ui.fragment.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentForgotBinding
import com.iesb.greenfootprint.databinding.FragmentLoginBinding
import com.iesb.greenfootprint.domain.ForgotPasswordForm
import com.iesb.greenfootprint.domain.ForgotPasswordResult
import com.iesb.greenfootprint.domain.LoginResult
import com.iesb.greenfootprint.interector.ForgotInteractor
import com.iesb.greenfootprint.viewmodel.ForgotPasswordViewModel
import com.iesb.greenfootprint.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotFragment : Fragment() {

    private lateinit var Forgotbinding : FragmentForgotBinding
    private val viewModel: ForgotPasswordViewModel by viewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                is ForgotPasswordResult.Success -> {
                    findNavController().navigate(R.id.action_forgotFragment_to_loginFragment)
                }
                is ForgotPasswordResult.Fail -> {
                    Toast.makeText(context, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun requestPassword(v : View){
        val form = ForgotPasswordForm(
            Forgotbinding.twEmailForgotPassword.text.toString()
        )

        viewModel.requestPassword(form)
    }

}