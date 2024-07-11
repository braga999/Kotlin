Claro! Aqui está o código com comentários usando `//`:

```kotlin
package com.example.jogodavelhaenzodesouzareal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelhaenzodesouzareal.databinding.MenuActivityBinding

// Declaração da classe MenuActivity que herda de AppCompatActivity
class MenuActivity : AppCompatActivity() {

    // Declaração de uma variável para o binding da activity
    private lateinit var binding: MenuActivityBinding

    // Sobrescrita do método onCreate, que é chamado quando a activity é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialização do binding utilizando o layout inflater
        binding = MenuActivityBinding.inflate(layoutInflater)
        // Configuração da view principal da activity com a raiz do binding
        setContentView(binding.root)

        // Configuração do listener para o botão pvpButton
        binding.pvpButton.setOnClickListener {

            // Criação de uma intenção para iniciar a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Início da próxima atividade
            startActivity(intent)
        }

        // Configuração do listener para o botão cpuButton
        binding.cpuButton.setOnClickListener {

            // Criação de uma intenção para iniciar a CpuActivity
            val intent = Intent(this, CpuActivity::class.java)
            // Início da próxima atividade
            startActivity(intent)
        }
    }
}
```

Cada linha do código agora tem um comentário explicando sua função.
