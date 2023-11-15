package com.example.myfisrtproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_Result)
        val tvclassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val ivImagem = findViewById<ImageView>(R.id.iv_imagem)
        val tvInfo = findViewById<TextView>(R.id.info)

        val result = intent.getFloatExtra("Extra_Result", 0.0f)
        tvResult.text = "Resultado: $result"

        if (result < 18.5f) {
            ivImagem.setImageResource(R.drawable.abaixop)
        } else if (result in 18.5f..24.9f) {
            ivImagem.setImageResource(R.drawable.normal)
        }else if (result in 25f..29.9f) {
            ivImagem.setImageResource(R.drawable.sobrepeso)
        }else if (result in 30f..39.9f) {
            ivImagem.setImageResource(R.drawable.obsidade)
        }else {
            ivImagem.setImageResource(R.drawable.obsidadegrave)
        }


        tvResult.text = "Resultado: $tvInfo"

        if (result < 18.5f) {
            tvInfo.text = getString(R.string.info_abaixo)
        } else if (result in 18.5f..24.9f) {
            tvInfo.text = getString(R.string.info_normal)
        } else if (result in 25f..29.9f) {
            tvInfo.text = getString(R.string.info_SP)
        } else if (result in 30f..39.9f) {
            tvInfo.text = getString(R.string.info_obesidade)
        } else {
            tvInfo.text = getString(R.string.info_obesidade)
        }

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f) {
            "PESO IDEAL Parabéns!"
        } else if (result in 25f..29.9f) {
            "SOBREPESO"
        } else if (result in 30f..39.9f) {
            "OBESIDADE"
        } else "OBESIDADE GRAVE"


        tvclassificacao.text = getString(R.string.message_Classificação, classificacao)

    }

    override
    fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}