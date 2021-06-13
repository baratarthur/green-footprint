package com.iesb.greenfootprint.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentOnboardingFisrtPresentationBinding

class OnboardingFisrtPresentationFragment : Fragment() {

    private lateinit var biding: FragmentOnboardingFisrtPresentationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        biding = FragmentOnboardingFisrtPresentationBinding.inflate(inflater, container, false)
        biding.lifecycleOwner = this

        return biding.root
    }

}