package ejercicio.hitss.octaviano.utils

import android.content.Context
import android.content.res.Configuration


object DeviceUtility {
    enum class Device {
        PHONE,
        TABLET
    }

    private fun getDevice5inch(context: Context): Boolean {
        return try {
            val displayMetrics = context.resources.displayMetrics
            val yinch = displayMetrics.heightPixels / displayMetrics.ydpi
            val xinch = displayMetrics.widthPixels / displayMetrics.xdpi
            val diagonalinch = Math.sqrt(xinch * xinch + yinch * yinch.toDouble())
            diagonalinch >= 7
        } catch (e: Exception) {
            false
        }

    }

    private fun isTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }


    fun getDeviceType(context: Context): Device {
        try {

            return if (isTablet(context)) {
                if (getDevice5inch(context)) {
                    Device.TABLET
                } else {
                    Device.PHONE
                }
            } else {
                Device.PHONE
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return Device.PHONE
    }

}