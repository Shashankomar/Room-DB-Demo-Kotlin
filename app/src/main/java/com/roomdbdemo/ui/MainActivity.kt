package com.roomdbdemo.ui

import CountryListModel
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.roomdbdemo.R
import com.roomdbdemo.apiservice.APIClient
import com.roomdbdemo.database.CountryDB
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var db: CountryDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBaseInstance()
        getCountryDataFromAPI()
    }

    private fun dataBaseInstance() {
        db = Room.databaseBuilder(
            applicationContext,
            CountryDB::class.java, "CountryDB.db"
        ).build()
    }

    private fun getCountryDataFromAPI() {
        val call = APIClient.getClient.getCountryList()
        call.enqueue(object : Callback<List<CountryListModel>> {

            override fun onFailure(call: Call<List<CountryListModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "fail", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<CountryListModel>>,
                response: Response<List<CountryListModel>>
            ) {
                val list = response.body() ?: ArrayList()
                for (item in list)
                db.countryDao().insertData(item)

                val countryData = db.countryDao().getCountryData()
                setRecyclerView(countryData)
                Toast.makeText(this@MainActivity, "response", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setRecyclerView(countryList: List<CountryListModel>?) {
        rv_countries.adapter = CountryListAdapter(this, countryList)
        rv_countries.layoutManager = LinearLayoutManager(
            this
        )
    }
}