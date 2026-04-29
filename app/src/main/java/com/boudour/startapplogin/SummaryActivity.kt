package com.boudour.startapplogin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boudour.startapplogin.databinding.ActivitySummaryBinding
import androidx.core.net.toUri

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    private lateinit var form: RegisterFormData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrieveUser()
        displayInformation()
    }

    private fun retrieveUser() {
        form = intent.getSerializableExtra("RegisterForm") as RegisterFormData
    }

    private fun displayInformation() {
        binding.textViewFullName.text = form.getFullName()
        binding.textViewEmail.text = form.email
        binding.textViewPhoneNumber.text = form.phoneNumber
        setClickListener()
    }

    private fun setClickListener() {
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${form.email}")
            startActivity(intent)
        }
        binding.textViewPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:${form.phoneNumber}".toUri()
            startActivity(intent)
        }
    }
}