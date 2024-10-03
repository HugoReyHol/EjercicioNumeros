package com.example.ejercicionumeros

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
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

        val numMax:Int = 10
        var numInt:Int = 5
        var numFin:Int = Random.nextInt(1, numMax+1)

        boton.setOnClickListener {
            try {
                val num:Int = entrada.text.toString().toInt()

                if (numInt <= 0) {
                    salida.text = "Los intentos han llegado a 0, cambiando número"

                    numInt = 5
                    numFin = Random.nextInt(1, numMax+1)

                } else if (num == numFin) {
                    salida.text = "Número correcto"

                    numInt = 5
                    numFin = Random.nextInt(1, numMax+1)

                } else if (num < numFin) {
                    numInt--
                    salida.text = "El número es mayor, intentos restantes ${numInt}"

                } else {
                    numInt--
                    salida.text = "El número es menor, intentos restantes ${numInt}"

                }

            } catch (e: Exception) {
                salida.text = "La entrada debe ser un número entero"

            }
        }
    }
}