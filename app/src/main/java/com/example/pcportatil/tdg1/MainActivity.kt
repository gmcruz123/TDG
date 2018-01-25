package com.example.pcportatil.tdg1

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanRecord
import android.bluetooth.le.ScanResult
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.support.v4.content.PermissionChecker
import android.util.Log




class MainActivity : AppCompatActivity() {

    private lateinit var bluetoothAdapter:BluetoothAdapter
    lateinit var  bluetoothManager:BluetoothManager
    lateinit var mHandler:Handler
    val scanPeriod:Long = 5000
    var mscanning:Boolean= false

    private val bluetoothLeScanner: BluetoothLeScanner
        get() {
            val bluetoothManager = applicationContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
            val bluetoothAdapter = bluetoothManager.adapter
            return bluetoothAdapter.bluetoothLeScanner
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHandler = Handler()
       bluetoothManager= getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter

        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            val REQUEST_ENABLE_BT = 1
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
        }

        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.d("ScanDeviceActivity", "onStart()")
        super.onStart()
        when (PermissionChecker.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
            PackageManager.PERMISSION_GRANTED -> bluetoothLeScanner.startScan(bleScanner)
            else -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 1)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> when (grantResults) {
                intArrayOf(PackageManager.PERMISSION_GRANTED) -> {
                    Log.d("ScanDeviceActivity", "onRequestPermissionsResult(PERMISSION_GRANTED)")
                    bluetoothLeScanner.startScan(bleScanner)
                }
                else -> {
                    Log.d("ScanDeviceActivity", "onRequestPermissionsResult(not PERMISSION_GRANTED)")
                }
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }



    override fun onResume() {
        super.onResume()

        if (bluetoothAdapter != null){
            scanLeDevice(true)

        }

    }


    private val bleScanner =  object : ScanCallback(){
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            Log.d("Hola","123")
            Log.i("Device Name: " , result.getDevice().getName() + " rssi: " + result.getRssi() + "\n")


        }
    }




    private fun scanLeDevice(enable:Boolean){
    if (enable){
    Log.i("Hola","Si entro")
        mscanning = true
        bluetoothAdapter.bluetoothLeScanner.startScan(bleScanner) } }





}



