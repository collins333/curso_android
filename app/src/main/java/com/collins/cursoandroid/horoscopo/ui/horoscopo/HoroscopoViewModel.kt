package com.collins.cursoandroid.horoscopo.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.collins.cursoandroid.horoscopo.data.proveedor.HoroscopoProveedor
import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo
import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(horoscopoProveedor: HoroscopoProveedor): ViewModel() {

    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscopo: StateFlow<List<HoroscopoInfo>> = _horoscopo

    init {
        _horoscopo.value = horoscopoProveedor.getHoroscopos()
    }
}