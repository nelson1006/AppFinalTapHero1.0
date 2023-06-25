package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class SlimeTest4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slimetest4)
        //角色
        val s4ch1st= findViewById<GifImageView>(R.id.s4ch1st)
        val s4ch1atk= findViewById<ImageView>(R.id.s4ch1attack)
        val s4ch1def= findViewById<GifImageView>(R.id.s4ch1defense)
        //史萊姆
        val s4slime= findViewById<GifImageView>(R.id.s4slime)
        val s4slimeatk= findViewById<ImageView>(R.id.s4slimeattack)
        //血量
        val s4hp= findViewById<TextView>(R.id.s4hp)
        val s4mhp= findViewById<TextView>(R.id.s4mhp)
        //特效
        val s4watermagic= findViewById<ImageView>(R.id.s4watermagic1)
        val s4mhvalue= findViewById<TextView>(R.id.s4mhurtvalue)
        val s4hvalue= findViewById<TextView>(R.id.s4hurtvalue)
        val s4monstereff= findViewById<ImageView>(R.id.s4monstereff)
        val s4bloody = findViewById<GifImageView>(R.id.s4bloodyeff)
        val s4victory = findViewById<GifImageView>(R.id.s4victory)
        val s4defeat = findViewById<GifImageView>(R.id.s4defeat)
        //按鈕
        val s4attack= findViewById<Button>(R.id.s4attack)
        val s4defense= findViewById<Button>(R.id.s4defense)
        //變數
        var s4attackpoint = intent.getIntExtra("atk",0)
        var s4defensepoint = intent.getIntExtra("def",0)
        var s4healthpoint = intent.getIntExtra("hp",0)
        var s4mlv = intent.getIntExtra("mlv",0)
        var s4id = intent.getIntExtra("id",0)
        var s4mattackpoint = s4mlv*2+10
        var s4mdefensepoint = s4mlv*2+3
        var s4mhealthpoint = s4mlv*5+35
        s4hp.text= s4healthpoint.toString()
        s4mhp.text= s4mhealthpoint.toString()
        //跳轉
        val s4gameset = Intent(this,Addpoint::class.java)
        val s4gameover = Intent(this,Addpoint::class.java)

        s4hp.text= s4healthpoint.toString()
        s4mhp.text= s4mhealthpoint.toString()

        s4attack.setOnClickListener {
            val s4animationmagicanim = AnimationUtils.loadAnimation(this,R.anim.magic_anim)
            val s4animationbigger = AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            val s4animationsmaller = AnimationUtils.loadAnimation(this,R.anim.zoom_out)
            s4attack.visibility= View.GONE
            s4defense.visibility= View.GONE
            s4ch1st.visibility=View.GONE
            s4ch1atk.visibility= View.VISIBLE
            s4bloody.visibility= View.VISIBLE

            var knightdata = Bundle()
            knightdata.putInt("atk",s4attackpoint)
            knightdata.putInt("def",s4defensepoint)
            knightdata.putInt("hp",intent.getIntExtra("hp",0))
            knightdata.putInt("mlv",s4mlv+1)
            knightdata.putInt("id",s4id)
            knightdata.putInt("test",2)
            s4gameset.putExtras(knightdata)

            var s4mhurtvalue = s4attackpoint-s4mdefensepoint
            var s4hurtvalue = s4mattackpoint
            if(s4mhurtvalue<=0){s4mhurtvalue=0}
            if(s4hurtvalue<=0){s4hurtvalue=0}
            object : CountDownTimer(1000,1000){
                override fun onFinish() {
                    s4ch1atk.visibility = View.GONE
                    s4bloody.visibility= View.GONE
                    s4ch1st.visibility = View.VISIBLE
                    s4mhvalue.text = "-"+s4mhurtvalue
                    s4mhealthpoint = s4mhealthpoint-s4mhurtvalue
                    s4mhp.text= s4mhealthpoint.toString()
                    if(s4mhealthpoint <=0 ){
                        s4victory.visibility= View.VISIBLE
                        object :CountDownTimer(1000,1000){
                            override fun onFinish() { startActivity(s4gameset) }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()}
                    else{object : CountDownTimer(350,1000){
                        override fun onFinish() {
                            s4mhvalue.text = ""
                            s4slimeatk.visibility= View.VISIBLE
                            s4slime.visibility= View.GONE
                            s4watermagic.visibility= View.VISIBLE
                            s4watermagic.startAnimation(s4animationmagicanim)
                        }

                        override fun onTick(millisUntilFinished: Long) {
                        }
                    }.start()

                        object : CountDownTimer(750,1000){
                            override fun onFinish() {
                                s4slimeatk.visibility= View.GONE
                                s4slime.visibility= View.VISIBLE
                                s4monstereff.visibility= View.VISIBLE
                                s4monstereff.startAnimation(s4animationbigger)
                                s4hvalue.text = "-"+s4hurtvalue
                                s4healthpoint = s4healthpoint-s4hurtvalue
                                s4hp.text= s4healthpoint.toString()
                                if(s4healthpoint<=0){s4defeat.visibility=View.VISIBLE
                                    object:CountDownTimer(1000,1000){
                                        override fun onFinish() { startActivity(s4gameover) }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    } }
                                else{object : CountDownTimer(1000,1000){
                                    override fun onFinish() {
                                        s4monstereff.clearAnimation()
                                        s4watermagic.clearAnimation()
                                        s4monstereff.visibility= View.GONE
                                        s4watermagic.visibility= View.GONE
                                        s4ch1st.visibility=View.VISIBLE
                                        s4attack.visibility= View.VISIBLE
                                        s4defense.visibility= View.VISIBLE
                                        s4hvalue.text = ""
                                    }

                                    override fun onTick(millisUntilFinished: Long) {
                                    }
                                }.start()}
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                        }
                }
                override fun onTick(millisUntilFinished: Long) {}
            }.start()
        }
        s4defense.setOnClickListener {
            var s4hurtvalue = s4mattackpoint-s4defensepoint
            if(s4hurtvalue<=0){s4hurtvalue=0}
            val s4animationmagicanim = AnimationUtils.loadAnimation(this,R.anim.magic_anim)
            s4attack.visibility= View.GONE
            s4defense.visibility= View.GONE
            s4ch1st.visibility=View.GONE
            s4ch1def.visibility= View.VISIBLE

        object:CountDownTimer(500,1000){
            override fun onFinish() {
                object : CountDownTimer(350,1000){
                    override fun onFinish() {
                        s4slimeatk.visibility= View.VISIBLE
                        s4slime.visibility= View.GONE
                        s4watermagic.visibility= View.VISIBLE
                        s4watermagic.startAnimation(s4animationmagicanim)
                    }

                    override fun onTick(millisUntilFinished: Long) {
                    }
                }.start()

                object : CountDownTimer(750,1000){
                    override fun onFinish() {
                        s4hvalue.text = "-"+s4hurtvalue
                        s4slimeatk.visibility= View.GONE
                        s4slime.visibility= View.VISIBLE
                        s4watermagic.clearAnimation()
                        s4watermagic.visibility= View.GONE
                        s4healthpoint = s4healthpoint-s4hurtvalue
                        s4hp.text= s4healthpoint.toString()
                    }

                    override fun onTick(millisUntilFinished: Long) {
                    }
                }.start()
                object : CountDownTimer(1750,1000){
                    override fun onFinish() {
                        s4hvalue.text = ""
                        s4ch1st.visibility=View.VISIBLE
                        s4attack.visibility= View.VISIBLE
                        s4defense.visibility= View.VISIBLE
                        s4ch1def.visibility= View.GONE
                    }

                    override fun onTick(millisUntilFinished: Long) {
                    }
                }.start()
            }
            override fun onTick(millisUntilFinished: Long) {}
        }.start()
        }
    }}