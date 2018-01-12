package com.codility.devicebattery

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.codility.devicebattery.adpater.TabsPagerAdapter

/**
 * Created by Govind on 1/10/2018.
 */
class MainActivity : AppCompatActivity() {
    var myAdapter: TabsPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vpPager = findViewById<ViewPager>(R.id.viewpager) as ViewPager
        myAdapter = TabsPagerAdapter(supportFragmentManager)
        vpPager.adapter = myAdapter
    }
}