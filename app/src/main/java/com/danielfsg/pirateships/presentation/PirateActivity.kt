package com.danielfsg.pirateships.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danielfsg.pirateships.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PirateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}