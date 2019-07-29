package com.nestorcalvo.calculadoraderesistencias

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color.parseColor
import android.graphics.drawable.ColorDrawable
import android.R.attr.button
import android.annotation.SuppressLint



class MainActivity : AppCompatActivity() {
    private var band1 = 1
    private var band2 = 0
    private var multiplier: Double = 1.0
    private var tolerancy = 0.0
    private var resultado: Double = 0.0
    private var mostrar:String = ""
    private var first = true



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setLogo(R.mipmap.ic_launcher_round);
        supportActionBar?.setDisplayUseLogoEnabled(true);

        resultado = ((band1.toDouble() * 10 + band2.toDouble()) * multiplier)
        tvResultado.text = ("$resultado Ω ±$tolerancy%")
    }

    @SuppressLint("ResourceAsColor")
    fun actualizar(view: View) {
        if (view is Button) {

            when (view.id) {
                R.id.btblack_2band ->
                    band2 = 0
                R.id.btblack_3band ->
                    multiplier = 1.0

                R.id.btbrown_1band ->
                    band1 = 1
                R.id.btbrown_2band ->
                    band2 = 1
                R.id.btbrown_3band ->
                    multiplier = 10.0
                R.id.btbrown_tolband ->
                    tolerancy = 1.0

                R.id.btred_1band ->
                    band1 = 2
                R.id.btred_2band ->
                    band2 = 2
                R.id.btred_3band ->
                    multiplier = 100.0
                R.id.btred_tolband ->
                    tolerancy = 2.0

                R.id.btorange_1band ->
                    band1 = 3
                R.id.btorange_2band ->
                    band2 = 3
                R.id.btorange_3band ->
                    multiplier = 1000.0

                R.id.btyellow_1band ->
                    band1 = 4
                R.id.btyellow_2band ->
                    band2 = 4
                R.id.btyellow_3band ->
                    multiplier = 10000.0

                R.id.btgreen_1band ->
                    band1 = 5
                R.id.btgreen_2band ->
                    band2 = 5
                R.id.btgreen_3band ->
                    multiplier = 100000.0
                R.id.btgreen_tolband ->
                    tolerancy = 0.5

                R.id.btblue_1band ->
                    band1 = 6
                R.id.btblue_2band ->
                    band2 = 6
                R.id.btblue_3band ->
                    multiplier = 1000000.0


                R.id.btpurple_1band ->
                    band1 = 7
                R.id.btpurple_2band ->
                    band2 = 7
                R.id.btpurple_3band ->
                    multiplier = 10000000.0


                R.id.btgray_1band ->
                    band1 = 8
                R.id.btgray_2band ->
                    band2 = 8
                R.id.btgray_3band ->
                    multiplier = 100000000.0

                R.id.btwhite_1band ->
                    band1 = 9
                R.id.btwhite_2band ->
                    band2 = 9
                R.id.btwhite_3band ->
                    multiplier = 1E9

                R.id.btgold_3band ->
                    multiplier = 0.1
                R.id.btgold_tolband ->
                    tolerancy = 5.0

                R.id.btsilver_3band ->
                    multiplier = 0.01
                R.id.btsilver_tolband ->
                    tolerancy = 10.0


            }

            resultado = ((band1.toDouble() * 10 + band2.toDouble()) * multiplier)


            val buttonColor = view.background as ColorDrawable
            when {
                view.text.toString().contains("1") -> llband1.setBackgroundColor(buttonColor.color)
                view.text.toString().contains("2") -> llband2.setBackgroundColor(buttonColor.color)
                view.text.toString().contains("3") -> llband3.setBackgroundColor(buttonColor.color)
                view.text.toString().contains("tol") -> lltolband.setBackgroundColor(buttonColor.color)
            }

            tvResultado.text = ("$resultado Ω ±$tolerancy% $mostrar")
        }

    }

}
