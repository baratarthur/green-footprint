package com.iesb.greenfootprint.ui.fragment.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentLoginBinding
import com.iesb.greenfootprint.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding : FragmentMenuBinding

    @Suppress("UNUSED_PARAMETER")
    fun btLoginMenu(v : View){
        findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
    }
    @Suppress("UNUSED_PARAMETER")
    fun btCadastroMenu(v : View){
        findNavController().navigate(R.id.action_menuFragment_to_signUpFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater , container , false)
        binding.fragmentoMenu = this
        binding.lifecycleOwner = this


        return binding.root
    }


}