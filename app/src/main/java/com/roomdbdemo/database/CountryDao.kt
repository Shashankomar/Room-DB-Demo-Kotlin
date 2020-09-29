package com.roomdbdemo.database

import CountryListModel
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryDao {

    @Query("select * from Country")
    fun getCountryData(): List<CountryListModel>

    @Insert
    fun insertData(country: CountryListModel)

}