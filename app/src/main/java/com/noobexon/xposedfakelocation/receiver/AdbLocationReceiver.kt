package com.noobexon.xposedfakelocation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.noobexon.xposedfakelocation.data.repository.PreferencesRepository

class AdbLocationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val lat = intent?.getStringExtra("lat")?.toDoubleOrNull()
        val lon = intent?.getStringExtra("lon")?.toDoubleOrNull()

        if (lat != null && lon != null && context != null) {
            val repo = PreferencesRepository(context)
            repo.saveLatitude(lat.toFloat()) // toFloat() dönüşümü doğru şekilde yapılmalı
            repo.saveLongitude(lon.toFloat()) // toFloat() dönüşümü doğru şekilde yapılmalı
            Log.i("FakeLocation", "ADB ile konum güncellendi: $lat, $lon")
        }
    }
}