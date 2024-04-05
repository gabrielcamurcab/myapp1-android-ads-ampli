package com.ocamurca.myapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mEditTextEstado: EditText
    private lateinit var mEditTextValor: EditText
    private lateinit var mTextViewPorcentagem: TextView
    private lateinit var mTextViewTotal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextEstado = findViewById(R.id.editTextEstado)
        mEditTextValor = findViewById(R.id.editTextValor)
        mTextViewPorcentagem = findViewById(R.id.textViewPorcentagem)
        mTextViewTotal = findViewById(R.id.textViewTotal)

        val buttonCalcular = findViewById<Button>(R.id.button)
        buttonCalcular.setOnClickListener {
            calcular(it)
        }
    }

    private fun calcular(view: View) {
        val estado = mEditTextEstado.text.toString()
        val valorString = mEditTextValor.text.toString()

        val valor = valorString.toFloat()
        val porcentagem: Double

        porcentagem = when (estado) {
            "RO" -> {
                17.5
            }
            "SP" -> {
                18.0
            }
            else -> {
                1.0
            }
        }

        val total = valor + (valor * porcentagem / 100)
        val formattedPercentage = String.format(getString(R.string.porcentagem_text), porcentagem)
        mTextViewPorcentagem.text = formattedPercentage
        val formattedTotal = String.format(getString(R.string.total_text), total)
        mTextViewTotal.text = formattedTotal
    }
}