package com.example.kazinsta.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.kazinsta.R

class SignUp: AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etReEnterPassword: EditText
    private lateinit var etPhone: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etUsername = findViewById(R.id.etSignupUsername)
        etEmail = findViewById(R.id.etSignupEmail)
        etPassword = findViewById(R.id.etSignupPassword)
        etReEnterPassword = findViewById(R.id.etRetypePassword)
        etPhone = findViewById(R.id.etSignupPhone)
        btnSignUp = findViewById(R.id.btnSubmit)

        signup(etUsername, etEmail, etPassword, etReEnterPassword, etPassword )

    }

    private fun signup(etUsername: EditText?, etEmail: EditText?, etPassword: EditText?, etReEnterPassword: EditText?, etPassword1: EditText?) {

    }

}