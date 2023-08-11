@file:Suppress("DEPRECATION")

package com.dicoding.kophie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    private lateinit var topAnimation : Animation
    private lateinit var bottomAnimation : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_movement)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_movement)

        val appName : TextView = findViewById(R.id.app_name)
        val appSlogan : TextView = findViewById(R.id.app_slogan)

        appName.startAnimation(topAnimation)
        appSlogan.startAnimation(bottomAnimation)

        moveNext()

    }

    private fun moveNext(){
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3200)
    }
}