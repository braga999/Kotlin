package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

         // Cria um atraso de 2000 milissegundos (2 segundos)
        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val j = Intent(this,PedidoActivity::class.java)
            j.putExtras(i)
            startActivity(j)
        },2000) // Inicia a atividade PedidoActivity após o atraso

    }
}
