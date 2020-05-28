package com.example.mobileambienttemperature

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() , SensorEventListener {
    private lateinit var sensorManager: SensorManager

    private var temperatureSensor: Sensor? = null
    private var light: Sensor? = null
    private var rotationVectorSensor: Sensor? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Do something here if sensor accuracy changes.
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            val ambient_temperature = event.values[0]
            findViewById<TextView>(R.id.temperature_output).text = ambient_temperature.toString() + " °C"
        } else if (event.sensor.type == Sensor.TYPE_LIGHT) {
            val lightValue = event.values[0]
            val image = findViewById<ImageView>(R.id.imageLogo)
            findViewById<TextView>(R.id.output_light).text = lightValue.toString() + " lx"
            var lightCalculate = lightValue / 4
            lightCalculate /= 10000
            image.animate().alpha(lightCalculate).setDuration(0)
        } else if (event.sensor.type == Sensor.TYPE_ROTATION_VECTOR) {
            val rotationMatrix = FloatArray(16)
            SensorManager.getRotationMatrixFromVector(
                rotationMatrix, event.values
            )
            val remappedRotationMatrix = FloatArray(16)
            SensorManager.remapCoordinateSystem(
                rotationMatrix,
                SensorManager.AXIS_X,
                SensorManager.AXIS_Z,
                remappedRotationMatrix
            )
            val orientations = FloatArray(3)
            SensorManager.getOrientation(remappedRotationMatrix, orientations)

            for (i in 0..2) {
                orientations[i] =
                    Math.toDegrees(orientations[i].toDouble()).toFloat()
            }
            val image = findViewById<ImageView>(R.id.imageLogo)
            image.animate().rotation(orientations[2]).setDuration(0)
            findViewById<TextView>(R.id.output_degree).text = orientations[2].toString() + " °"
        }
    }

    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, rotationVectorSensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}



