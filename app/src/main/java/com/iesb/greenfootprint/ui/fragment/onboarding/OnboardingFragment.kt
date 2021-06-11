package com.iesb.greenfootprint.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentOnboardingBinding
import com.iesb.greenfootprint.ui.fragment.onboarding.screen.OnboardingFisrtPresentationFragment
import com.iesb.greenfootprint.ui.fragment.onboarding.screen.OnboardingSecondPresentationFragment

class OnboardingFragment : Fragment() {

    lateinit var biding: FragmentOnboardingBinding

    @Suppress("UNUSED_PARAMETER")
    fun goToCreateAccount(v: View) {
        findNavController().navigate(R.id.action_onboardingFragment_to_signUpFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding = FragmentOnboardingBinding.inflate(inflater, container, false)
        biding.lifecycleOwner = this
        biding.ondoardingFragment = this

        val fragments = listOf(
            OnboardingFisrtPresentationFragment(),
            OnboardingSecondPresentationFragment()
        )

        biding.vpOnboarding.adapter = OnboardingAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        return biding.root
    }

    class OnboardingAdapter(
        private val fragmentList: List<Fragment>,
        fragmentManager: FragmentManager,
        lifeCycle: Lifecycle
    ) : FragmentStateAdapter(fragmentManager, lifeCycle) {
        override fun getItemCount() = fragmentList.size
        override fun createFragment(position: Int) = fragmentList[position]
    }


}
