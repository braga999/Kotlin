Claro! Aqui está o código comentado:

```kotlin
// Declaração do pacote
package com.example.jogodavelhaenzodesouzareal

// Importações necessárias
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelhaenzodesouzareal.databinding.ActivityMainBinding
import kotlin.random.Random

// Declaração da classe CpuActivity que herda de AppCompatActivity
class CpuActivity : AppCompatActivity() {
    // Declaração da variável binding para vinculação de view
    private lateinit var binding:ActivityMainBinding

    // Declaração e inicialização do tabuleiro
    val tabuleiro = arrayOf(
        arrayOf("A", "B", "C"),
        arrayOf("D", "E", "F"),
        arrayOf("G", "H", "I")
    )

    // Declaração da variável que indica o jogador atual
    var jogadorAtual = "X"

    // Função chamada quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        // Inicialização da vinculação de view
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        // Habilitação de bordas na interface
        enableEdgeToEdge()
        // Configuração da view da atividade
        setContentView(binding.root)
    }
    
    // Função chamada quando um botão é clicado
    fun buttonClick(view: View) {
        // Identificação do botão selecionado
        val buttonSelecionado = view as Button

        // Atualização do tabuleiro com base no botão clicado
        when(buttonSelecionado.id){
            binding.buttonZero.id -> tabuleiro[0][0] = jogadorAtual
            binding.buttonUm.id -> tabuleiro[0][1] = jogadorAtual
            binding.buttonDois.id -> tabuleiro[0][2] = jogadorAtual
            binding.buttonTres.id -> tabuleiro[1][0] = jogadorAtual
            binding.buttonQuatro.id -> tabuleiro[1][1] = jogadorAtual
            binding.buttonCinco.id -> tabuleiro[1][2] = jogadorAtual
            binding.buttonSeis.id -> tabuleiro[2][0] = jogadorAtual
            binding.buttonSete.id -> tabuleiro[2][1] = jogadorAtual
            binding.buttonOito.id -> tabuleiro[2][2] = jogadorAtual
        }

        // Mudança da cor de fundo do botão e desabilitação do botão
        buttonSelecionado.setBackgroundColor(Color.BLUE)
        buttonSelecionado.isEnabled=false

        // Verificação do vencedor
        var vencedor = verificaVencedor(tabuleiro)

        // Se houver um vencedor, exibe uma mensagem e reinicia a atividade
        if(!vencedor.isNullOrBlank()) {
            Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_LONG).show()
            val intent = Intent(this, CpuActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Geração de posições aleatórias para a jogada da CPU
        var rX = Random.nextInt(0, 3)
        var rY = Random.nextInt(0, 3)
        var i = 0
        while (i < 9) {
            rX = Random.nextInt(0, 3)
            rY = Random.nextInt(0, 3)

            // Verificação se a posição está disponível
            if (tabuleiro[rX][rY] != "X" && tabuleiro[rX][rY] != "O") {
                break
            }

            i++
        }

        // Atualização do tabuleiro com a jogada da CPU
        tabuleiro[rX][rY]="O"

        // Cálculo da posição no tabuleiro
        val posicao = rX*3 + rY

        // Atualização da interface com base na jogada da CPU
        when(posicao){
            0 -> {
                binding.buttonZero.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonZero.isEnabled = false
            }
            1 -> {
                binding.buttonUm.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonUm.isEnabled = false
            }
            2 -> {
                binding.buttonDois.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonDois.isEnabled = false
            }
            3 -> {
                binding.buttonTres.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonTres.isEnabled = false
            }
            4 -> {
                binding.buttonQuatro.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonQuatro.isEnabled = false
            }
            5 -> {
                binding.buttonCinco.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonCinco.isEnabled = false
            }
            6 -> {
                binding.buttonSeis.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonSeis.isEnabled = false
            }
            7 -> {
                binding.buttonSete.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonSete.isEnabled = false
            }
            8 -> {
                binding.buttonOito.setBackgroundResource(R.drawable.botafogobg)
                binding.buttonOito.isEnabled = false
            }
        }

        // Verificação novamente do vencedor após a jogada da CPU
        vencedor = verificaVencedor(tabuleiro)

        // Se houver um vencedor, exibe uma mensagem e reinicia a atividade
        if(!vencedor.isNullOrBlank()) {
            Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_LONG).show()
            val intent = Intent(this, CpuActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Alternância do jogador atual e atualização da interface
        if(jogadorAtual.equals("X")) {
            buttonSelecionado.setBackgroundResource(R.drawable.flamengobg)
            jogadorAtual = "O"
        }else{
            buttonSelecionado.setBackgroundResource(R.drawable.flamengobg)
            jogadorAtual = "X"
        }
        buttonSelecionado.isEnabled=false
    }

    // Função para verificar o vencedor
    fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
        // Verificação de linhas e colunas
        for (i in 0 until 3) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0]
            }
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return tabuleiro[0][i]
            }
        }

        // Verificação das diagonais
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0]
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2]
        }

        // Verificação de empate
        var empate = 0
        for (linha in tabuleiro) {
            for (valor in linha) {
                if(valor.equals("X")||valor.equals("O")){
                    empate++
                }
            }
        }

        // Se todas as posições estiverem preenchidas, retorna empate
        if(empate == 9){
            return "Empate"
        }
        // Nenhum vencedor
        return null
    }
}
```
