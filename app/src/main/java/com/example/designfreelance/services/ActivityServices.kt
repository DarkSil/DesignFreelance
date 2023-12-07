package com.example.designfreelance.services

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designfreelance.MainActivity
import com.example.designfreelance.R
import com.example.designfreelance.home.ServiceItem
import com.example.designfreelance.home.ServicesAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityServices : AppCompatActivity() {

    private val arrayList = arrayListOf<ServiceItem>()
    private val adapter = ServicesAdapter(arrayList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        // ----------------- Приклад обробки кліків нижньої панелі, встановлення табa сервісів

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.selectedItemId = R.id.menu_services

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_services -> {}
                else -> {
                    MainActivity.lastSelectedId = it.itemId
                    finish()
                }
            }
            true
        }

        // ----------------- Приклад підстановки тексту для ID юзера
        val textUserId = findViewById<TextView>(R.id.textUserId)

        textUserId.text = "67676"

        // ----------------- Підстановка списку

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerServices)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        arrayList.clear()
        arrayList.addAll(getListOfServices(ServiceItem.ServiceType.INTERNET))

        adapter.notifyItemRangeInserted(0, arrayList.size)

        // ----------------- Приклад обробки кліків

        val image24Hours = findViewById<ImageView>(R.id.image24Hours)
        val imageNotifications = findViewById<ImageView>(R.id.imageNotifications)

        image24Hours.setOnClickListener {
            Toast.makeText(this, "24 HOURS", Toast.LENGTH_SHORT).show()
        }

        imageNotifications.setOnClickListener {
            Toast.makeText(this, "NOTIFICATIONS", Toast.LENGTH_SHORT).show()
        }

        val linearInternet = findViewById<LinearLayout>(R.id.linearInternet)
        val linearTV = findViewById<LinearLayout>(R.id.linearTV)
        val linearOther = findViewById<LinearLayout>(R.id.linearOther)
        val imageInternet = findViewById<ImageView>(R.id.imageInternet)
        val textInternet = findViewById<TextView>(R.id.textInternet)
        val imageTV = findViewById<ImageView>(R.id.imageTV)
        val textTV = findViewById<TextView>(R.id.textTV)
        val imageOther = findViewById<ImageView>(R.id.imageOther)
        val textOther = findViewById<TextView>(R.id.textOther)

        linearInternet.setOnClickListener {
            linearInternet.background = ContextCompat.getDrawable(this, R.drawable.background_service_selected)
            imageInternet.setColorFilter(ContextCompat.getColor(this, R.color.white))
            textInternet.setTextColor(ContextCompat.getColor(this, R.color.white))

            linearTV.background = ContextCompat.getDrawable(this, R.drawable.background_service_unselected)
            imageTV.setColorFilter(ContextCompat.getColor(this, R.color.background_selected))
            textTV.setTextColor(ContextCompat.getColor(this, R.color.background_selected))

            linearOther.background = ContextCompat.getDrawable(this, R.drawable.background_service_unselected)
            imageOther.setColorFilter(ContextCompat.getColor(this, R.color.background_selected))
            textOther.setTextColor(ContextCompat.getColor(this, R.color.background_selected))

            val size = arrayList.size

            arrayList.clear()
            arrayList.addAll(getListOfServices(ServiceItem.ServiceType.INTERNET))

            adapter.notifyItemRangeChanged(0, size)
        }

        linearTV.setOnClickListener {
            linearInternet.background = ContextCompat.getDrawable(this, R.drawable.background_service_unselected)
            imageInternet.setColorFilter(ContextCompat.getColor(this, R.color.background_selected))
            textInternet.setTextColor(ContextCompat.getColor(this, R.color.background_selected))

            linearTV.background = ContextCompat.getDrawable(this, R.drawable.background_service_selected)
            imageTV.setColorFilter(ContextCompat.getColor(this, R.color.white))
            textTV.setTextColor(ContextCompat.getColor(this, R.color.white))

            linearOther.background = ContextCompat.getDrawable(this, R.drawable.background_service_unselected)
            imageOther.setColorFilter(ContextCompat.getColor(this, R.color.background_selected))
            textOther.setTextColor(ContextCompat.getColor(this, R.color.background_selected))

            val size = arrayList.size

            arrayList.clear()
            arrayList.addAll(getListOfServices(ServiceItem.ServiceType.TV))

            adapter.notifyItemRangeChanged(0, size)
        }

        linearOther.setOnClickListener {
            linearInternet.background = ContextCompat.getDrawable(this, R.drawable.background_service_unselected)
            imageInternet.setColorFilter(ContextCompat.getColor(this, R.color.background_selected))
            textInternet.setTextColor(ContextCompat.getColor(this, R.color.background_selected))

            linearTV.background = ContextCompat.getDrawable(this, R.drawable.background_service_unselected)
            imageTV.setColorFilter(ContextCompat.getColor(this, R.color.background_selected))
            textTV.setTextColor(ContextCompat.getColor(this, R.color.background_selected))

            linearOther.background = ContextCompat.getDrawable(this, R.drawable.background_service_selected)
            imageOther.setColorFilter(ContextCompat.getColor(this, R.color.white))
            textOther.setTextColor(ContextCompat.getColor(this, R.color.white))

            val size = arrayList.size

            arrayList.clear()
            arrayList.addAll(getListOfServices(ServiceItem.ServiceType.OTHER))

            adapter.notifyItemRangeChanged(0, size)
        }

    }

    private fun getListOfServices(type: ServiceItem.ServiceType): List<ServiceItem> {
        val list = arrayListOf<ServiceItem>()
        when (type) {
            ServiceItem.ServiceType.INTERNET -> {
                list.addAll(
                    arrayListOf(
                        ServiceItem(
                            "Інтернет: Пакет - 149",
                            "Тариф “Пакет-149”: 100мбіт/с",
                            "149 грн",
                            ServiceItem.ServiceType.INTERNET,
                            ServiceItem.ServicePeriod.DAY
                        ),
                        ServiceItem(
                            "Інтернет: Пакет - 149",
                            "Тариф “Пакет-149”: 100мбіт/с",
                            "149 грн",
                            ServiceItem.ServiceType.INTERNET,
                            ServiceItem.ServicePeriod.DAY
                        ),
                        ServiceItem(
                            "Інтернет: Пакет - 149",
                            "Тариф “Пакет-149”: 100мбіт/с",
                            "149 грн",
                            ServiceItem.ServiceType.INTERNET,
                            ServiceItem.ServicePeriod.DAY
                        )
                    )
                )
            }
            ServiceItem.ServiceType.TV -> {
                list.addAll(
                    arrayListOf(
                        ServiceItem(
                            "TV: VIP HD",
                            "183 канали + 43 HD канали",
                            "129 грн",
                            ServiceItem.ServiceType.TV,
                            ServiceItem.ServicePeriod.MONTH
                        ),
                        ServiceItem(
                            "TV: VIP HD",
                            "183 канали + 43 HD канали",
                            "129 грн",
                            ServiceItem.ServiceType.TV,
                            ServiceItem.ServicePeriod.MONTH
                        ),
                        ServiceItem(
                            "TV: VIP HD",
                            "183 канали + 43 HD канали",
                            "129 грн",
                            ServiceItem.ServiceType.TV,
                            ServiceItem.ServicePeriod.MONTH
                        )
                    )
                )
            }
            ServiceItem.ServiceType.OTHER -> {
                list.addAll(
                    arrayListOf(
                        ServiceItem(
                            "Додаткові послуги",
                            "Тариф: 100мбіт/с",
                            "129 грн",
                            ServiceItem.ServiceType.OTHER,
                            ServiceItem.ServicePeriod.YEAR
                        ),
                        ServiceItem(
                            "Додаткові послуги",
                            "Тариф: 100мбіт/с",
                            "129 грн",
                            ServiceItem.ServiceType.OTHER,
                            ServiceItem.ServicePeriod.YEAR
                        ),
                        ServiceItem(
                            "Додаткові послуги",
                            "Тариф: 100мбіт/с",
                            "129 грн",
                            ServiceItem.ServiceType.OTHER,
                            ServiceItem.ServicePeriod.YEAR
                        )
                    )
                )
            }
        }
        return list
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, 0)
    }

}