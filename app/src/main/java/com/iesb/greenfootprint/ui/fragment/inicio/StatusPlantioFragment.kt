package com.iesb.greenfootprint.ui.fragment.inicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentStatusPlantioBinding

class StatusPlantioFragment : Fragment() {

    private lateinit var plantioBinding: FragmentStatusPlantioBinding

    @Suppress("UNUSED_PARAMETER")
    fun send(v:View){

        // falta apontar ele para o banco de dados

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        plantioBinding = FragmentStatusPlantioBinding.inflate(inflater , container , false)
        plantioBinding.lifecycleOwner = this
        plantioBinding.fragment  = this

        return plantioBinding.root
    }

}