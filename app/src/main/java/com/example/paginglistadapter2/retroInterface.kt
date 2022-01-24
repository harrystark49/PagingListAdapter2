package com.example.paginglistadapter2

import com.example.paginglistadapter2.networkdata.diffSpecies
import retrofit2.http.GET
import retrofit2.http.Query

interface retroInterface {
    @GET("character")
    suspend fun getDataFromAPI(@Query("page")query :Int):diffSpecies
}