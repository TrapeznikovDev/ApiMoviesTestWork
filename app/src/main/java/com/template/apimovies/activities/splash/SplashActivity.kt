package com.template.apimovies.activities.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.template.apimovies.R
import com.template.apimovies.activities.main.MainActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        push()
    }

    private fun push() = CoroutineScope(Dispatchers.IO).launch {
        delay(1500)
        withContext(Dispatchers.IO) {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}