package com.example.sesion5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sesion5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.simple.setOnClickListener{startActivity(Intent(baseContext,simplePermissionsActivity::class.java))}
        binding.images.setOnClickListener{startActivity(Intent(baseContext,ImagesActivity::class.java))}
        binding.contacts.setOnClickListener{startActivity(Intent(baseContext,ContactsActivity::class.java))}
    }
}