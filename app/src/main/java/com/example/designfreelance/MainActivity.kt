package com.example.designfreelance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import com.example.designfreelance.home.FragmentHome
import com.example.designfreelance.payments.FragmentTransactions
import com.example.designfreelance.profile.FragmentProfile
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Паддінг боттом 74 dp обов'язково у всіх фрагментах бо буде залазити під BottomNavigationView
    // Можна і без паддінгу, але тоді елементи не будуть залазити під чорну цятку і виглядати буде криво

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = FragmentHome()
        val fragmentTransactions = FragmentTransactions()
        val fragmentProfile = FragmentProfile()

        // ----------------- Приклад встановлення першого екрану

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragmentHome)
            .commit()

        // ----------------- Приклад обробки кліків нижньої панелі

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
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

                }
                R.id.menu_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentProfile)
                        .commit()
                }
                R.id.menu_tv -> {

                }
                else -> false
            }
            true
        }
    }
}