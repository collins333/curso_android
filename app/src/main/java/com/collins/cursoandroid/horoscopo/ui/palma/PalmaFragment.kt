package com.collins.cursoandroid.horoscopo.ui.palma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.collins.cursoandroid.databinding.FragmentPalmaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmaFragment : Fragment() {

    private var _binding: FragmentPalmaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}