package com.codility.devicebattery

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import java.io.Serializable

/**
 * Created by Govind on 1/12/2018.
 */
class Model(val key: String, val value: String) : Serializable {


    companion object {
        val context: Context? = null

        @SuppressLint("MissingPermission", "HardwareIds")
        fun getDeviceInfo(): ArrayList<Model> {
            val list = ArrayList<Model>()
            list.clear()
            list.add(Model("MODEL", Build.MODEL))
            list.add(Model("MANUFACTURER", Build.MANUFACTURER))
            list.add(Model("BRAND", Build.BRAND))
            list.add(Model("HARDWARE", Build.HARDWARE))
            list.add(Model("BOARD", Build.BOARD))
            list.add(Model("BOOTLOADER", Build.BOOTLOADER))
            list.add(Model("CPU_ABI", Build.CPU_ABI))
            list.add(Model("DISPLAY", Build.DISPLAY))
            list.add(Model("FINGERPRINT", Build.FINGERPRINT))
            list.add(Model("HOST", Build.HOST))
            list.add(Model("BUILD NUMBER", Build.ID))
            list.add(Model("PRODUCT", Build.PRODUCT))
            list.add(Model("SERIAL", Build.SERIAL))
            list.add(Model("TAGS", Build.TAGS))
            list.add(Model("TYPE", Build.TYPE))
            list.add(Model("UNKNOWN", Build.UNKNOWN))
            list.add(Model("USER", Build.USER))
            list.add(Model("VERSION RELEASE", Build.VERSION.RELEASE))
            list.add(Model("VERSION SDK", Build.VERSION.SDK_INT.toString()))
            list.add(Model("VERSION INCREMENTAL", Build.VERSION.INCREMENTAL))
            return list
        }
    }
}