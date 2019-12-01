package jesusserrano.ittepic.edu.tpdm_u4y5_practica1_15401058

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l:Lienzo,posx:Float,posy:Float,img:Int) {
    var x = posx
    var y = posy
    var imagen = BitmapFactory.decodeResource(l.resources,img)

    fun pintar(c: Canvas) {
        c.drawBitmap(imagen, x, y, Paint())
    }

    fun estaEnArea(toquex: Float, toquey: Float): Boolean {
        var x2 = x + imagen.width
        var y2 = y + imagen.height

        if (toquex >= x && toquex <= x2) {
            if (toquey >= y && toquey <= y2) {
                return true
            }
        }
        return false
    }

    fun mover(y1: Float) {
        if (y1 == 0f)
            x = x - 5
        else
            x = x + 5
    }
}