package com.iesb.greenfootprint.ui.fragment.inicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentMenuInicialBinding


class MenuInicialFragment : Fragment() {

     private lateinit var inicialBinding: FragmentMenuInicialBinding

     @Suppress("UNUSED_PARAMETER")
     fun NovoStatus(v : View){

         findNavController().navigate(R.id.action_menuInicialFragment_to_mapsFragment)
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        inicialBinding = FragmentMenuInicialBinding.inflate(inflater , container , false)
        inicialBinding.fragment = this
        inicialBinding.lifecycleOwner = this


        return inicialBinding.root
    }


}