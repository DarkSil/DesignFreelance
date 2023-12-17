package com.example.designfreelance.home.deposit

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.cloudipsp.android.Cloudipsp
import com.cloudipsp.android.Cloudipsp.PayCallback
import com.cloudipsp.android.CloudipspWebView
import com.cloudipsp.android.Currency
import com.cloudipsp.android.GooglePayCall
import com.cloudipsp.android.Order
import com.cloudipsp.android.Receipt
import com.example.designfreelance.R


class ActivityDeposit : AppCompatActivity() {

    private var googlePayCall : GooglePayCall? = null
    private var cloudipsp : Cloudipsp? = null
    private var cloudipspWebView : CloudipspWebView? = null

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

        val buttonMonoPay = findViewById<RelativeLayout>(R.id.buttonMonoPay)
        buttonMonoPay.setOnClickListener {
            Toast.makeText(this, "MONOPAY", Toast.LENGTH_SHORT).show()
        }

        cloudipspWebView = findViewById(R.id.cloudipspWebView)
        cloudipsp = Cloudipsp(1448282, cloudipspWebView)

        if (savedInstanceState != null) {
            googlePayCall = savedInstanceState.getParcelable("google_pay_call");
        }

        val buttonGPay = findViewById<RelativeLayout>(R.id.buttonGPay)
        buttonGPay.setOnClickListener {
            val amount = editSumDeposit.text.toString().toIntOrNull()
            if (amount != null && amount > 0) {
                if (Cloudipsp.supportsGooglePay(this)) {
                    val order = Order(
                        amount,
                        Currency.UAH,
                        "vb_" + System.currentTimeMillis(),
                        getString(R.string.deposit_text)
                    )
                    order.setLang(Order.Lang.uk)

                    cloudipspWebView?.isVisible = true

                    cloudipsp?.googlePayInitialize(order, this, 100500, object : Cloudipsp.GooglePayCallback {
                        override fun onPaidFailure(e: Cloudipsp.Exception?) {
                            println(e?.message)

                            cloudipspWebView?.isVisible = false
                        }

                        override fun onGooglePayInitialized(result: GooglePayCall?) {
                            googlePayCall = result
                        }
                    })
                }
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("google_pay_call", googlePayCall)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            100500 -> if (!cloudipsp!!.googlePayComplete(
                    resultCode,
                    data,
                    googlePayCall,
                    object : PayCallback {
                        override fun onPaidFailure(e: Cloudipsp.Exception?) {
                            println(e?.message)
                            cloudipspWebView?.isVisible = false
                        }

                        override fun onPaidProcessed(receipt: Receipt?) {
                            cloudipspWebView?.isVisible = false
                        }
                    }
                )
            ) {

            }
        }
    }

}