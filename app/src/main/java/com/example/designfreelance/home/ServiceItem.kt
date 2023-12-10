package com.example.designfreelance.home

import com.example.designfreelance.R

data class ServiceItem(
    val name: String,
    val description: String,
    val price: String,
    val type: ServiceType,
    val period: ServicePeriod
) {

    enum class ServicePeriod(val periodText: Int) {
        DAY(R.string.day),
        MONTH(R.string.month),
        YEAR(R.string.year)
    }

    enum class ServiceType(val imageType: Int) {
        INTERNET(R.drawable.icon_internet),
        TV(R.drawable.icon_tv),
        COMBO(R.drawable.icon_combo),
        OTHER(R.drawable.icon_other)
    }

}