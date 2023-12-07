package com.example.designfreelance.home.deposit

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.example.designfreelance.R

class ActivityDeposit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        val imageBack = findViewById<ImageView>(R.id.imageBack)
        imageBack.setOnClickListener { finish() }

        // Контроль видимості акції якщо буде потрібно
        val promotionalText = findViewById<CardView>(R.id.promotionalText)
        promotionalText.isVisible = true

        // Встановлення суми
        val editSumDeposit = findViewById<EditText>(R.id.editSumDeposit)

        editSumDeposit.doAfterTextChanged {
            editSumDeposit.setSelection(editSumDeposit.text.length)
        }

        editSumDeposit.setOnClickListener {
            editSumDeposit.setSelection(editSumDeposit.text.length)
        }

        val text200 = findViewById<TextView>(R.id.text200)
        text200.setOnClickListener { editSumDeposit.setText("200") }

        val text300 = findViewById<TextView>(R.id.text300)
        text300.setOnClickListener { editSumDeposit.setText("300") }

        val text400 = findViewById<TextView>(R.id.text400)
        text400.setOnClickListener { editSumDeposit.setText("400") }

        val linearPaymentCodeEdit = findViewById<LinearLayout>(R.id.linearPaymentCodeEdit)
        val editPaymentCode = findViewById<EditText>(R.id.editPaymentCode)

        linearPaymentCodeEdit.setOnClickListener {
            linearPaymentCodeEdit.isVisible = false
            editPaymentCode.isVisible = true
            editPaymentCode.requestFocus()
        }

        val textPaymentCodeValue = findViewById<TextView>(R.id.textPaymentCodeValue)
        textPaymentCodeValue.text = "67676"

        val buttonMonoPay = findViewById<TextView>(R.id.buttonMonoPay)
        buttonMonoPay.setOnClickListener {
            Toast.makeText(this, "MONOPAY", Toast.LENGTH_SHORT).show()
        }

        val buttonGPay = findViewById<LinearLayout>(R.id.buttonGPay)
        buttonGPay.setOnClickListener {
            Toast.makeText(this, "GOOGLEPAY", Toast.LENGTH_SHORT).show()
        }

    }

}