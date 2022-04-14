package com.example.baseproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.baseproject.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_home, container, false)

        view?.findViewById<Button>(R.id.btDataFragment)
            ?.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_dataFragment) }
        view?.findViewById<Button>(R.id.btTextFragment)
            ?.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_textFragment) }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
            }
    }
}