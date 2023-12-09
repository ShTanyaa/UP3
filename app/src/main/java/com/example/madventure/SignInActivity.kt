package com.example.madventure

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : Activity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        usernameEditText=findViewById(R.id.emailEditText)
        passwordEditText=findViewById(R.id.passwordEditText)
        val sharedPreferences = getSharedPreferences("LoginAndPassword", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString("username", "11111")
        editor.putString("password", "11111")
        editor.apply()
    }
    fun Login(view: View){


        val log :String = usernameEditText.text.toString()
        val pas:String = passwordEditText.text.toString()


        if (usernameEditText.text.toString().isEmpty() || passwordEditText.text.toString().isEmpty()) {

            Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
        }
        else {

            val sharedPreferences = getSharedPreferences("LoginAndPassword", MODE_PRIVATE)

            val savedUsername = sharedPreferences.getString("username", "")
            val savedPassword = sharedPreferences.getString("password", "")


            if (log == savedUsername && pas == savedPassword) {
                val intent = Intent(this, QuestsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()

            }

        }

    }
}