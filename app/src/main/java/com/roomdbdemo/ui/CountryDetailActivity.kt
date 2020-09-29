package com.roomdbdemo.ui

import CountryListModel
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.roomdbdemo.R
import kotlinx.android.synthetic.main.activity_country_detail.*

class CountryDetailActivity : AppCompatActivity() {
    private var responseDataList: CountryListModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)


        getDataFromIntent()
        setData()
    }

    private fun getDataFromIntent() {
        responseDataList = intent.extras?.get("dataList") as CountryListModel?
    }

    private fun setData() {
        GlideToVectorYou
            .init()
            .with(this)
            .setPlaceHolder(R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground)
            .load(Uri.parse(responseDataList?.flag), iv_image)

        tv_name.text = responseDataList?.name
        tv_capital.text = responseDataList?.capital
        tv_region.text = responseDataList?.region
        tv_subregion.text = responseDataList?.subregion

        val lang = StringBuilder()
        for (item in responseDataList?.languages!!) {
            lang.append(item.name).append(", ")
        }
        tv_language.text = lang.deleteCharAt(lang.length - 2).toString()
    }
}