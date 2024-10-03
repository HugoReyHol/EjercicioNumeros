package com.example.ejercicionumeros

import android.annotation.SuppressLint
import android.app.Application
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val boton: Button = findViewById(R.id.boton)
        val entrada: EditText = findViewById(R.id.entrada)
        val salida: TextView = findViewById(R.id.salida)

        val numMax: Int = 10
        var numInt: Int = 5
        var numFin: Int = Random.nextInt(1, numMax + 1)

        fun mostrarAlerta(mensaje:Int) {
            val alerta:AlertDialog.Builder = AlertDialog.Builder(this)
            alerta.setMessage(getString(mensaje) + getString(R.string.seguir))
            alerta.setTitle(R.string.tituloDialog)

            alerta.setPositiveButton(R.string.si) { _, _ ->
                entrada.setText("")
                salida.setText("")

                numInt = 5
                numFin = Random.nextInt(1, numMax + 1)

            }

            alerta.setNegativeButton(R.string.no) { _, _ ->
                finish()

            }

            alerta.create().show()

        }

        boton.setOnClickListener {
            try {
                val num: Int = entrada.text.toString().toInt()

                if (numInt <= 0) {
                    mostrarAlerta(R.string.fallido)

                } else if (num == numFin) {
                    mostrarAlerta(R.string.acertado)

                } else if (num < numFin) {
                    numInt--
                    salida.text = "${getString(R.string.mayor)} $numInt"

                } else {
                    numInt--
                    salida.text = "${getString(R.string.menor)} $numInt"

                }

            } catch (e: Exception) {
                salida.setText(R.string.noNumero)

            }
        }
    }
}