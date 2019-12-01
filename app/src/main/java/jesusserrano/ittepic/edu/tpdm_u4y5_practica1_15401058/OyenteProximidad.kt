package jesusserrano.ittepic.edu.tpdm_u4y5_practica1_15401058

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteProximidad (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
    override fun onSensorChanged(event: SensorEvent?) {
        puntero.proximidad = event!!.values[0]
    }

}