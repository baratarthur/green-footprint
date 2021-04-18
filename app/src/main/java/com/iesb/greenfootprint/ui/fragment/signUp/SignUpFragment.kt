package com.iesb.greenfootprint.ui.fragment.signUp

import android.os.Bundle
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
import kotlin.math.sign

class SignUpFragment : Fragment() {

    private lateinit var binding : FragmentSignUpBinding
    @Inject lateinit var auth : FirebaseAuth

    fun retornar(view : View){
        //findNavController().navigate(R.id. **nome da action para tela introdutoria do app** )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val signInteraction = SignUpInteractor()

        binding = FragmentSignUpBinding.inflate(inflater , container , false)
        binding.lifecycleOwner = this
        val strEmail = binding.twEmail.text.toString()
        val strSenha = binding.twSenha.text.toString()
        val strConfirmSenha =binding.twConfimaSenha.text.toString()
        binding.btSingUp.setOnClickListener{
            signInteraction.validaSignUp(strEmail,strSenha,strConfirmSenha)
        }
        binding.voltar



        return binding.root
    }


}