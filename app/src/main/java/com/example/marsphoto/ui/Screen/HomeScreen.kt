package com.example.marsphoto.ui.Screen

import android.annotation.SuppressLint
import android.provider.Settings.Global.getString
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.marsphoto.ui.Model.getData
import com.example.marsphoto.ui.data.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreen(mainViewModel: MainViewModel = viewModel()){
    getData()
    Scaffold(
        topBar = (
                {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(text = "Mars Photo")
                        }
                    )
                }
                )
    ) {
//        Column() {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg")
//                    .crossfade(true)
//                    .build(),
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize()
//            )
//            GlideImage(
//                model = "https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg",
//                contentDescription = "",
//                modifier = Modifier.padding(10.dp).fillMaxSize()
//            )
//
//        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()

        ){
            item{
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg")
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            items(mainViewModel.photodata.size){index->
                GlideImage(
                model = mainViewModel.photodata[index],
                contentDescription = "",
                modifier = Modifier.padding(10.dp).fillMaxSize()
            )
//                Image(
//                    painter =rememberAsyncImagePainter(mainViewModel.photodata[index]) ,
//                    contentDescription = "",
//                    modifier = Modifier.fillMaxWidth()
//
//                )
            }
        }
    }
}
