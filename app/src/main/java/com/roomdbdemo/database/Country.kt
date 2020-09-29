package com.roomdbdemo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Country is a table name
*
* country_name, country_capital, country_region, country_subregion, languages, flag_image are table columns.
*
* */

@Entity()
data class Country(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "country_name")
    val countryName: String?,
    @ColumnInfo(name = "country_capital")
    val capital: String?,
    @ColumnInfo(name = "country_region")
    val region: String?,
    @ColumnInfo(name = "country_subregion")
    val subRegion: String?,
    @ColumnInfo(name = "languages")
    val languages: String?,
    @ColumnInfo(name = "flag_image")
    val flag: String?
)