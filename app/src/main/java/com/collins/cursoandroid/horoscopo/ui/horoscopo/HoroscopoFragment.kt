package com.collins.cursoandroid.horoscopo.ui.horoscopo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.collins.cursoandroid.databinding.FragmentHoroscopoBinding
import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo
import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo.*
import com.collins.cursoandroid.horoscopo.ui.horoscopo.adaptador.HoroscopoAdaptador
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel> ()
    private lateinit var adaptador: HoroscopoAdaptador

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarUI()
    }

    private fun iniciarUI() {
        iniciarEstadoUI()
        iniciarLista()
    }

    private fun iniciarLista() {
        adaptador = HoroscopoAdaptador(itemSeleccionado = { Toast.makeText(context, getString(it.nombre), Toast.LENGTH_LONG).show() })

        binding.rvHoroscopoFragment.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adaptador
        }
    }

    private fun iniciarEstadoUI() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoViewModel.horoscopo.collect{
                    adaptador.actualizarLista(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}