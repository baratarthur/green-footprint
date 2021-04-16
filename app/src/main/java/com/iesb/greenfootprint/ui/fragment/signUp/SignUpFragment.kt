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
import javax.inject.Inject

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

        binding = FragmentSignUpBinding.inflate(inflater , container , false)
        binding.lifecycleOwner = this
        binding.twEmail
        binding.twSenha
        binding.twConfimaSenha
        binding.btSingUp.setOnClickListener{   }
        binding.voltar



        return binding.root
    }


}