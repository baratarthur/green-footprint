package com.iesb.greenfootprint.ui.fragment.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iesb.greenfootprint.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : Fragment() {

    private lateinit var binding : FragmentSplashScreenBinding

    @Suppress("UNUSED_PARAMETER")
    fun splashMenu(v : View){
       // findNavController().navigate(R.id.action_splashScreenFragment_to_menuFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        GlobalScope.launch(context = Dispatchers.Main) {
            delay(2500)
            chamaMenu()
        }

        return binding.root
    }

    private fun chamaMenu(){
       // val ChamadaMenu = Intent(this, MenuFragment::class.java)
       // startActivity(ChamadaMenu)
    }
}