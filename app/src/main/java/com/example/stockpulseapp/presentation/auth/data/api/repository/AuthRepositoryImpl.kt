package com.example.stockpulseapp.presentation.auth.data.api.repository

import com.example.stockpulseapp.core.ApiService
import com.example.stockpulseapp.core.AuthRepository
import com.example.stockpulseapp.presentation.auth.data.LoginRequest
import com.example.stockpulseapp.presentation.auth.data.User
import com.example.stockpulseapp.security.SecureTokenManager
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val secureTokenManager: SecureTokenManager

) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {

        return try {
            val response = api.login(LoginRequest(email, password))

            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
                val body = response.body()!!

                // 🔥 SAVE TOKEN HERE
                secureTokenManager.saveToken(body.Data.Token)

                Result.success(
                    User(
                        body.Data,
                        body.Message,
                        body.StatusCode,
                        body.Success
                    )
                )

            } else {
                Result.failure(Exception("Login failed: ${response.message()}"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}