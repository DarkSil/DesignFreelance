package com.example.designfreelance.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.designfreelance.R

class FragmentTV : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
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

    }

}