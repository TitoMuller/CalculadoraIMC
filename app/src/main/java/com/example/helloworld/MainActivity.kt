package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById<Button>(R.id.btnCalculate)
        val weightInput: EditText = findViewById<EditText>(R.id.weight)
        val heightInput: EditText = findViewById<EditText>(R.id.height)

        btnCalculate.setOnClickListener {

            val weightStr = weightInput.text.toString()
            val heightStr = heightInput.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight: Float = weightStr.toFloat()
                val height: Float = heightStr.toFloat()
                val result = weight / (height * height)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}