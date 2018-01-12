package com.codility.devicebattery.adpater

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.codility.devicebattery.fragment.BatteryFragment
import com.codility.devicebattery.fragment.DeviceFragment

/**
 * Created by Govind on 1/10/2018.
 */
class TabsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val NUM_ITEMS = 2
    private val titles = arrayOf("Device", "Battery")

    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return DeviceFragment()
            1 -> return BatteryFragment()
            else -> return null
        }
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}