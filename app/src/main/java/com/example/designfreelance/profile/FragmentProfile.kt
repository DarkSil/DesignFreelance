package com.example.designfreelance.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.designfreelance.R

class FragmentProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ----------------- Приклад підстановки тексту для ID юзера
        val textUserId = view.findViewById<TextView>(R.id.textUserId)

        textUserId.text = "67676"

        // ----------------- Приклад підстановки тексту для даних юзера

        val textUserNameSurname = view.findViewById<TextView>(R.id.textUserNameSurname)
        val textUserPhone = view.findViewById<TextView>(R.id.textUserPhone)

        textUserNameSurname.text = "Ткач Юрій Михайлович"
        textUserPhone.text = "+38 (044) 3333 360"

        // ----------------- Приклад підстановки тексту для коду

        val textUserCode = view.findViewById<TextView>(R.id.textUserCode)

        textUserCode.text = "67676"

        // ----------------- Приклад підстановки тексту для знижки

        val textUserDiscount = view.findViewById<TextView>(R.id.textUserDiscount)

        textUserDiscount.text = "100%"

        // ----------------- Приклад підстановки тексту для днів разом

        val textUserAddress = view.findViewById<TextView>(R.id.textUserAddress)

        textUserAddress.text = "м. Київ"

        // ----------------- Приклад заміни тексту для днів разом

        val textUserTogether = view.findViewById<TextView>(R.id.textUserTogether)

        textUserTogether.text = getString(R.string.together_text)
            .replace("{count}", "910")

        // ----------------- Приклад заміни тексту для дати та суми зняття

        val textUserPayment = view.findViewById<TextView>(R.id.textUserPayment)

        textUserPayment.text = getString(R.string.next_payment_text)
            .replace("{date}", "05.03.2020")
            .replace("{price}", "149 грн")

        // ----------------- Приклад обробки кліків (щоб не шукати лейаути)

        val image24Hours = view.findViewById<ImageView>(R.id.image24Hours)
        val imageNotifications = view.findViewById<ImageView>(R.id.imageNotifications)
        val buttonLogout = view.findViewById<TextView>(R.id.buttonLogout)

        image24Hours.setOnClickListener {
            Toast.makeText(requireContext(), "24 HOURS", Toast.LENGTH_SHORT).show()
        }

        imageNotifications.setOnClickListener {
            Toast.makeText(requireContext(), "NOTIFICATIONS", Toast.LENGTH_SHORT).show()
        }

        buttonLogout.setOnClickListener {
            Toast.makeText(requireContext(), "LOGOUT", Toast.LENGTH_SHORT).show()
        }

    }

}