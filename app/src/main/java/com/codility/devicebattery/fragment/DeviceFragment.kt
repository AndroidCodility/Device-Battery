package com.codility.devicebattery.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.codility.devicebattery.Model
import com.codility.devicebattery.R
import com.codility.devicebattery.adpater.MyAdapter


/**
 * Created by Govind on 1/10/2018.
 */
class DeviceFragment : Fragment() {
    private val REQUEST_CODE_PHONE_STATE_READ = 100
    private var checkedPermission = PackageManager.PERMISSION_DENIED
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.device, container, false)

        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        checkedPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE);
        if (Build.VERSION.SDK_INT >= 23 && checkedPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
        } else {
            checkedPermission = PackageManager.PERMISSION_GRANTED;
            setDeviceList()
        }

        return view
    }

    @SuppressLint("MissingPermission")
    private fun setDeviceList() {
        val manager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        recyclerView!!.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val devices = ArrayList<Model>()
        devices.addAll(Model.getDeviceInfo())
        if (manager.deviceId != null) {
            devices.add(Model("IMEI", manager.deviceId))
        }
        val myAdapter = MyAdapter(devices)
        recyclerView!!.adapter = myAdapter
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_PHONE_STATE_READ -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                checkedPermission = PackageManager.PERMISSION_GRANTED
                setDeviceList()
            }
        }
    }

    private fun requestPermission() {
        Toast.makeText(context, "Requesting permission", Toast.LENGTH_SHORT).show()
        this.requestPermissions(arrayOf(Manifest.permission.READ_PHONE_STATE),
                REQUEST_CODE_PHONE_STATE_READ)
    }
}