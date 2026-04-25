package com.boudour.startapplogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    private lateinit var form: RegisterFormData
    private lateinit var formText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

    }

    private fun displayInformation(){
        form = intent.getSerializableExtra("RegisterForm") as RegisterFormData
        formText = """
            Hi ${form.firstName} ${form.lastName},
            
            
        """.trimIndent()
    }
}