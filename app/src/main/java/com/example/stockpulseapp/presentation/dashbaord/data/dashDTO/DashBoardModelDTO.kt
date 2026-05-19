package com.example.stockpulseapp.presentation.dashbaord.data.dashDTO

import com.example.stockpulseapp.presentation.dashbaord.domain.model.Data
import com.example.stockpulseapp.presentation.dashbaord.domain.model.Time

data class DashBoardModelDTO
    (
    val Data: Data,
    val Message: String,
    val StatusCode: Int,
    val Success: Boolean,
    val Time: Time
            )