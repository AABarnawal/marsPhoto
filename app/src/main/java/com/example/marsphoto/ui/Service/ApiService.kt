package com.example.marsphoto.ui.Model

import com.example.marsphoto.ui.data.MarsPhoto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("photos")
    suspend fun getImages(): Response<List<MarsPhoto>>
}

