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
import kotlin.math.roundToInt

class MagicaTest2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magica_test2)

        //角色
        val m2ch1st= findViewById<GifImageView>(R.id.m2ch1st)
        val m2ch1atk1 = findViewById<ImageView>(R.id.m2ch1atk1)
        val m2ch1atk2 = findViewById<ImageView>(R.id.m2ch1atk2)
        val m2ch1atk3 = findViewById<ImageView>(R.id.m2ch1atk3)
        val m2ch1atk4 = findViewById<ImageView>(R.id.m2ch1atk4)
        val m2ch1atk5 = findViewById<ImageView>(R.id.m2ch1atk5)
        val m2ch1atk6 = findViewById<ImageView>(R.id.m2ch1atk6)
        val m2ch1atk7 = findViewById<ImageView>(R.id.m2ch1atk7)
        val m2ch1atk8 = findViewById<ImageView>(R.id.m2ch1atk8)
        val m2ch1atk9 = findViewById<ImageView>(R.id.m2ch1atk9)
        val m2ch1atk10 = findViewById<ImageView>(R.id.m2ch1atk10)
        val m2ch1atk11 = findViewById<ImageView>(R.id.m2ch1atk11)
        val m2ch1atk12 = findViewById<ImageView>(R.id.m2ch1atk12)
        val m2ch1atk13 = findViewById<ImageView>(R.id.m2ch1atk13)
        val m2ch1atk14 = findViewById<ImageView>(R.id.m2ch1atk14)
        val m2ch1atk15 = findViewById<ImageView>(R.id.m2ch1atk15)
        val m2ch1def = findViewById<GifImageView>(R.id.m2ch1def)
        //Magica
        val m2magicast= findViewById<GifImageView>(R.id.m2magicast)
        val m2magicaatk= findViewById<GifImageView>(R.id.m2magicaatk)
        val m2magicadef= findViewById<GifImageView>(R.id.m2magicadef)
        //血量
        val m2hp= findViewById<TextView>(R.id.m2hp)
        val m2mhp= findViewById<TextView>(R.id.m2mhp)
        //特效
        val m2ultlazer= findViewById<ImageView>(R.id.m2ultlazer)
        val m2freezelazer= findViewById<ImageView>(R.id.m2freezelazer)
        val m2shield= findViewById<ImageView>(R.id.m2shield)
        val m2mhvalue= findViewById<TextView>(R.id.m2mhurtvalue)
        val m2hvalue= findViewById<TextView>(R.id.m2hurtvalue)
        val m2healvaluetext = findViewById<TextView>(R.id.m2healvalue)
        val m2lightning = findViewById<GifImageView>(R.id.m2lightningeff)
        val m2victory = findViewById<GifImageView>(R.id.m2victory)
        val m2defeat = findViewById<GifImageView>(R.id.m2defeat)
        //按鈕
        val m2attack= findViewById<Button>(R.id.m2attack)
        val m2defense= findViewById<Button>(R.id.m2defense)
        //跳轉
        val m2gameset = Intent(this,Addpoint::class.java)
        val m2gameover = Intent(this,CharChoose::class.java)
        //變數
        val m2id = intent.getIntExtra("id",0)
        var m2attackpoint = intent.getIntExtra("atk",0)
        var m2defensepoint = intent.getIntExtra("def",0)
        var m2healthpoint = intent.getIntExtra("hp",0)
        var m2mlv = intent.getIntExtra("mlv",0)
        var m2itemid = intent.getIntExtra("itemID",0)
        var m2mattackpoint = m2mlv*3+6
        var m2mdefensepoint = m2mlv*3+5
        var m2mhealthpoint = m2mlv*4+100

        if(m2itemid==1){
        m2attackpoint=m2attackpoint+3
        m2mdefensepoint=m2mdefensepoint-3 }
        else if(m2itemid==2){m2attackpoint=m2attackpoint+3 }
        else if(m2itemid==3){m2attackpoint=m2attackpoint+2 }
        else if(m2itemid==4){m2healthpoint=m2healthpoint+10}
        else if(m2itemid==5){m2healthpoint=m2healthpoint+10
                             m2mattackpoint=m2mattackpoint-5}
        else if(m2itemid==6){m2healthpoint=m2healthpoint+10}

        m2hp.text= m2healthpoint.toString()
        m2mhp.text= m2mhealthpoint.toString()

        m2attack.setOnClickListener {
            m2attack.visibility= View.GONE
            m2defense.visibility= View.GONE
            m2ch1st.visibility= View.GONE
            m2ch1atk1.visibility= View.VISIBLE

            if(m2itemid==6){m2healvaluetext.text="+"+10
                m2healthpoint=m2healthpoint+10
                if(m2healthpoint >= intent.getIntExtra("hp",0)+10){m2healthpoint = intent.getIntExtra("hp",0)+10}
                m2hp.text=m2healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { m2healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}

            var lightdata = Bundle()
            lightdata.putInt("atk",intent.getIntExtra("atk",0))
            lightdata.putInt("def",intent.getIntExtra("def",0))
            lightdata.putInt("hp",intent.getIntExtra("hp",0))
            lightdata.putInt("mlv",m2mlv+1)
            lightdata.putInt("id",m2id)
            lightdata.putInt("test",1)
            lightdata.putInt("itemID",m2itemid)
            m2gameset.putExtras(lightdata)

            object : CountDownTimer(100,1000){
                override fun onFinish() {
                    m2ch1atk1.visibility= View.GONE
                    m2ch1atk2.visibility= View.VISIBLE
                    object : CountDownTimer(100,1000){
                        override fun onFinish() {
                            m2ch1atk2.visibility= View.GONE
                            m2ch1atk3.visibility= View.VISIBLE
                            object : CountDownTimer(100,1000){
                                override fun onFinish() {
                                    m2ch1atk3.visibility= View.GONE
                                    m2ch1atk4.visibility= View.VISIBLE
                                    object : CountDownTimer(100,1000){
                                        override fun onFinish() {
                                            m2ch1atk4.visibility= View.GONE
                                            m2ch1atk5.visibility= View.VISIBLE
                                            object : CountDownTimer(100,1000){
                                                override fun onFinish() {
                                                    m2ch1atk5.visibility= View.GONE
                                                    m2ch1atk6.visibility= View.VISIBLE
                                                    object : CountDownTimer(100,1000){
                                                        override fun onFinish() {
                                                            m2ch1atk6.visibility= View.GONE
                                                            m2ch1atk7.visibility= View.VISIBLE
                                                            object : CountDownTimer(100,1000){
                                                                override fun onFinish() {
                                                                    m2ch1atk7.visibility= View.GONE
                                                                    m2ch1atk8.visibility= View.VISIBLE
                                                                    m2lightning.visibility= View.VISIBLE
                                                                    object : CountDownTimer(100,1000){
                                                                        override fun onFinish() {
                                                                            m2ch1atk8.visibility= View.GONE
                                                                            m2ch1atk9.visibility= View.VISIBLE
                                                                            object : CountDownTimer(100,1000){
                                                                                override fun onFinish() {
                                                                                    m2ch1atk9.visibility= View.GONE
                                                                                    m2ch1atk10.visibility= View.VISIBLE
                                                                                    object : CountDownTimer(100,1000){
                                                                                        override fun onFinish() {
                                                                                            m2ch1atk10.visibility= View.GONE
                                                                                            m2ch1atk11.visibility= View.VISIBLE
                                                                                            object : CountDownTimer(100,1000){
                                                                                                override fun onFinish() {
                                                                                                    m2ch1atk11.visibility= View.GONE
                                                                                                    m2ch1atk12.visibility= View.VISIBLE
                                                                                                    object : CountDownTimer(100,1000){
                                                                                                        override fun onFinish() {
                                                                                                            m2ch1atk12.visibility= View.GONE
                                                                                                            m2ch1atk13.visibility= View.VISIBLE
                                                                                                            object : CountDownTimer(100,1000){
                                                                                                                override fun onFinish() {
                                                                                                                    m2ch1atk13.visibility= View.GONE
                                                                                                                    m2ch1atk14.visibility= View.VISIBLE
                                                                                                                    object : CountDownTimer(100,1000){
                                                                                                                        override fun onFinish() {
                                                                                                                            m2ch1atk14.visibility= View.GONE
                                                                                                                            m2ch1atk15.visibility= View.VISIBLE
                                                                                                                            object : CountDownTimer(100,1000){
                                                                                                                                override fun onFinish() {
                                                                                                                                    m2lightning.visibility=View.INVISIBLE
                                                                                                                                    m2ch1atk15.visibility=View.GONE
                                                                                                                                    m2ch1st.visibility= View.VISIBLE
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

            var coin= (0..4).random()

            if(coin <= 1){
                var m2mhurtvalue = m2attackpoint
                var m2hurtvalue = m2mattackpoint
                m2mhealthpoint = m2mhealthpoint-m2mhurtvalue

                if(m2itemid==3){m2mhurtvalue=m2mhurtvalue+(0.1*m2mhealthpoint).roundToInt()}

                object:CountDownTimer(700,1000){
                    override fun onFinish() {
                        m2mhvalue.text = "-"+m2mhurtvalue
                        if(m2itemid==2){
                            var m2healvalue=(0.2*m2mhurtvalue).roundToInt()
                            m2healvaluetext.text="+"+m2healvalue
                            m2healthpoint=m2healthpoint+m2healvalue
                            m2hp.text=m2healthpoint.toString()
                            object :CountDownTimer (500,1000){
                                override fun onFinish() {
                                    m2healvaluetext.text=""
                                }
                                override fun onTick(millisUntilFinished: Long) {
                                }
                            }.start()}
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()

                if(m2mhealthpoint<=0){
                    object:CountDownTimer(700,1000){
                        override fun onFinish() {m2victory.visibility=View.VISIBLE}
                        override fun onTick(millisUntilFinished: Long) {}
                    }.start()
                    m2mhp.text=m2mhealthpoint.toString()
                    object:CountDownTimer(1500,1000){
                    override fun onFinish() {
                        object : CountDownTimer(500,1000)
                        { override fun onFinish() { startActivity(m2gameset) }
                            override fun onTick(millisUntilFinished: Long) {} }.start() }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}
                else{object : CountDownTimer(1500,1000){
                    override fun onFinish() {
                        m2mhp.text=m2mhealthpoint.toString()
                        m2mhvalue.text=""
                        m2magicast.visibility= View.GONE
                        m2magicaatk.visibility= View.VISIBLE
                        object : CountDownTimer(150,1000){
                            override fun onFinish() {
                                m2freezelazer.visibility= View.VISIBLE
                                m2hvalue.text= "-"+m2hurtvalue
                                m2healthpoint = m2healthpoint-m2hurtvalue
                                if(m2itemid==5){m2mhvalue.text="-"+5
                                    m2mhealthpoint=m2mhealthpoint-5
                                    m2mhp.text=m2mhealthpoint.toString()
                                    object:CountDownTimer(500,1000){
                                        override fun onFinish() { m2mhvalue.text="" }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                    if (m2mhealthpoint <= 0){
                                        var lightdata = Bundle()
                                        lightdata.putInt("atk",intent.getIntExtra("atk",0))
                                        lightdata.putInt("def",intent.getIntExtra("def",0))
                                        lightdata.putInt("hp",intent.getIntExtra("hp",0))
                                        lightdata.putInt("mlv",m2mlv+1)
                                        lightdata.putInt("id",m2id)
                                        lightdata.putInt("test",2)
                                        lightdata.putInt("itemID",intent.getIntExtra("itemID",0))
                                        m2gameset.putExtras(lightdata)
                                        m2victory.visibility=View.VISIBLE
                                        object : CountDownTimer(500,1000)
                                        { override fun onFinish() { startActivity(m2gameset) }
                                            override fun onTick(millisUntilFinished: Long) {} }.start() }
                                }
                                if(m2healthpoint<=0){ m2defeat.visibility=View.VISIBLE
                                    object :CountDownTimer(1000,1000){
                                        override fun onFinish() {
                                            startActivity(m2gameover)
                                        }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                }
                                else {
                                    object : CountDownTimer(1150,1000){
                                    override fun onFinish() {
                                        m2hp.text=m2healthpoint.toString()
                                        m2freezelazer.visibility= View.GONE
                                        m2magicast.visibility= View.VISIBLE
                                        m2magicaatk.visibility= View.GONE
                                        m2attack.visibility= View.VISIBLE
                                        m2defense.visibility= View.VISIBLE
                                        m2hvalue.text= ""
                                        m2attack.visibility=View.VISIBLE
                                        m2defense.visibility=View.VISIBLE
                                    }
                                    override fun onTick(millisUntilFinished: Long) {}
                                }.start()}
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}
                 }
        else if (coin <= 3){
            var m2mhurtvalue = m2attackpoint-m2mdefensepoint
            if(m2mhurtvalue<=0){m2mhurtvalue=0}
            m2mhealthpoint= m2mhealthpoint-m2mhurtvalue
            if(m2itemid==3){m2mhurtvalue=m2mhurtvalue+(0.1*m2mhealthpoint).roundToInt()}



            if(m2mhealthpoint<=0){
                m2magicast.visibility= View.GONE
                m2magicadef.visibility= View.VISIBLE
                m2shield.visibility=View.VISIBLE
                object:CountDownTimer(700,1000){
                    override fun onFinish() {m2victory.visibility=View.VISIBLE}
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
                object:CountDownTimer(700,1000){
                    override fun onFinish() {m2mhvalue.text="-"+m2mhurtvalue}
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
                m2mhp.text=m2mhealthpoint.toString()
                object:CountDownTimer(1500,1000){
                    override fun onFinish() {
                        m2mhvalue.text=""
                        object : CountDownTimer(500,1000)
                        { override fun onFinish() { startActivity(m2gameset) }
                            override fun onTick(millisUntilFinished: Long) {} }.start()
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
            }
                else{
                m2magicast.visibility= View.GONE
                m2magicadef.visibility= View.VISIBLE
                m2shield.visibility=View.VISIBLE

                object:CountDownTimer(700,1000){
                    override fun onFinish() {m2mhvalue.text="-"+m2mhurtvalue
                        if(m2itemid==2){
                            var m2healvalue=(0.2*m2mhurtvalue).roundToInt()
                            m2healvaluetext.text="+"+m2healvalue
                            m2healthpoint=m2healthpoint+m2healvalue
                            m2hp.text=m2healthpoint.toString()
                            object :CountDownTimer (500,1000){
                                override fun onFinish() { m2healvaluetext.text="" }
                                override fun onTick(millisUntilFinished: Long) {
                                }
                            }.start()}}
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
                object : CountDownTimer(1800,1000) {
                    override fun onFinish() {
                        m2attack.visibility= View.VISIBLE
                        m2defense.visibility= View.VISIBLE
                        m2magicast.visibility= View.VISIBLE
                        m2magicadef.visibility = View.GONE
                        m2shield.visibility = View.GONE
                        m2mhvalue.text=""
                        m2mhp.text=m2mhealthpoint.toString()
                        m2attack.visibility=View.VISIBLE
                        m2defense.visibility=View.VISIBLE }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}
        }
        else {
                var m2mhurtvalue = m2attackpoint
                var m2hurtvalue = m2mattackpoint+5
                m2mhealthpoint = m2mhealthpoint-m2mhurtvalue
                m2healthpoint = m2healthpoint-m2hurtvalue
                if(m2itemid==3){m2mhurtvalue=m2mhurtvalue+(0.1*m2mhealthpoint).roundToInt()}

                object:CountDownTimer(700,1000){
                    override fun onFinish() {m2mhvalue.text="-"+m2mhurtvalue
                        if(m2itemid==2){
                            var m2healvalue=(0.2*m2mhurtvalue).roundToInt()
                            m2healvaluetext.text="+"+m2healvalue
                            m2healthpoint=m2healthpoint+m2healvalue
                            m2hp.text=m2healthpoint.toString()
                            object :CountDownTimer (500,1000){
                                override fun onFinish() {
                                    m2healvaluetext.text=""
                                }
                                override fun onTick(millisUntilFinished: Long) {
                                }
                            }.start()}}
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
                if (m2mhealthpoint<=0){
                    object:CountDownTimer(700,1000){
                        override fun onFinish() {m2victory.visibility=View.VISIBLE}
                        override fun onTick(millisUntilFinished: Long) {}
                    }.start()
                    m2mhp.text=m2mhealthpoint.toString()
                    object:CountDownTimer(1500,1000){
                        override fun onFinish() {
                            m2mhvalue.text=""
                            object : CountDownTimer(500,1000)
                            { override fun onFinish() { startActivity(m2gameset) }
                                override fun onTick(millisUntilFinished: Long) {} }.start()
                        }
                        override fun onTick(millisUntilFinished: Long) {}
                    }.start()}
                else{
                    object : CountDownTimer(1500,1000) {
                    override fun onFinish() {
                        m2mhp.text=m2mhealthpoint.toString()
                        m2mhvalue.text=""
                        m2magicast.visibility= View.GONE
                        m2magicaatk.visibility= View.VISIBLE
                        object : CountDownTimer(150,1000){
                            override fun onFinish() {
                                m2ultlazer.visibility= View.VISIBLE
                                m2hvalue.text="-"+m2hurtvalue
                                if(m2itemid==5){m2mhvalue.text="-"+5
                                    m2mhealthpoint=m2mhealthpoint-5
                                    m2mhp.text=m2mhealthpoint.toString()
                                    object:CountDownTimer(500,1000){
                                        override fun onFinish() { m2mhvalue.text="" }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                    if (m2mhealthpoint <= 0){
                                        var lightdata = Bundle()
                                        lightdata.putInt("atk",intent.getIntExtra("atk",0))
                                        lightdata.putInt("def",intent.getIntExtra("def",0))
                                        lightdata.putInt("hp",intent.getIntExtra("hp",0))
                                        lightdata.putInt("mlv",m2mlv+1)
                                        lightdata.putInt("id",m2id)
                                        lightdata.putInt("test",2)
                                        lightdata.putInt("itemID",intent.getIntExtra("itemID",0))
                                        m2gameset.putExtras(lightdata)
                                        m2victory.visibility=View.VISIBLE
                                        object : CountDownTimer(500,1000)
                                        { override fun onFinish() { startActivity(m2gameset) }
                                            override fun onTick(millisUntilFinished: Long) {} }.start() }
                                }
                                if(m2healthpoint<=0){
                                    m2defeat.visibility=View.VISIBLE
                                    object:CountDownTimer(1000,1000){
                                        override fun onFinish() { startActivity(m2gameover) }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                }
                                else{object : CountDownTimer(1150,1000){
                                    override fun onFinish() {
                                        m2attack.visibility= View.VISIBLE
                                        m2defense.visibility= View.VISIBLE
                                        m2ultlazer.visibility= View.GONE
                                        m2magicast.visibility= View.VISIBLE
                                        m2magicaatk.visibility= View.GONE
                                        m2hvalue.text=""
                                        m2hp.text=m2healthpoint.toString()
                                        m2attack.visibility=View.VISIBLE
                                        m2defense.visibility=View.VISIBLE
                                    }
                                    override fun onTick(millisUntilFinished: Long) {}
                                }.start()}
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                    }

                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}
            }
        }

        m2defense.setOnClickListener {

            var lightdata = Bundle()
            lightdata.putInt("atk",intent.getIntExtra("atk",0))
            lightdata.putInt("def",intent.getIntExtra("def",0))
            lightdata.putInt("hp",intent.getIntExtra("hp",0))
            lightdata.putInt("mlv",m2mlv+1)
            lightdata.putInt("id",m2id)
            lightdata.putInt("test",1)
            lightdata.putInt("itemID",m2itemid)
            m2gameset.putExtras(lightdata)

            if(m2itemid==6){m2healvaluetext.text="+"+10
                m2healthpoint=m2healthpoint+10
                if(m2healthpoint >= intent.getIntExtra("hp",0)+10){m2healthpoint = intent.getIntExtra("hp",0)+10}
                m2hp.text=m2healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { m2healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}

            m2attack.visibility= View.GONE
            m2defense.visibility= View.GONE
            m2ch1def.visibility=View.VISIBLE
            var m2hurtvalue = m2mattackpoint-m2defensepoint
            if (m2hurtvalue<=0){m2hurtvalue=0}
            m2healthpoint = m2healthpoint-m2hurtvalue
            object : CountDownTimer(150,1000){
                override fun onFinish() {var coin= (0..4).random()
                    if(coin <= 1){
                        m2magicast.visibility= View.GONE
                        m2magicaatk.visibility= View.VISIBLE
                        object : CountDownTimer(150,1000){
                            override fun onFinish() {
                                m2freezelazer.visibility= View.VISIBLE
                                m2hvalue.text="-"+m2hurtvalue
                                if(m2itemid==5){m2mhvalue.text="-"+5
                                    m2mhealthpoint=m2mhealthpoint-5
                                    m2mhp.text=m2mhealthpoint.toString()
                                    object:CountDownTimer(500,1000){
                                        override fun onFinish() { m2mhvalue.text="" }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                    if (m2mhealthpoint <= 0){
                                        var lightdata = Bundle()
                                        lightdata.putInt("atk",intent.getIntExtra("atk",0))
                                        lightdata.putInt("def",intent.getIntExtra("def",0))
                                        lightdata.putInt("hp",intent.getIntExtra("hp",0))
                                        lightdata.putInt("mlv",m2mlv+1)
                                        lightdata.putInt("id",m2id)
                                        lightdata.putInt("test",2)
                                        lightdata.putInt("itemID",intent.getIntExtra("itemID",0))
                                        m2gameset.putExtras(lightdata)
                                        m2victory.visibility=View.VISIBLE
                                        object : CountDownTimer(500,1000)
                                        { override fun onFinish() { startActivity(m2gameset) }
                                            override fun onTick(millisUntilFinished: Long) {} }.start() }
                                }
                                m2hp.text=m2healthpoint.toString()
                                if (m2healthpoint<=0){m2defeat.visibility=View.VISIBLE}
                                else{
                                    object : CountDownTimer(1150,1000){
                                    override fun onFinish() {
                                        m2hvalue.text=""
                                        m2freezelazer.visibility= View.GONE
                                        m2magicast.visibility= View.VISIBLE
                                        m2magicaatk.visibility= View.GONE
                                        m2attack.visibility= View.VISIBLE
                                        m2defense.visibility= View.VISIBLE
                                        m2ch1def.visibility=View.GONE
                                    }
                                    override fun onTick(millisUntilFinished: Long) {}
                                }.start()} }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start() }
                    else if (coin <= 3){
                        m2magicast.visibility= View.GONE
                        m2magicadef.visibility= View.VISIBLE
                        m2shield.visibility=View.VISIBLE
                        object : CountDownTimer(1000,1000) {
                            override fun onFinish() {
                                m2magicast.visibility = View.VISIBLE
                                m2magicadef.visibility = View.GONE
                                m2shield.visibility = View.GONE
                                m2attack.visibility= View.VISIBLE
                                m2defense.visibility= View.VISIBLE
                                m2ch1def.visibility=View.GONE
                            }

                            override fun onTick(millisUntilFinished: Long) {}
                        }.start() }
                    else {
                        m2magicast.visibility= View.GONE
                        m2magicaatk.visibility= View.VISIBLE
                        object : CountDownTimer(150,1000){
                            override fun onFinish() {
                                m2hvalue.text="-"+m2hurtvalue
                                m2hp.text=m2healthpoint.toString()
                                m2ultlazer.visibility= View.VISIBLE
                                if (m2healthpoint<=0){
                                    m2defeat.visibility= View.VISIBLE
                                    object:CountDownTimer(1000,1000){
                                    override fun onFinish() {startActivity(m2gameover)}
                                    override fun onTick(millisUntilFinished: Long) {} } }
                                else{
                                    object : CountDownTimer(1150,1000){
                                    override fun onFinish() {
                                        m2hvalue.text=""
                                        m2ultlazer.visibility= View.GONE
                                        m2magicast.visibility= View.VISIBLE
                                        m2magicaatk.visibility= View.GONE
                                        m2attack.visibility= View.VISIBLE
                                        m2defense.visibility= View.VISIBLE
                                        m2ch1def.visibility=View.GONE
                                    }
                                    override fun onTick(millisUntilFinished: Long) {}
                                }.start()}
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start() }}
                override fun onTick(millisUntilFinished: Long) {} }.start() }
    } }
