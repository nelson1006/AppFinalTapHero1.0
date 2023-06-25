package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Button
import android.widget.TextView
import android.view.animation.AnimationUtils
import pl.droidsonroids.gif.GifImageView
import kotlin.math.roundToInt

class SlimeTest2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slimetest2)

        //角色
        val s2ch1st= findViewById<GifImageView>(R.id.s2ch1st)
        val s2ch1atk1 = findViewById<ImageView>(R.id.s2ch1atk1)
        val s2ch1atk2 = findViewById<ImageView>(R.id.s2ch1atk2)
        val s2ch1atk3 = findViewById<ImageView>(R.id.s2ch1atk3)
        val s2ch1atk4 = findViewById<ImageView>(R.id.s2ch1atk4)
        val s2ch1atk5 = findViewById<ImageView>(R.id.s2ch1atk5)
        val s2ch1atk6 = findViewById<ImageView>(R.id.s2ch1atk6)
        val s2ch1atk7 = findViewById<ImageView>(R.id.s2ch1atk7)
        val s2ch1atk8 = findViewById<ImageView>(R.id.s2ch1atk8)
        val s2ch1atk9 = findViewById<ImageView>(R.id.s2ch1atk9)
        val s2ch1atk10 = findViewById<ImageView>(R.id.s2ch1atk10)
        val s2ch1atk11 = findViewById<ImageView>(R.id.s2ch1atk11)
        val s2ch1atk12 = findViewById<ImageView>(R.id.s2ch1atk12)
        val s2ch1atk13 = findViewById<ImageView>(R.id.s2ch1atk13)
        val s2ch1atk14 = findViewById<ImageView>(R.id.s2ch1atk14)
        val s2ch1atk15 = findViewById<ImageView>(R.id.s2ch1atk15)
        val s2ch1def = findViewById<GifImageView>(R.id.s2ch1def)
        //史萊姆
        val s2slime= findViewById<GifImageView>(R.id.s2slime)
        val s2slimeatk= findViewById<ImageView>(R.id.s2slimeattack)
        //血量
        val s2hp= findViewById<TextView>(R.id.s2hp)
        val s2mhp= findViewById<TextView>(R.id.s2mhp)
        //特效
        val s2watermagic= findViewById<ImageView>(R.id.s2watermagic1)
        val s2monstereff= findViewById<ImageView>(R.id.s2monstereff)
        val s2mhvalue= findViewById<TextView>(R.id.s2mhurtvalue)
        val s2hvalue= findViewById<TextView>(R.id.s2hurtvalue)
        val s2healvaluetext= findViewById<TextView>(R.id.s2healvalue)
        val s2lightning = findViewById<GifImageView>(R.id.s2lightningeff)
        val s2victory= findViewById<GifImageView>(R.id.s2victory)
        val s2defeat= findViewById<GifImageView>(R.id.s2defeat)
        //按鈕
        val s2attack= findViewById<Button>(R.id.s2attack)
        val s2defense= findViewById<Button>(R.id.s2defense)
        //變數
        val s2id = intent.getIntExtra("id",0)
        var s2attackpoint = intent.getIntExtra("atk",0)
        var s2defensepoint = intent.getIntExtra("def",0)
        var s2healthpoint = intent.getIntExtra("hp",0)
        var s2mlv = intent.getIntExtra("mlv",0)
        var s2itemid = intent.getIntExtra("itemID",0)
        var s2mattackpoint = s2mlv*2+10
        var s2mdefensepoint = s2mlv*2+3
        var s2mhealthpoint = s2mlv*5+35
        //跳轉
        val s2gameset = Intent(this,Addpoint::class.java)
        val s2gameover = Intent(this,CharChoose::class.java)

        if(s2itemid==1){
            s2attackpoint=s2attackpoint+3
            s2mdefensepoint=s2mdefensepoint-3 }
        else if(s2itemid==2){s2attackpoint=s2attackpoint+3 }
        else if(s2itemid==3){s2attackpoint=s2attackpoint+2 }
        else if(s2itemid==4){s2healthpoint=s2healthpoint+10
                            s2mattackpoint=s2mattackpoint-5}
        else if(s2itemid==5){s2healthpoint=s2healthpoint+10}
        else if(s2itemid==6){s2healthpoint=s2healthpoint+10}

        s2hp.text= s2healthpoint.toString()
        s2mhp.text= s2mhealthpoint.toString()

        s2attack.setOnClickListener {
            s2attack.visibility= View.GONE
            s2defense.visibility= View.GONE
            s2ch1st.visibility= View.GONE
            s2ch1atk1.visibility=View.VISIBLE
            val s2animationmagicanim = AnimationUtils.loadAnimation(this,R.anim.magic_anim)
            val s2animationbigger = AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            var s2mhurtvalue = s2attackpoint-s2mdefensepoint
            var s2hurtvalue = s2mattackpoint
            if(s2mhurtvalue<=0){s2mhurtvalue=0}
            if(s2hurtvalue<=0){s2hurtvalue=0}

            if(s2itemid==3){s2mhurtvalue=s2mhurtvalue+(0.1*s2mhealthpoint).roundToInt()}
            if(s2itemid==6){s2healvaluetext.text="+"+10
                s2healthpoint=s2healthpoint+10
                if(s2healthpoint >= intent.getIntExtra("hp",0)+10){s2healthpoint = intent.getIntExtra("hp",0)+10}
                s2hp.text=s2healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { s2healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}
            object : CountDownTimer(100,1000){
                override fun onFinish() {
                    s2ch1atk1.visibility=View.GONE
                    s2ch1atk2.visibility=View.VISIBLE
                    object : CountDownTimer(100,1000){
                        override fun onFinish() {
                            s2ch1atk2.visibility=View.GONE
                            s2ch1atk3.visibility=View.VISIBLE
                            object : CountDownTimer(100,1000){
                                override fun onFinish() {
                                    s2ch1atk3.visibility=View.GONE
                                    s2ch1atk4.visibility=View.VISIBLE
                                    object : CountDownTimer(100,1000){
                                        override fun onFinish() {
                                            s2ch1atk4.visibility=View.GONE
                                            s2ch1atk5.visibility=View.VISIBLE
                                            object : CountDownTimer(100,1000){
                                                override fun onFinish() {
                                                    s2ch1atk5.visibility=View.GONE
                                                    s2ch1atk6.visibility=View.VISIBLE
                                                    object : CountDownTimer(100,1000){
                                                        override fun onFinish() {
                                                            s2ch1atk6.visibility=View.GONE
                                                            s2ch1atk7.visibility=View.VISIBLE
                                                            object : CountDownTimer(100,1000){
                                                                override fun onFinish() {
                                                                    s2ch1atk7.visibility=View.GONE
                                                                    s2ch1atk8.visibility=View.VISIBLE
                                                                    s2lightning.visibility=View.VISIBLE
                                                                    //傷害
                                                                    s2mhvalue.text = "-"+s2mhurtvalue
                                                                    if(s2itemid==2){
                                                                        var s2healvalue=(0.2*s2mhurtvalue).roundToInt()
                                                                        s2healvaluetext.text="+"+s2healvalue
                                                                        s2healthpoint=s2healthpoint+s2healvalue
                                                                        s2hp.text=s2healthpoint.toString()
                                                                    object:CountDownTimer(500,1000){
                                                                        override fun onFinish() {
                                                                            s2healvaluetext.text=""
                                                                        }
                                                                        override fun onTick(millisUntilFinished: Long) {}
                                                                    }.start()}
                                                                    object : CountDownTimer(100,1000){
                                                                        override fun onFinish() {
                                                                            s2ch1atk8.visibility=View.GONE
                                                                            s2ch1atk9.visibility=View.VISIBLE
                                                                            object : CountDownTimer(100,1000){
                                                                                override fun onFinish() {
                                                                                    s2ch1atk9.visibility=View.GONE
                                                                                    s2ch1atk10.visibility=View.VISIBLE
                                                                                    object : CountDownTimer(100,1000){
                                                                                        override fun onFinish() {
                                                                                            s2ch1atk10.visibility=View.GONE
                                                                                            s2ch1atk11.visibility=View.VISIBLE
                                                                                            object : CountDownTimer(100,1000){
                                                                                                override fun onFinish() {
                                                                                                    s2ch1atk11.visibility=View.GONE
                                                                                                    s2ch1atk12.visibility=View.VISIBLE
                                                                                                    object : CountDownTimer(100,1000){
                                                                                                        override fun onFinish() {
                                                                                                            s2ch1atk12.visibility=View.GONE
                                                                                                            s2ch1atk13.visibility=View.VISIBLE
                                                                                                            object : CountDownTimer(100,1000){
                                                                                                                override fun onFinish() {
                                                                                                                    s2ch1atk13.visibility=View.GONE
                                                                                                                    s2ch1atk14.visibility=View.VISIBLE
                                                                                                                    object : CountDownTimer(100,1000){
                                                                                                                        override fun onFinish() {
                                                                                                                            s2ch1atk14.visibility=View.GONE
                                                                                                                            s2ch1atk15.visibility=View.VISIBLE
                                                                                                                            object : CountDownTimer(100,1000){
                                                                                                                                override fun onFinish() {
                                                                                                                                    s2mhvalue.text = ""
                                                                                                                                    s2lightning.visibility=View.INVISIBLE
                                                                                                                                    s2ch1atk15.visibility=View.GONE
                                                                                                                                    s2ch1st.visibility= View.VISIBLE
                                                                                                                                    s2mhealthpoint = s2mhealthpoint-s2mhurtvalue
                                                                                                                                    s2mhp.text= s2mhealthpoint.toString()
                                                                                                                                    if (s2mhealthpoint <= 0){
                                                                                                                                        var lightdata = Bundle()
                                                                                                                                        lightdata.putInt("atk",intent.getIntExtra("atk",0))
                                                                                                                                        lightdata.putInt("def",intent.getIntExtra("def",0))
                                                                                                                                        lightdata.putInt("hp",intent.getIntExtra("hp",0))
                                                                                                                                        lightdata.putInt("mlv",s2mlv+1)
                                                                                                                                        lightdata.putInt("id",s2id)
                                                                                                                                        lightdata.putInt("test",2)
                                                                                                                                        lightdata.putInt("itemID",intent.getIntExtra("itemID",0))
                                                                                                                                        s2gameset.putExtras(lightdata)
                                                                                                                                        s2victory.visibility=View.VISIBLE
                                                                                                                                        object : CountDownTimer(500,1000)
                                                                                                                                        { override fun onFinish() { startActivity(s2gameset) }
                                                                                                                                            override fun onTick(millisUntilFinished: Long) {} }.start() }
                                                                                                                                    else{
                                                                                                                                        object : CountDownTimer(350,1000){
                                                                                                                                        override fun onFinish() {
                                                                                                                                            s2slimeatk.visibility= View.VISIBLE
                                                                                                                                            s2slime.visibility= View.GONE
                                                                                                                                            s2watermagic.visibility= View.VISIBLE
                                                                                                                                            s2watermagic.startAnimation(s2animationmagicanim)
                                                                                                                                        }

                                                                                                                                        override fun onTick(millisUntilFinished: Long) {
                                                                                                                                        }
                                                                                                                                    }.start()

                                                                                                                                        object : CountDownTimer(750,1000){
                                                                                                                                            override fun onFinish() {
                                                                                                                                                s2hvalue.text="-"+s2hurtvalue
                                                                                                                                                if(s2itemid==5){s2mhvalue.text="-"+5
                                                                                                                                                    s2mhealthpoint=s2mhealthpoint-5
                                                                                                                                                    s2mhp.text=s2mhealthpoint.toString()
                                                                                                                                                    object:CountDownTimer(500,1000){
                                                                                                                                                        override fun onFinish() { s2mhvalue.text="" }
                                                                                                                                                        override fun onTick(millisUntilFinished: Long) {}
                                                                                                                                                    }.start()}
                                                                                                                                                if (s2mhealthpoint <= 0){
                                                                                                                                                    var lightdata = Bundle()
                                                                                                                                                    lightdata.putInt("atk",intent.getIntExtra("atk",0))
                                                                                                                                                    lightdata.putInt("def",intent.getIntExtra("def",0))
                                                                                                                                                    lightdata.putInt("hp",intent.getIntExtra("hp",0))
                                                                                                                                                    lightdata.putInt("mlv",s2mlv+1)
                                                                                                                                                    lightdata.putInt("id",s2id)
                                                                                                                                                    lightdata.putInt("test",2)
                                                                                                                                                    lightdata.putInt("itemID",intent.getIntExtra("itemID",0))
                                                                                                                                                    s2gameset.putExtras(lightdata)
                                                                                                                                                    s2victory.visibility=View.VISIBLE
                                                                                                                                                    object : CountDownTimer(500,1000)
                                                                                                                                                    { override fun onFinish() { startActivity(s2gameset) }
                                                                                                                                                        override fun onTick(millisUntilFinished: Long) {} }.start() }
                                                                                                                                                s2healthpoint = s2healthpoint-s2hurtvalue
                                                                                                                                                s2hp.text= s2healthpoint.toString()
                                                                                                                                                s2slimeatk.visibility= View.GONE
                                                                                                                                                s2slime.visibility= View.VISIBLE
                                                                                                                                                s2monstereff.visibility= View.VISIBLE
                                                                                                                                                s2monstereff.startAnimation(s2animationbigger)
                                                                                                                                            }

                                                                                                                                            override fun onTick(millisUntilFinished: Long) {
                                                                                                                                            }
                                                                                                                                        }.start()
                                                                                                                                        object : CountDownTimer(1750,1000){
                                                                                                                                            override fun onFinish() {
                                                                                                                                                if(s2healthpoint<=0){
                                                                                                                                                    s2defeat.visibility=View.VISIBLE
                                                                                                                                                    object :CountDownTimer(1000,1000){
                                                                                                                                                        override fun onFinish() {
                                                                                                                                                            startActivity(s2gameover)
                                                                                                                                                        }
                                                                                                                                                        override fun onTick(millisUntilFinished: Long) {}
                                                                                                                                                    }.start()
                                                                                                                                                }
                                                                                                                                                else{s2monstereff.clearAnimation()
                                                                                                                                                    s2watermagic.clearAnimation()
                                                                                                                                                    s2monstereff.visibility= View.GONE
                                                                                                                                                    s2watermagic.visibility= View.GONE
                                                                                                                                                    s2ch1st.visibility=View.VISIBLE
                                                                                                                                                    s2attack.visibility= View.VISIBLE
                                                                                                                                                    s2defense.visibility= View.VISIBLE
                                                                                                                                                    s2hvalue.text=""}
                                                                                                                                            }

                                                                                                                                            override fun onTick(millisUntilFinished: Long) {
                                                                                                                                            }
                                                                                                                                        }.start()}
                                                                                                                                }
                                                                                                                                override fun onTick(millisUntilFinished: Long) {}
                                                                                                                            }.start()
                                                                                                                        }
                                                                                                                        override fun onTick(millisUntilFinished: Long) {}
                                                                                                                    }.start()
                                                                                                                }
                                                                                                                override fun onTick(millisUntilFinished: Long) {}
                                                                                                            }.start()
                                                                                                        }
                                                                                                        override fun onTick(millisUntilFinished: Long) {}
                                                                                                    }.start()
                                                                                                }
                                                                                                override fun onTick(millisUntilFinished: Long) {}
                                                                                            }.start()
                                                                                        }
                                                                                        override fun onTick(millisUntilFinished: Long) {}
                                                                                    }.start()
                                                                                }
                                                                                override fun onTick(millisUntilFinished: Long) {}
                                                                            }.start()
                                                                        }
                                                                        override fun onTick(millisUntilFinished: Long) {}
                                                                    }.start()
                                                                }
                                                                override fun onTick(millisUntilFinished: Long) {}
                                                            }.start()
                                                        }
                                                        override fun onTick(millisUntilFinished: Long) {}
                                                    }.start()
                                                }
                                                override fun onTick(millisUntilFinished: Long) {}
                                            }.start()
                                        }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()
                        }
                        override fun onTick(millisUntilFinished: Long) {}
                    }.start()
                }
                override fun onTick(millisUntilFinished: Long) {}
            }.start()
        }

        s2defense.setOnClickListener {

            var lightdata = Bundle()
            lightdata.putInt("atk",intent.getIntExtra("atk",0))
            lightdata.putInt("def",intent.getIntExtra("def",0))
            lightdata.putInt("hp",intent.getIntExtra("hp",0))
            lightdata.putInt("mlv",s2mlv+1)
            lightdata.putInt("id",s2id)
            lightdata.putInt("test",2)
            lightdata.putInt("itemID",intent.getIntExtra("itemID",0))
            s2gameset.putExtras(lightdata)

            if(s2itemid==6){s2healvaluetext.text="+"+10
                s2healthpoint=s2healthpoint+10
                if(s2healthpoint >= intent.getIntExtra("hp",0)+10){s2healthpoint = intent.getIntExtra("hp",0)+10}
                s2hp.text=s2healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { s2healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}

            s2attack.visibility= View.GONE
            s2defense.visibility= View.GONE
            s2ch1def.visibility=View.VISIBLE
            var s2hurtvalue = s2mattackpoint-s2defensepoint
            if (s2hurtvalue<=0){s2hurtvalue=0}
            val s2animationmagicanim = AnimationUtils.loadAnimation(this,R.anim.magic_anim)

            object : CountDownTimer(350,1000){
                override fun onFinish() {
                    s2slimeatk.visibility= View.VISIBLE
                    s2slime.visibility= View.GONE
                    s2watermagic.visibility= View.VISIBLE
                    s2watermagic.startAnimation(s2animationmagicanim)
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()

            object : CountDownTimer(750,1000){
                override fun onFinish() {
                    s2hvalue.text="-"+s2hurtvalue
                    s2healthpoint = s2healthpoint-s2hurtvalue

                    if(s2itemid==5){s2mhvalue.text="-"+5
                        s2mhealthpoint=s2mhealthpoint-5
                        s2mhp.text=s2mhealthpoint.toString()
                        object:CountDownTimer(500,1000){
                            override fun onFinish() { s2mhvalue.text="" }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                        if (s2mhealthpoint <= 0){
                            var lightdata = Bundle()
                            lightdata.putInt("atk",intent.getIntExtra("atk",0))
                            lightdata.putInt("def",intent.getIntExtra("def",0))
                            lightdata.putInt("hp",intent.getIntExtra("hp",0))
                            lightdata.putInt("mlv",s2mlv+1)
                            lightdata.putInt("id",s2id)
                            lightdata.putInt("test",2)
                            lightdata.putInt("itemID",intent.getIntExtra("itemID",0))
                            s2gameset.putExtras(lightdata)
                            s2victory.visibility=View.VISIBLE
                            object : CountDownTimer(500,1000)
                            { override fun onFinish() { startActivity(s2gameset) }
                                override fun onTick(millisUntilFinished: Long) {} }.start() }
                    }

                    s2hp.text= s2healthpoint.toString()
                    s2slimeatk.visibility= View.GONE
                    s2slime.visibility= View.VISIBLE
                    s2watermagic.clearAnimation()
                    s2watermagic.visibility= View.GONE
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()
            object : CountDownTimer(1750,1000){
                override fun onFinish() {
                    if(s2healthpoint<=0){
                        s2defeat.visibility=View.VISIBLE
                        object :CountDownTimer(1000,1000){
                            override fun onFinish() {
                                startActivity(s2gameover)
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                    }
                    else{
                        s2attack.visibility= View.VISIBLE
                        s2defense.visibility= View.VISIBLE
                        s2hvalue.text=""}
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()
            object :CountDownTimer(2000,1000){
                override fun onFinish() {
                    s2ch1def.visibility=View.GONE}
                override fun onTick(millisUntilFinished: Long) {}
            }.start()
        }




    }}








