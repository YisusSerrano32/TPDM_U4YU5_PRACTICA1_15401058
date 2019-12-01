package jesusserrano.ittepic.edu.tpdm_u4y5_practica1_15401058

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteAcelerometroYShake (p:MainActivity): SensorEventListener{
    var puntero = p
    var ultimaAct: Long = 0

    var x = 0f
    var y = 0f
    var z = 0f
    var ult_x = 0f
    var ult_y = 0f
    var ult_z = 0f

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(e: SensorEvent?) {
        // Movimiento en y
        puntero.mov_y = e!!.values[1]


        // Shake
        var tiempoAct: Long = System.currentTimeMillis()

        if ((tiempoAct - ultimaAct) > 100) {
            var diferenciaTiempo = (tiempoAct - ultimaAct)
            ultimaAct = tiempoAct;

            x = e!!.values[0]
            y = e!!.values[1]
            z = e!!.values[2]

            var velocidad : Float = Math.abs(x+y+z - ult_x - ult_y - ult_z) / diferenciaTiempo * 10000;

            if ( velocidad > 800) {
                if(puntero.shake==2){puntero.shake = 0}
                else
                    puntero.shake++
            }
            ult_x = x
            ult_y = y
            ult_z = z
        }
    }


}