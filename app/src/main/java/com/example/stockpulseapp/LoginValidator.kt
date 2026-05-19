package com.example.stockpulseapp


class LoginValidator {

    fun isValid(email: String, password: String): Boolean {
        return email.contains("@") && password.length >= 6
    }
}