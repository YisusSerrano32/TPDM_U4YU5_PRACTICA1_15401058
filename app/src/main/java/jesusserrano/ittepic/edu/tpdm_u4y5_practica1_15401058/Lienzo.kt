package jesusserrano.ittepic.edu.tpdm_u4y5_practica1_15401058

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class Lienzo (p : MainActivity) : View(p){
    var puntero = p

    var iconoX = 30f
    var icono1_1 = Imagen(this, iconoX, 200f, R.drawable.face1)
    var icono1_2 = Imagen(this, iconoX+330f, 200f, R.drawable.insta1)
    var icono1_3 = Imagen(this, iconoX+630f, 200f, R.drawable.twit1)
    var icono1_4 = Imagen(this, iconoX+930f, 200f, R.drawable.whats1)
    var icono1_5 = Imagen(this, iconoX+1230f, 200f, R.drawable.youtube1)

    var icono2_1 = Imagen(this, iconoX, 200f, R.drawable.face2)
    var icono2_2 = Imagen(this, iconoX+330f, 200f, R.drawable.insta2)
    var icono2_3 = Imagen(this, iconoX+630f, 200f, R.drawable.twit2)
    var icono2_4 = Imagen(this, iconoX+930f, 200f, R.drawable.whats2)
    var icono2_5 = Imagen(this, iconoX+1230f, 200f, R.drawable.youtube2)

    var icono3_1 = Imagen(this, iconoX,200f, R.drawable.face3)
    var icono3_2 = Imagen(this, iconoX+330f, 200f, R.drawable.insta3)
    var icono3_3 = Imagen(this, iconoX+630f, 200f, R.drawable.twit3)
    var icono3_4 = Imagen(this, iconoX+930f, 200f, R.drawable.whats3)
    var icono3_5 = Imagen(this, iconoX+1230f, 200f, R.drawable.youtube3)

    var movY = 0f
    var icono : Imagen ?= null

    var Imagenes1 = arrayListOf(icono1_1,icono1_2,icono1_3,icono1_4,icono1_5)
    var Imagenes2 = arrayListOf(icono2_1,icono2_2,icono2_3,icono2_4,icono2_5)
    var Imagenes3 = arrayListOf(icono3_1,icono3_2,icono3_3,icono3_4,icono3_5)

    override fun onDraw(c : Canvas) {
        super.onDraw(c)
        var p= Paint()
        if(puntero.proximidad == 0f){
            p.color= Color.WHITE
            c.drawCircle(200f,500f,5000f,p)
            invalidate()
        }else{
            when (puntero.shake) {
                0 -> {
                    icono1_1.pintar(c)
                    icono1_2.pintar(c)
                    icono1_3.pintar(c)
                    icono1_4.pintar(c)
                    icono1_5.pintar(c)
                    iconos1()
                }
                1 -> {
                    icono2_1.pintar(c)
                    icono2_2.pintar(c)
                    icono2_3.pintar(c)
                    icono2_4.pintar(c)
                    icono2_5.pintar(c)
                    iconos2()
                }
                2 -> {
                    icono3_1.pintar(c)
                    icono3_2.pintar(c)
                    icono3_3.pintar(c)
                    icono3_4.pintar(c)
                    icono3_5.pintar(c)
                    iconos3()
                }
            }
        }
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {

        when(e.action) {
            MotionEvent.ACTION_DOWN -> {
                if (icono1_1.estaEnArea(e.getX(), e.getY()) || icono2_1.estaEnArea(e.getX(), e.getY()) || icono3_1.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste Facebook", Toast.LENGTH_SHORT).show()
                    icono = icono1_1
                }
                if (icono1_2.estaEnArea(e.getX(), e.getY()) || icono2_2.estaEnArea(e.getX(), e.getY()) || icono3_2.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste Instagram", Toast.LENGTH_SHORT).show()
                    icono = icono1_2
                }
                if (icono1_3.estaEnArea(e.getX(), e.getY()) || icono2_3.estaEnArea(e.getX(), e.getY()) || icono3_3.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste Twitter", Toast.LENGTH_SHORT).show()
                    icono = icono1_3
                }
                if (icono1_4.estaEnArea(e.getX(), e.getY()) || icono2_4.estaEnArea(e.getX(), e.getY()) || icono3_4.estaEnArea(e.getX(), e.getY())
                ) {
                    Toast.makeText(puntero, "Tocaste Whatsapp", Toast.LENGTH_SHORT).show()
                    icono = icono1_4
                }
                if (icono1_5.estaEnArea(e.getX(), e.getY()) || icono2_5.estaEnArea(e.getX(), e.getY()) || icono3_5.estaEnArea(e.getX(), e.getY())) {
                    Toast.makeText(puntero, "Tocaste Youtube", Toast.LENGTH_SHORT).show()
                    icono = icono1_5
                }
            }
        }
        return true
    }

    fun  iconos1() {

        if (puntero.mov_y > 0) {
            movY = 0f
            Imagenes1.forEach {
                it.mover(movY)
            }
            invalidate()
        }
        if (puntero.mov_y <0) {
            movY = 1f
            Imagenes1.forEach {
                it.mover(movY)
            }
            invalidate()
        }
        invalidate()
    }

    fun  iconos2() {
        if (puntero.mov_y > 0) {
            movY = 0f
            Imagenes2.forEach {
                it.mover(movY)
            }
            invalidate()
        }
        if (puntero.mov_y <0) {
            movY = 1f
            Imagenes2.forEach {
                it.mover(movY)
            }
            invalidate()
        }
        invalidate()
    }

    fun  iconos3() {

        if (puntero.mov_y > 0) {
            movY = 0f
            Imagenes3.forEach {
                it.mover(movY)
            }
            invalidate()
        }
        if (puntero.mov_y <0) {
            movY = 1f
            Imagenes3.forEach {
                it.mover(movY)
            }
            invalidate()
        }
        invalidate()
    }

}
