package com.example.stockpulseapp.presentation.dashbaord.presenting

import com.example.stockpulseapp.presentation.dashbaord.domain.model.DashBoardModel

data class DashboardState(
    val isLoading: Boolean = false,
    val data: DashBoardModel? = null,


    val error: String = ""
)