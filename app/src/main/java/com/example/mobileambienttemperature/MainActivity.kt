package com.example.mobileambienttemperature

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var pressure: Sensor? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        pressure = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Do something here if sensor accuracy changes.
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            val ambient_temperature = event.values[0]
            findViewById<TextView>(R.id.temperature_output).text = ambient_temperature.toString() + " °C"
        }
    }

    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager.registerListener(this, pressure, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}
