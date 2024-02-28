package com.example.showevents.network

import com.example.showevents.models.Event
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://panel.mait.ac.in:8002"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()
interface ApiService{

    @GET("/event/get")
    fun getAllData(): Call<List<Event>>

}

object Api{
    val retrofitService: ApiService by lazy{retrofit.create(ApiService::class.java)}
}