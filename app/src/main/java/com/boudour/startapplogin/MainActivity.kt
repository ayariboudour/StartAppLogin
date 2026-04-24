package com.boudour.startapplogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<TextInputEditText>(R.id.text_input_edit_text_email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.text_input_edit_text_password)
        val buttonLogin = findViewById<Button>(R.id.button_login)
        val createAccountTextView = findViewById<TextView>(R.id.text_view_create_account)

        buttonLogin.setOnClickListener {
            val email = emailEditText?.text.toString()
            val password = passwordEditText?.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }

        createAccountTextView.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }


    }

}