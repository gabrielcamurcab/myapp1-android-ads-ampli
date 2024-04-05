package com.ocamurca.myapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mEditTextEstado: Spinner
    private lateinit var mEditTextValor: EditText
    private lateinit var mTextViewPorcentagem: TextView
    private lateinit var mTextViewTotal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextEstado = findViewById<Spinner>(R.id.editTextEstado)
        mEditTextValor = findViewById(R.id.editTextValor)
        mTextViewPorcentagem = findViewById(R.id.textViewPorcentagem)
        mTextViewTotal = findViewById(R.id.textViewTotal)

        val buttonCalcular = findViewById<Button>(R.id.button)
        buttonCalcular.setOnClickListener {
            calcular(it)
        }
    }

    private fun calcular(view: View) {
        val state = mEditTextEstado.selectedItem as String
        val valorString = mEditTextValor.text.toString()

        val value = valorString.toFloat()

        val percentage: Double = when (state) {
            "AC" -> 19.0
            "AL" -> 19.0
            "AM" -> 20.0
            "AP" -> 18.0
            "BA" -> 19.0
            "CE" -> 20.0
            "DF" -> 18.0
            "ES" -> 17.0
            "GO" -> 17.0
            "MA" -> 20.0
            "MG" -> 18.0
            "MS" -> 17.0
            "MT" -> 17.0
            "PA" -> 19.0
            "PB" -> 18.0
            "PE" -> 18.0
            "PI" -> 18.0
            "PR" -> 19.0
            "RJ" -> 18.0
            "RN" -> 20.0
            "RO" -> 17.0
            "RR" -> 20.0
            "RS" -> 18.0
            "SC" -> 17.0
            "SE" -> 22.0
            "SP" -> 18.0
            "TO" -> 20.0
            else -> 1.0
        }


        val total = value + (value * percentage / 100)
        val formattedPercentage = String.format(getString(R.string.porcentagem_text), percentage)
        mTextViewPorcentagem.text = formattedPercentage
        val formattedTotal = total.toString()
        mTextViewTotal.text = formattedTotal
    }
}