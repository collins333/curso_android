package com.collins.cursoandroid.horoscopo.data.proveedor

import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo
import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo.*
import javax.inject.Inject

class HoroscopoProveedor @Inject constructor() {
    fun getHoroscopos(): List<HoroscopoInfo> {
        return  listOf(
            Aries,
            Tauro,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Escorpio,
            Sagitario,
            Capricornio,
            Acuario,
            Piscis
        )
    }
}