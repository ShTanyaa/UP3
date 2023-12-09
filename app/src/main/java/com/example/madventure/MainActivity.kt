package com.example.madventure

import android.app.Activity
import android.content.Intent
import android.content.IntentSender.OnFinished
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timer=object :CountDownTimer(3000,1000){
            override fun onTick(maillisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        timer.start()
    }
}