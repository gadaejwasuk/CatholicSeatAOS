package org.sopt.study.catholiclibraryseat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import org.sopt.study.catholiclibraryseat.R
import org.sopt.study.catholiclibraryseat.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        val display = this.resources.displayMetrics
        val deviceWidth = display.widthPixels
        val ratio : Double = 100/360.0
        val imagePadding : Int = (ratio*deviceWidth).toInt()
        binding.ivLogo.setPadding(imagePadding, 0, imagePadding, 0)

        val intent = Intent(this, MainActivity2::class.java)

        Handler(Looper.getMainLooper()).postDelayed({
            val fadeAnim : Animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
            binding.ivLogo.startAnimation(fadeAnim)
            startActivity(intent)
            finish()
        }, 1500L)

        setContentView(binding.root)
    }
}