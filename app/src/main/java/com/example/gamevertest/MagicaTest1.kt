package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class MagicaTest1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magica_test1)
        //Magica
        val m1magicast= findViewById<GifImageView>(R.id.m1magicast)
        val m1magicaatk= findViewById<GifImageView>(R.id.m1magicaatk)
        val m1magicadef= findViewById<GifImageView>(R.id.m1magicadef)
        //血量
        val m1hp= findViewById<TextView>(R.id.m1hp)
        val m1mhp= findViewById<TextView>(R.id.m1mhp)
        //特效
        val m1ultlazer= findViewById<ImageView>(R.id.m1ultlazer)
        val m1freezelazer= findViewById<ImageView>(R.id.m1freezelazer)
        val m1shield= findViewById<ImageView>(R.id.m1shield)
        //按鈕
        val m1attack= findViewById<Button>(R.id.m1attack)
        val m1defense= findViewById<Button>(R.id.m1defense)
        //變數
        var m1healthpoint = 100
        var m1mhealthpoint = 50
        m1hp.text= m1healthpoint.toString()
        m1mhp.text= m1mhealthpoint.toString()

        m1attack.setOnClickListener {
            var coin= (0..4).random()
            if(coin <= 1){
                m1magicast.visibility= View.GONE
                m1magicaatk.visibility= View.VISIBLE
                object : CountDownTimer(150,1000){
                    override fun onFinish() {
                        m1freezelazer.visibility= View.VISIBLE
                        object : CountDownTimer(1150,1000){
                            override fun onFinish() {
                                m1freezelazer.visibility= View.GONE
                                m1magicast.visibility= View.VISIBLE
                                m1magicaatk.visibility= View.GONE
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start() }
            else if (coin <= 3){
                m1magicast.visibility= View.GONE
                m1magicadef.visibility= View.VISIBLE
                m1shield.visibility=View.VISIBLE
                object : CountDownTimer(1000,1000) {
                    override fun onFinish() {
                        m1magicast.visibility = View.VISIBLE
                        m1magicadef.visibility = View.GONE
                        m1shield.visibility = View.GONE
                    }

                    override fun onTick(millisUntilFinished: Long) {}
                }.start() }
            else {
                m1magicast.visibility= View.GONE
                m1magicaatk.visibility= View.VISIBLE
                object : CountDownTimer(150,1000){
                    override fun onFinish() {
                        m1ultlazer.visibility= View.VISIBLE
                        object : CountDownTimer(1150,1000){
                            override fun onFinish() {
                                m1ultlazer.visibility= View.GONE
                                m1magicast.visibility= View.VISIBLE
                                m1magicaatk.visibility= View.GONE
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start() } }
    }
}


