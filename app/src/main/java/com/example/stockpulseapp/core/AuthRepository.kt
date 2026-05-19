package com.example.stockpulseapp.core

import com.example.stockpulseapp.presentation.auth.data.User


interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User>
}