package com.collins.cursoandroid.primeraApp

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.collins.cursoandroid.R
import javax.security.auth.login.LoginException
import androidx.appcompat.widget.AppCompatEditText

class primeraAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primera_app)
        val boton = findViewById<AppCompatButton>(R.id.boton)
        val edtxt = findViewById<AppCompatEditText>(R.id.edtxt)

        boton.setOnClickListener {
            val texto = edtxt.text.toString()

            if(texto.isNotEmpty()){
                val intent = Intent(this, SaludoActivity::class.java)
                intent.putExtra("EXTRA_NOMBRE", texto)
                startActivity(intent)
            }
        }
    }
}
