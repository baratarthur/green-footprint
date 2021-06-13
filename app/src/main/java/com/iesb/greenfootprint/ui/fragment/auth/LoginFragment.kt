package com.iesb.greenfootprint.ui.fragment.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentLoginBinding
import com.iesb.greenfootprint.domain.LoginForm
import com.iesb.greenfootprint.domain.LoginResult
import com.iesb.greenfootprint.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater , container , false)
        binding.fragment = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                is LoginResult.Success -> {
                    findNavController().navigate(R.id.action_loginFragment_to_nav_app)
                }
                is LoginResult.Fail -> {
                    Toast.makeText(context, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun forgot(v: View){
        findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
    }

    @Suppress("UNUSED_PARAMETER")
    fun login(view: View) {
        val form = LoginForm(
            binding.twEmailLogin.text.toString(),
            binding.twPasswordLogin.text.toString()
        )

        viewModel.login(form)
    }

}
