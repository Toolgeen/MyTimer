package com.abdykadyr.mytimer.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.abdykadyr.mytimer.R
import com.abdykadyr.mytimer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.apply {
            popBackStack()
            beginTransaction()
                .replace(R.id.main_container, MyTimerListFragment.getInstance())
                .addToBackStack(null)
                .commit()
        }

    }



}