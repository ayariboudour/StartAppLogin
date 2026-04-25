package com.boudour.startapplogin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class SignInActivity : AppCompatActivity() {

    private var firstNamerEditText: TextInputEditText? = null
    private var lastNameEditText: TextInputEditText? = null
    private var emailEditText: TextInputEditText? = null
    private var phoneNumberEditText: TextInputEditText? = null
    private var passwordEditText: TextInputEditText? = null
    private var spinnerTitle: Spinner? = null
    private lateinit var backToLoginTextView: TextView
    private lateinit var buttonRegister: Button

    private var spinner: String = ""
    private var firstName: String = ""
    private var lastName: String = ""
    private var email: String = ""
    private var phoneNumber: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        buttonRegister = findViewById<Button>(R.id.button_register)
        firstNamerEditText = findViewById<TextInputEditText>(R.id.text_input_edit_text_first_name)
        lastNameEditText = findViewById<TextInputEditText>(R.id.text_input_edit_text_last_name)
        emailEditText = findViewById<TextInputEditText>(R.id.text_input_edit_text_register_email)
        phoneNumberEditText =
            findViewById<TextInputEditText>(R.id.text_input_edit_text_phone_number)
        passwordEditText =
            findViewById<TextInputEditText>(R.id.text_input_edit_text_register_password)
        backToLoginTextView = findViewById<TextView>(R.id.text_view_back_to_login)

        //spinner
        spinnerTitle = findViewById<TextView>(R.id.spinner_title) as Spinner?
        val spinnerArray = arrayOf("Herr", "Frau")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArray)
        spinnerTitle?.adapter = spinnerAdapter

        //button
        buttonRegister.setOnClickListener {
            sendDataToSummaryActivity()
        }

        backToLoginTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun sendDataToSummaryActivity() {
        spinner = spinnerTitle?.selectedItem.toString()
        firstName = firstNamerEditText?.text.toString()
        lastName = lastNameEditText?.text.toString()
        email = emailEditText?.text.toString()
        phoneNumber = phoneNumberEditText?.text.toString()
        password = passwordEditText?.text.toString()
        if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && phoneNumber.isNotEmpty() && password.isNotEmpty()) {
            val intent = Intent(this, SummaryActivity::class.java)
            val registerForm =
                RegisterFormData(spinner, firstName, lastName, email, phoneNumber, password)
            intent.putExtra("RegisterForm", registerForm)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
        }

    }


}