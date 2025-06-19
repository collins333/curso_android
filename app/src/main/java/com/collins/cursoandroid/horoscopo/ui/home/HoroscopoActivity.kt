package com.collins.cursoandroid.horoscopo.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.collins.cursoandroid.R
import com.collins.cursoandroid.databinding.ActivityHoroscopoBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.zip.Inflater

@AndroidEntryPoint
class HoroscopoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarUI()
    }

    private fun iniciarUI() {
        iniciarNavegacion()
    }

    private fun iniciarNavegacion() {
        val navHost: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fcvMain) as NavHostFragment
        navController = navHost.navController
        binding.bnMain.setupWithNavController(navController)
    }
}