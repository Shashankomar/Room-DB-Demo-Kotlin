package com.roomdbdemo.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Country::class], version = 1)
 abstract class CountryDB : RoomDatabase() {
    abstract fun countryDao(): CountryDao

}
