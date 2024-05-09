package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val username = intent.extras?.getString("username")

        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        binding.buttonPedir.setOnClickListener {

// Cria uma nova intenção (Intent) para iniciar a SplashActivity
            
            val i = Intent(this, SplashActivity::class.java)

 // Adiciona os valores das quantidades de pizza, salada e hambúrguer como extras na intenção
            
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            
// Finaliza a atividade atual

            finish()
        }


        binding.checkPizza.setOnClickListener {

             // Verifica se a caixa de seleção para pizza está marcada
            if(binding.checkPizza.isChecked()){

                // Define a quantidade de pizza como 1
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE

                // Se a caixa de seleção não estiver marcada, define a quantidade de pizza como 0
            }else{
                binding.editQuantidadePizza.setText("0")

                // Torna o texto de preço da pizza invisível
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        binding.checkSalada.setOnClickListener {

            // Verifica se a caixa de seleção para salada está marcada
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")

                // Torna o texto de preço da salada visível
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{

                  // Se a caixa de seleção não estiver marcada, define a quantidade de salada como 0
                binding.editQuantidadeSalada.setText("0")

                // Torna o texto de preço da salada invisível
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        binding.checkHamburger.setOnClickListener {

            // Verifica se a caixa de seleção para hambúrguer está marcada
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")

                // Torna o texto de preço do hambúrguer visível
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{

                // Se a caixa de seleção não estiver marcada, define a quantidade de hambúrguer como 0
                binding.editQuantidadeHamburguer.setText("0")

                 // Torna o texto de preço do hambúrguer invisível
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}
