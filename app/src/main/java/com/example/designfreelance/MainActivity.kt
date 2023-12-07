package com.example.designfreelance

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.designfreelance.home.FragmentHome
import com.example.designfreelance.payments.FragmentTransactions
import com.example.designfreelance.profile.FragmentProfile
import com.example.designfreelance.services.ActivityServices
import com.example.designfreelance.tv.FragmentTV
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Паддінг боттом 74 dp обов'язково у всіх фрагментах бо буде залазити під BottomNavigationView
    // Можна і без паддінгу, але тоді елементи не будуть залазити під чорну цятку і виглядати буде криво

    companion object {
        var lastSelectedId = R.id.menu_home
    }

    private val fragmentHome = FragmentHome()
    private val fragmentTransactions = FragmentTransactions()
    private val fragmentProfile = FragmentProfile()
    private val fragmentTV = FragmentTV()

    private lateinit var bottomNavigationView :  BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ----------------- Приклад встановлення першого екрану

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragmentHome)
            .commit()

        // ----------------- Приклад обробки кліків нижньої панелі

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId != R.id.menu_services) {
                lastSelectedId = it.itemId
            }
            when (it.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentHome)
                        .commit()
                }
                R.id.menu_payments -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentTransactions)
                        .commit()
                }
                R.id.menu_services -> {
                    startActivity(Intent(this, ActivityServices::class.java))
                    overridePendingTransition(0, 0)
                }
                R.id.menu_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentProfile)
                        .commit()
                }
                R.id.menu_tv -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentTV)
                        .commit()
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView.selectedItemId = lastSelectedId
    }

}