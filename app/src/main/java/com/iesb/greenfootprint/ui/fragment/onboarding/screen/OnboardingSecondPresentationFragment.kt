package com.iesb.greenfootprint.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iesb.greenfootprint.databinding.FragmentOnboardingSecondPresentationBinding


class OnboardingSecondPresentationFragment : Fragment() {

    lateinit var biding: FragmentOnboardingSecondPresentationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding = FragmentOnboardingSecondPresentationBinding.inflate(inflater, container, false)
        biding.lifecycleOwner = this

        return biding.root
    }

}