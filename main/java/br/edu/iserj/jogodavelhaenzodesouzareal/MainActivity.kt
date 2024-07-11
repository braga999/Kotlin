package com.example.jogodavelhaenzodesouzareal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelhaenzodesouzareal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declaração da variável binding para vinculação das views
    private lateinit var binding:ActivityMainBinding

    // Vetor bidimensional que representará o tabuleiro de jogo
    val tabuleiro = arrayOf(
        arrayOf("A", "B", "C"),
        arrayOf("D", "E", "F"),
        arrayOf("G", "H", "I")
    )

    // Variável que indica qual jogador está jogando
    var jogadorAtual = "X"

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inicializa o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        // Habilita modo de borda a borda (edge-to-edge)
        enableEdgeToEdge()
        // Define a view a partir do binding.root
        setContentView(binding.root)
    }

    // Função associada com todos os botões. @param view é o botão clicado
    fun buttonClick(view: View) {
        // O botão clicado é associado com uma constante
        val buttonSelecionado = view as Button
        // O texto do botão recebe o jogador atual
        buttonSelecionado.text = jogadorAtual

        // De acordo com o botão clicado, a posição da matriz receberá o Jogador
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
        // Recebe o jogador vencedor através da função verificaTabuleiro. @param tabuleiro
        var vencedor = verificaVencedor(tabuleiro)

        if(!vencedor.isNullOrBlank()) {
            // Exibe uma mensagem com o vencedor e reinicia a atividade
            Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Alterna o jogador atual e muda o fundo do botão de acordo com o jogador
        if(jogadorAtual.equals("X")) {
            buttonSelecionado.setBackgroundResource(R.drawable.flamengobg)
            jogadorAtual = "O"
        } else {
            buttonSelecionado.setBackgroundResource(R.drawable.botafogobg)
            jogadorAtual = "X"
        }
        // Desabilita o botão após o clique
        buttonSelecionado.isEnabled = false
    }

    // Função para verificar o vencedor
    fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {

        // Verifica linhas e colunas
        for (i in 0 until 3) {
            // Verifica se há três itens iguais na linha
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0]
            }
            // Verifica se há três itens iguais na coluna
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return tabuleiro[0][i]
            }
        }
        // Verifica diagonais
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0]
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2]
        }
        // Verifica a quantidade de jogadores
        var empate = 0
        for (linha in tabuleiro) {
            for (valor in linha) {
                if(valor.equals("X") || valor.equals("O")){
                    empate++
                }
            }
        }
        // Se houver 9 jogadas não combinadas, não houve vencedor
        if(empate == 9){
            return "Empate"
        }
        // Não houve vencedor
        return null
    }
}
```
