package com.example.marsphoto.ui.Model

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsphoto.ui.data.MainViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private val base_url = "https://jsonplaceholder.typicode.com/"
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiService::class.java)
    }

}

@Composable
fun getData(mainViewModel: MainViewModel = viewModel()){
    LaunchedEffect(Dispatchers.IO ){
        val response = RetrofitInstance.apiInterface.getImages()
        if(response.isSuccessful){
            for (obj in response.body()!!){
                Log.i("Check Images", "On Complete : ${obj.url}")
                mainViewModel.photodata.add(obj.url)
            }
        }
    }
}