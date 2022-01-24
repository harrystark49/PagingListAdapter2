package com.example.paginglistadapter2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        var baseurl = "https://rickandmortyapi.com/api/"

        fun retroinst(): Retrofit {
            return  Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}