package com.roomdbdemo.apiservice

import CountryListModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("region/asia")
    fun getCountryList(): Call<List<CountryListModel>>
}
