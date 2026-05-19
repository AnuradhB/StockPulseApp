package com.example.stockpulseapp.core


import com.example.stockpulseapp.presentation.dashbaord.data.remote.DashboardApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.stockpulseapp.security.SecureTokenManager

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp(
        secureTokenManager: SecureTokenManager
    ): OkHttpClient {

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor { chain ->

                val token = secureTokenManager.getToken()

                val request = chain.request()
                    .newBuilder()
                    .apply {

                        token?.let {
                            addHeader(
                                "Authorization",
                                "Bearer $it"
                            )
                        }

                        addHeader(
                            "Accept",
                            "application/json"
                        )

                        addHeader(
                            "Content-Type",
                            "application/json"
                        )
                    }
                    .build()

                chain.proceed(request)
            }
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl("")
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): ApiService {

        return retrofit.create(
            ApiService::class.java
        )
    }

    @Provides
    @Singleton
    fun provideDashboardApiService(
        retrofit: Retrofit
    ): DashboardApiService {

        return retrofit.create(
            DashboardApiService::class.java
        )
    }
}