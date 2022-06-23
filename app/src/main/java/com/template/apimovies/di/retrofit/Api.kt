package com.template.apimovies.di.retrofit

import com.template.apimovies.data.ExampleJson2KtKotlin
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/svc/movies/v2/reviews/all.json")
    suspend fun getData(@Query("api-key") key: String): Response<ExampleJson2KtKotlin>
}