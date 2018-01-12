package com.codility.devicebattery.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codility.devicebattery.R

/**
 * Created by Govind on 1/12/2018.
 */
class BatteryFragment : Fragment() {
    private var tvBattery: TextView? = null
    var intentfilter: IntentFilter? = null
    var deviceStatus: Int = 0
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.battery, container, false)
        intentfilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        tvBattery = view.findViewById(R.id.tvBattery) as TextView

        context.registerReceiver(broadcastReceiver, intentfilter);
        return view
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryLevel = (level.toFloat() / scale.toFloat() * 100.0f).toInt()

            if (deviceStatus === BatteryManager.BATTERY_STATUS_CHARGING) {
                tvBattery!!.text = "Charging at " + batteryLevel + " %"
            }

            if (deviceStatus === BatteryManager.BATTERY_STATUS_DISCHARGING) {
                tvBattery!!.text = "Discharging at " + batteryLevel + " %"
            }

            if (deviceStatus === BatteryManager.BATTERY_STATUS_FULL) {
                tvBattery!!.text = "Battery Full at " + batteryLevel + " %"

            }

            if (deviceStatus === BatteryManager.BATTERY_STATUS_UNKNOWN) {
                tvBattery!!.text = "Unknown at " + batteryLevel + " %"
            }

            if (deviceStatus === BatteryManager.BATTERY_STATUS_NOT_CHARGING) {
                tvBattery!!.text = "Not Charging at " + batteryLevel + " %"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        context.unregisterReceiver(broadcastReceiver)
    }
}