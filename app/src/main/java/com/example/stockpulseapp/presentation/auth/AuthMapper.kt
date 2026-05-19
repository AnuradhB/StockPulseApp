package com.example.stockpulseapp.presentation.auth

import com.example.stockpulseapp.presentation.auth.data.LoginResponse
import com.example.stockpulseapp.presentation.auth.data.User


fun LoginResponse.toDomain(): User {

    return User(

        Data,
        Message,
        StatusCode,
        true
    )
}