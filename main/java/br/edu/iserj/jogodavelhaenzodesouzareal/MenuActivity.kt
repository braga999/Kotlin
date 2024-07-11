package com.example.jogodavelhaenzodesouzareal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelhaenzodesouzareal.databinding.MenuActivityBinding


class MenuActivity : AppCompatActivity () {

    private lateinit var binding: MenuActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MenuActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pvpButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            //Início da proxima atividade.
            startActivity(intent)

        }

        binding.cpuButton.setOnClickListener {

            val intent = Intent(this, CpuActivity::class.java)
            //Início da proxima atividade.
            startActivity(intent)


        }
    }
}