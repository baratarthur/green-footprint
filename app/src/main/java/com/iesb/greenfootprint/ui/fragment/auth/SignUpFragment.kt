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
import com.iesb.greenfootprint.databinding.FragmentSignUpBinding
import com.iesb.greenfootprint.domain.RegisterForm
import com.iesb.greenfootprint.domain.RegisterResult
import com.iesb.greenfootprint.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private lateinit var binding : FragmentSignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSignUpBinding.inflate(inflater , container , false)
        binding.lifecycleOwner = this
        binding.signUpFragment = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                is RegisterResult.Success -> {
                    findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                }
                is RegisterResult.Fail -> {
                    Toast.makeText(context, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun gotoLogin(view : View) {
        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment )
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAccount(view : View) {
        try {
            val form = RegisterForm(
                binding.twEmail.text.toString(),
                binding.twPassword.text.toString(),
                binding.twConfirmPassword.text.toString()
            )

            viewModel.registerUser(form)
        } catch (e: Error) {
            Log.d("ERROR", e.message.toString())
        }
    }

}