package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import android.widget.Button
import android.widget.TextView
import android.view.animation.AnimationUtils
import pl.droidsonroids.gif.GifImageView

class SlimeTest1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slimetest1)
        //角色1
        val ch1p1 = findViewById<ImageView>(R.id.s1ch1p1)
        val ch1p2 = findViewById<ImageView>(R.id.s1ch1p2)
        val ch1p3 = findViewById<ImageView>(R.id.s1ch1p3)
        val ch1p4 = findViewById<ImageView>(R.id.s1ch1p4)
        val ch1p5 = findViewById<ImageView>(R.id.s1ch1p5)
        val ch1p6 = findViewById<ImageView>(R.id.s1ch1p6)
        val ch1st = findViewById<ImageView>(R.id.s1ch1st)

        //史萊姆
        val s1slime = findViewById<GifImageView>(R.id.s1slime)

        //物件和效果
        val s1attack = findViewById<Button>(R.id.s1attack)
        val s1defense = findViewById<Button>(R.id.s1defense)
        val s1slimeattack = findViewById<ImageView>(R.id.s1slimeattack)
        val s1watermagic = findViewById<ImageView>(R.id.s1watermagic1)
        val s1watbomeff = findViewById<ImageView>(R.id.s1monstereff)
        val s1thundereff = findViewById<GifImageView>(R.id.theff)
        val s1hvalue = findViewById<TextView>(R.id.s1hurtvalue)
        val s1sheild = findViewById<ImageView>(R.id.s1shield)
        val s1hp = findViewById<TextView>(R.id.s1hp)
        val s1mhp = findViewById<TextView>(R.id.s1mhp)
        val s1deadeff = findViewById<ImageView>(R.id.s1deadeff)
        val s1ko = findViewById<ImageView>(R.id.s1ko)

        //變數區
        var s1healthpoint = 100
        var s1mhealthpoint = 50
        s1hp.text = s1healthpoint.toString()
        s1mhp.text = s1mhealthpoint.toString()
        val go = findViewById<Button>(R.id.go)


        ch1p1.visibility= View.GONE
        ch1p2.visibility= View.GONE
        ch1p3.visibility= View.GONE
        ch1p4.visibility= View.GONE
        ch1p5.visibility= View.GONE
        ch1p6.visibility= View.GONE
        s1watermagic.visibility= View.GONE
        s1watbomeff.visibility= View.GONE
        s1slimeattack.visibility= View.GONE
        s1thundereff.visibility= View.GONE
        s1sheild.visibility= View.GONE
        s1deadeff.visibility= View.GONE
        s1ko.visibility= View.GONE

        var magicatest1 = Intent(this,MagicaTest1::class.java)

        s1attack.setOnClickListener {

            val s1animationmagicanim = AnimationUtils.loadAnimation(this,R.anim.magic_anim)
            val s1animationbigger = AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            val s1animationsmaller = AnimationUtils.loadAnimation(this,R.anim.zoom_out)
            ch1st.visibility= View.GONE
            ch1p1.visibility= View.VISIBLE
            s1attack.visibility= View.GONE
            s1defense.visibility= View.GONE

            object : CountDownTimer(150,1000){
                override fun onFinish() {
                    ch1p1.visibility = View.GONE
                    ch1p2.visibility = View.VISIBLE
                }

            override fun onTick(millisUntilFinished: Long) {
                }
            }.start()

            object : CountDownTimer(300,1000){
                override fun onFinish() {
                    ch1p2.visibility = View.GONE
                    ch1p3.visibility = View.VISIBLE
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()

            object : CountDownTimer(450,1000){
                override fun onFinish() {
                    ch1p3.visibility = View.GONE
                    ch1p4.visibility = View.VISIBLE
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()

            object : CountDownTimer(600,1000){
                override fun onFinish() {
                    ch1p4.visibility = View.GONE
                    ch1p5.visibility = View.VISIBLE
                    s1thundereff.visibility = View.VISIBLE
                    s1hvalue.text="-"+60
                    s1mhealthpoint = s1mhealthpoint-50
                    s1mhp.text = s1mhealthpoint.toString()
                    if( s1mhealthpoint <= 0 ){
                        s1slime.visibility = View.GONE
                        s1deadeff.visibility = View.VISIBLE
                        s1deadeff.startAnimation(s1animationsmaller)
                        s1ko.visibility= View.VISIBLE
                        object : CountDownTimer(300,1000){
                            override fun onFinish() {
                                s1deadeff.clearAnimation()
                                s1deadeff.visibility=View.GONE
                            }

                            override fun onTick(millisUntilFinished: Long) {
                            }
                        }.start()
                    }


                        else{
                        object : CountDownTimer(150,1000){
                        override fun onFinish() {
                            ch1p5.visibility = View.GONE
                            ch1p6.visibility = View.VISIBLE
                        }

                        override fun onTick(millisUntilFinished: Long) {
                        }
                    }.start()
                        object : CountDownTimer(300,1000){
                            override fun onFinish() {
                                ch1p6.visibility = View.GONE
                                s1hvalue.text=""

                                ch1st.visibility = View.VISIBLE
                            }

                            override fun onTick(millisUntilFinished: Long) {
                            }
                        }.start()
                        object : CountDownTimer(350,1000){
                            override fun onFinish() {
                                s1thundereff.visibility = View.GONE
                                s1slimeattack.visibility= View.VISIBLE
                                s1slime.visibility= View.GONE
                                s1watermagic.visibility= View.VISIBLE
                                s1watermagic.startAnimation(s1animationmagicanim)
                            }

                            override fun onTick(millisUntilFinished: Long) {
                            }
                        }.start()
                        object : CountDownTimer(950,1000){
                            override fun onFinish() {
                                s1slimeattack.visibility= View.GONE
                                s1slime.visibility= View.VISIBLE
                                s1watbomeff.visibility= View.VISIBLE
                                s1watbomeff.startAnimation(s1animationbigger)
                            }

                            override fun onTick(millisUntilFinished: Long) {
                            }
                        }.start()
                        object : CountDownTimer(2050,1000){
                            override fun onFinish() {
                                s1watbomeff.clearAnimation()
                                s1watermagic.clearAnimation()
                                s1watbomeff.visibility= View.GONE
                                s1watermagic.visibility= View.GONE
                                s1attack.visibility= View.VISIBLE
                                s1defense.visibility= View.VISIBLE
                            }

                            override fun onTick(millisUntilFinished: Long) {
                            }
                        }.start()}
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()
        }


        s1defense.setOnClickListener {
            s1sheild.visibility= View.VISIBLE
            s1attack.visibility= View.GONE
            s1defense.visibility= View.GONE
            object : CountDownTimer(2650,1000){
                override fun onFinish() {
                    s1sheild.visibility= View.GONE
                    s1attack.visibility= View.VISIBLE
                    s1defense.visibility= View.VISIBLE
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()

        }
        go.setOnClickListener { startActivity(magicatest1) }




    }
}