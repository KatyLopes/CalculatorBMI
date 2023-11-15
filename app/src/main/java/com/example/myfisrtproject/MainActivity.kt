package com.example.myfisrtproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btncalular: Button = findViewById(R.id.btnCalcular)
        val edtpeso: EditText = findViewById(R.id.edtpeso)
        val edtaltura: EditText = findViewById(R.id.edtaltura)


        btncalular.setOnClickListener {
            val alturaStr = edtaltura.text.toString()
            val pesoStr = edtpeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()
                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal



                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("Extra_Result", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }}}