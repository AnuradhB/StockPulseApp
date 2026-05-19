package com.example.stockpulseapp.core

import com.example.stockpulseapp.presentation.auth.data.api.repository.AuthRepositoryImpl
import com.example.stockpulseapp.presentation.dashbaord.domain.repositry.DashboardRepository
import com.example.stockpulseapp.presentation.dashbaord.data.repositery.DashboardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindDashboardRepository(
        impl: DashboardRepositoryImpl
    ): DashboardRepository
}