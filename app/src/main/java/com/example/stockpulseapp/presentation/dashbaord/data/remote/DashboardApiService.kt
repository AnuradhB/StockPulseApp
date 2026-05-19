package com.example.stockpulseapp.presentation.dashbaord.data.remote

import com.example.stockpulseapp.presentation.dashbaord.data.dashDTO.DashBoardModelDTO
import retrofit2.http.GET

interface DashboardApiService {

    @GET("Dashboard/GetDashboardData")
    suspend fun getDashboard(): DashBoardModelDTO

//    @GET("banners")
//    suspend fun getBanners(): List<BannerDto>
//
//    @GET("orders")
//    suspend fun getOrders(): List<OrderDto>
}