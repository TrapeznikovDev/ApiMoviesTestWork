package com.template.apimovies.activities.splash

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.template.apimovies.R
import com.template.apimovies.activities.main.MainActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        CoroutineScope(Dispatchers.IO).launch {
            push()
        }

    }
    suspend fun push() {
        delay(1500)
        withContext(Dispatchers.IO){
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}