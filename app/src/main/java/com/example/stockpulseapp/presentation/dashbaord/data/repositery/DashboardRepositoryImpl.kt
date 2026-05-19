package com.example.stockpulseapp.presentation.dashbaord.data.repositery

import com.example.stockpulseapp.presentation.dashbaord.domain.model.DashBoardModel
import com.example.stockpulseapp.presentation.dashbaord.domain.repositry.DashboardRepository
import com.example.stockpulseapp.presentation.dashbaord.data.remote.DashboardApiService
import com.example.stockpulseapp.presentation.dashbaord.data.toDomain
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val api: DashboardApiService
) : DashboardRepository {

    override suspend fun getDashboard(): DashBoardModel {
        return api.getDashboard().toDomain()
    }

}