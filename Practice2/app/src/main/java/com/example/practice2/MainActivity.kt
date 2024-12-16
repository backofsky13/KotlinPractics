package com.example.practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Инициализация binding с помощью inflate
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Установка макета через binding.root
        setContentView(binding.root)
    }
}
