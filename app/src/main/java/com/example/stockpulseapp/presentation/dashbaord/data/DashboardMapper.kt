package com.example.stockpulseapp.presentation.dashbaord.data

import com.example.stockpulseapp.presentation.dashbaord.domain.model.DashBoardModel
import com.example.stockpulseapp.presentation.dashbaord.data.dashDTO.DashBoardModelDTO

fun DashBoardModelDTO.toDomain(): DashBoardModel {

    return DashBoardModel(
        Data,
        Message,

        StatusCode,
        Success, Time
    )
}