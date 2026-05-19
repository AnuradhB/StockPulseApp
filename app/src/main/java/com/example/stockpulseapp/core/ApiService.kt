package com.example.stockpulseapp.core


import com.example.stockpulseapp.presentation.auth.data.LoginRequest
import com.example.stockpulseapp.presentation.auth.data.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("Users/Login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<User>
}