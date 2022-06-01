package com.skinconnect.userapps.data.remote

import com.skinconnect.userapps.data.entity.LoginRequest
import com.skinconnect.userapps.data.entity.RegisterRequest
import com.skinconnect.userapps.data.entity.response.LoginResponse
import com.skinconnect.userapps.data.entity.response.RegisterResponse
import com.skinconnect.userapps.data.entity.response.ScheduleResponse
import retrofit2.http.*

interface ApiService {
    @POST("users/login")
    suspend fun login(@Body request: LoginRequest) : LoginResponse

    @POST("users/register")
    suspend fun register(@Body request: RegisterRequest) : RegisterResponse

    @GET("users//schedule")
    suspend fun  schedule(
        @Header("Authorization") authorization: String): ScheduleResponse

}