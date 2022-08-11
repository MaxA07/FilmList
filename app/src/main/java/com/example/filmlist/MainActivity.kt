package com.example.filmlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmlist.databinding.ActivityMainBinding
import com.example.filmlist.screens.FilmsList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FilmsList.newInstance())
                .commit()
        }
    }
}