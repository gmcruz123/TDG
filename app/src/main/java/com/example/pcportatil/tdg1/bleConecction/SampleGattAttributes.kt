package com.example.pcportatil.tdg1.bleConecction

import java.util.HashMap

/**
 * Created by PC portatil on 24/01/2018.
 */

object SampleGattAttributes {
    private val  attributes : HashMap<String, String> =  HashMap()
    var HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb"
    var CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb"

    init {
        // Sample Services.
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate Service")
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information Service")
        // Sample Characteristics.
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement")
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String")
    }

    fun lookup(uuid: String, defaultName: String): String {
        val name = attributes.get(uuid)
        return name ?: defaultName
    }
}