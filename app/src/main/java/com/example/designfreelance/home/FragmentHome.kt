package com.example.designfreelance.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designfreelance.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class FragmentHome : Fragment() {

    // Зробив структурно щоб гарно оновлявся список, можете зробити по-своєму, не обов'язково як я
    private val listOfServices = arrayListOf<ServiceItem>()
    private val servicesAdapter = ServicesAdapter(listOfServices)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ----------------- Вибір таба сервісів

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayoutServices)
        val textSelectedServices = view.findViewById<TextView>(R.id.textSelectedServices)

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        textSelectedServices.text = getString(R.string.active_services)
                        val size = listOfServices.size
                        listOfServices.clear()
                        listOfServices.addAll(getListOfServices())
                        servicesAdapter.notifyItemRangeChanged(0, size)
                    }
                    1 -> {
                        textSelectedServices.text = getString(R.string.services)
                        val size = listOfServices.size
                        listOfServices.clear()
                        listOfServices.addAll(getListOfServices(true))
                        servicesAdapter.notifyItemRangeChanged(0, size)
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // ----------------- Встановлення списку сервісів

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerSelectedServices)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = servicesAdapter

        listOfServices.clear()
        listOfServices.addAll(getListOfServices())
        servicesAdapter.notifyItemRangeInserted(0, listOfServices.size)

        // ----------------- Приклад обробки кліків (щоб не шукати лейаути)

        val layoutCredit = view.findViewById<ConstraintLayout>(R.id.layoutCredit)
        val layoutBalance = view.findViewById<ConstraintLayout>(R.id.layoutBalance)
        val layoutDeposit = view.findViewById<ConstraintLayout>(R.id.layoutDeposit)
        val image24Hours = view.findViewById<ImageView>(R.id.image24Hours)
        val imageNotifications = view.findViewById<ImageView>(R.id.imageNotifications)

        layoutCredit.setOnClickListener {
            Toast.makeText(requireContext(), "CREDIT", Toast.LENGTH_SHORT).show()
        }

        layoutBalance.setOnClickListener {
            Toast.makeText(requireContext(), "BALANCE", Toast.LENGTH_SHORT).show()
        }

        layoutDeposit.setOnClickListener {
            Toast.makeText(requireContext(), "DEPOSIT", Toast.LENGTH_SHORT).show()
        }

        image24Hours.setOnClickListener {
            Toast.makeText(requireContext(), "24 HOURS", Toast.LENGTH_SHORT).show()
        }

        imageNotifications.setOnClickListener {
            Toast.makeText(requireContext(), "NOTIFICATIONS", Toast.LENGTH_SHORT).show()
        }

        // ----------------- Приклад підстановки тексту для ID юзера
        val textUserId = view.findViewById<TextView>(R.id.textUserId)

        textUserId.text = "67676"

        // ----------------- Приклад підстановки тексту для балансу
        val textBalance = view.findViewById<TextView>(R.id.textBalance)

        val balance = -15.79
        textBalance.text = "$balance₴"

        // ----------------- Приклад підстановки тексту для дати зняття
        val textNextPaymentDate = view.findViewById<TextView>(R.id.textNextPaymentDate)

        textNextPaymentDate.text = "05.03.2020"

        // ----------------- Приклад заміни тексту для суми зняття
        val textNextPaymentAmount = view.findViewById<TextView>(R.id.textNextPaymentAmount)

        textNextPaymentAmount.text = getString(R.string.amount_placeholder).replace("{amount}", "0.0")
    }






    // ----------------- Фейковий метод отримання списку для сервісів з прикладом даних
    private fun getListOfServices(reversed: Boolean = false): List<ServiceItem> {
        val list = listOf(
            ServiceItem(
                "Інтернет: Пакет - 149",
                "Тариф “Пакет-149”: 100мбіт/с",
                "149 грн",
                ServiceItem.ServiceType.INTERNET,
                ServiceItem.ServicePeriod.DAY
            ),
            ServiceItem(
                "TV: VIP HD",
                "183 канали + 43 HD канали",
                "129 грн",
                ServiceItem.ServiceType.TV,
                ServiceItem.ServicePeriod.MONTH
            ),
            ServiceItem(
                "Додаткові послуги",
                "Тариф: 100мбіт/с",
                "129 грн",
                ServiceItem.ServiceType.OTHER,
                ServiceItem.ServicePeriod.YEAR
            )
        )
        return if (reversed) list.reversed() else list
    }

}