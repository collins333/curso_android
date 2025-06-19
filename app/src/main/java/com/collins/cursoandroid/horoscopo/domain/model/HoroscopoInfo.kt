package com.collins.cursoandroid.horoscopo.domain.model

import com.collins.cursoandroid.R

sealed class HoroscopoInfo(val img:Int, val nombre:Int) {
    data object Aries: HoroscopoInfo(R.drawable.aries, R.string.horoscopo_aries)
    data object Tauro: HoroscopoInfo(R.drawable.tauro, R.string.horoscopo_tauro)
    data object Geminis: HoroscopoInfo(R.drawable.geminis, R.string.horoscopo_geminis)
    data object Cancer: HoroscopoInfo(R.drawable.cancer, R.string.horoscopo_cancer)
    data object Leo: HoroscopoInfo(R.drawable.leo, R.string.horoscopo_leo)
    data object Virgo: HoroscopoInfo(R.drawable.virgo, R.string.horoscopo_virgo)
    data object Libra: HoroscopoInfo(R.drawable.libra, R.string.horoscopo_libra)
    data object Escorpio: HoroscopoInfo(R.drawable.escorpio, R.string.horoscopo_escorpio)
    data object Sagitario: HoroscopoInfo(R.drawable.sagitario, R.string.horoscopo_sagitario)
    data object Capricornio: HoroscopoInfo(R.drawable.capricornio, R.string.horoscopo_capricornio)
    data object Acuario: HoroscopoInfo(R.drawable.aquario, R.string.horoscopo_acuario)
    data object Piscis: HoroscopoInfo(R.drawable.piscis, R.string.horoscopo_piscis)
}