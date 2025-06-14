package com.collins.cursoandroid.configuraciones

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.collins.cursoandroid.databinding.ActivityConfiguracionesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "DB")

class ConfiguracionesActivity : AppCompatActivity() {

    companion object {
        const val VOLUMEN_LVL = "volumen_lvl"
        const val KEY_MODO_OSCURO = "key_modo_oscuro"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_VIBRACION = "key_vibracion"
    }

    private lateinit var binding: ActivityConfiguracionesBinding
    private var primeraVez: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityConfiguracionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            guardarConfiguraciones().filter { primeraVez }.collect { modeloConfiguraciones ->
                if (modeloConfiguraciones != null) {
                    runOnUiThread {
                        binding.smBluetooth.isChecked = modeloConfiguraciones.bluetooth
                        binding.smModoOscuro.isChecked = modeloConfiguraciones.modoOscuro
                        binding.smVibraciones.isChecked = modeloConfiguraciones.vibracion
                        binding.rsVolumen.setValues(modeloConfiguraciones.volumen.toFloat())
                        primeraVez = !primeraVez
                    }
                }
            }
        }

        iniciarUI()
    }

    private fun iniciarUI() {
        binding.rsVolumen.addOnChangeListener { _, value, _ ->
            Log.i("aris", "El valor es $value")
            CoroutineScope(Dispatchers.IO).launch {
                guardarVolumen(value.toInt())
            }
        }

        binding.smVibraciones.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                guardarOpcionesSwiths(KEY_VIBRACION, value)
            }
        }

        binding.smModoOscuro.setOnCheckedChangeListener { _, value ->

            if(value) {
                activoModoOscuro()
            } else {
                desactivoModoOscuro()
            }

            CoroutineScope(Dispatchers.IO).launch {
                guardarOpcionesSwiths(KEY_MODO_OSCURO, value)
            }
        }

        binding.smBluetooth.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                guardarOpcionesSwiths(KEY_BLUETOOTH, value)
            }
        }
    }

    private suspend fun guardarVolumen(valor: Int) {
        dataStore.edit { preferences->
            preferences[intPreferencesKey(VOLUMEN_LVL)] = valor
        }
    }

    private suspend fun guardarOpcionesSwiths(clave: String, valor: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(clave)] = valor
        }
    }

    private fun guardarConfiguraciones(): Flow<ModeloConfiguraciones?> {
        return dataStore.data.map { preferences ->
            ModeloConfiguraciones (
                modoOscuro = preferences[booleanPreferencesKey(KEY_MODO_OSCURO)] ?: false,
                bluetooth = preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: true,
                vibracion = preferences[booleanPreferencesKey(KEY_VIBRACION)] ?: true,
                volumen = preferences[intPreferencesKey(VOLUMEN_LVL)] ?: 50
            )
        }
    }

    private fun activoModoOscuro() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun desactivoModoOscuro() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}