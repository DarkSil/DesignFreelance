package com.example.designfreelance.payments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designfreelance.R

class FragmentTransactions : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ----------------- Верхня панель
        val textUserId = view.findViewById<TextView>(R.id.textUserId)

        textUserId.text = "67676"

        val image24Hours = view.findViewById<ImageView>(R.id.image24Hours)
        val imageNotifications = view.findViewById<ImageView>(R.id.imageNotifications)

        image24Hours.setOnClickListener {
            Toast.makeText(requireContext(), "24 HOURS", Toast.LENGTH_SHORT).show()
        }

        imageNotifications.setOnClickListener {
            Toast.makeText(requireContext(), "NOTIFICATIONS", Toast.LENGTH_SHORT).show()
        }

        // ----------------- Заповнення списку
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerTransactions)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = TransactionsAdapter(getListOfTransactions())

    }

    private fun getListOfTransactions(): ArrayList<TransactionItem> {
        return arrayListOf(
            TransactionItem(
                "Зняття коштів за послугу",
                "Інтернет: Пакет - 149",
                "21.12.2021 16:20",
                "-11.45 грн",
                TransactionItem.TransactionType.PAYMENT
            ),
            TransactionItem(
                "Поповнення рахунку",
                null,
                "21.12.2021 16:20",
                "+99.00 грн",
                TransactionItem.TransactionType.DEPOSIT
            ),
            TransactionItem(
                "Зняття коштів за послугу",
                "Інтернет: Пакет - 149",
                "21.12.2021 16:20",
                "-11.45 грн",
                TransactionItem.TransactionType.PAYMENT
            ),
            TransactionItem(
                "Поповнення рахунку",
                null,
                "21.12.2021 16:20",
                "+99.00 грн",
                TransactionItem.TransactionType.DEPOSIT
            ),
            TransactionItem(
                "Зняття коштів за послугу",
                "Інтернет: Пакет - 149",
                "21.12.2021 16:20",
                "-11.45 грн",
                TransactionItem.TransactionType.PAYMENT
            ),
            TransactionItem(
                "Поповнення рахунку",
                null,
                "21.12.2021 16:20",
                "+99.00 грн",
                TransactionItem.TransactionType.DEPOSIT
            )
        )
    }

}