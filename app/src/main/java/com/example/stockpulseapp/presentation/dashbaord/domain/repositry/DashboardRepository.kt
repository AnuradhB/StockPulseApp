package com.example.stockpulseapp.presentation.dashbaord.domain.repositry

import com.example.stockpulseapp.presentation.dashbaord.domain.model.DashBoardModel

interface DashboardRepository {

    suspend fun getDashboard(): DashBoardModel


}