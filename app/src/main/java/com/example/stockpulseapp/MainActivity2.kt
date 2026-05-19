package com.example.stockpulseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.stockpulseapp.security.SecureTokenManager

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity2 : ComponentActivity() {

    @Inject
    lateinit var secureTokenManager: SecureTokenManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            AppNavGraph(secureTokenManager) // 👈 start here

        }
    }
}