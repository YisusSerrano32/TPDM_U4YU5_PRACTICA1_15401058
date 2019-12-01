package jesusserrano.ittepic.edu.tpdm_u4y5_practica1_15401058

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var sensorManager: SensorManager?= null
    var oyenteProximidad : OyenteProximidad ?= null
    var oyenteAcelerometroYShake : OyenteAcelerometroYShake ?= null

    var shake = 0
    var mov_y = 0f
    var proximidad = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        oyenteProximidad = OyenteProximidad(this)
        oyenteAcelerometroYShake = OyenteAcelerometroYShake(this)

        sensorManager?.registerListener(oyenteProximidad,sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager?.registerListener(oyenteAcelerometroYShake,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)


    }

}

