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

class MagicaTest5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magica_test5)
        //角色
        val m5ch1st= findViewById<GifImageView>(R.id.m5ch1st)
        val m5ch1atk= findViewById<ImageView>(R.id.m5ch1attack)
        val m5ch1def= findViewById<GifImageView>(R.id.m5ch1defense)
        //特效
        val m5fireeffect= findViewById<GifImageView>(R.id.m5fireeff)
        val m5mhvalue= findViewById<TextView>(R.id.m5mhurtvalue)
        val m5hvalue= findViewById<TextView>(R.id.m5hurtvalue)
        val m5healvaluetext = findViewById<TextView>(R.id.m5healvalue)
        val m5victory = findViewById<GifImageView>(R.id.m5victory)
        val m5defeat = findViewById<GifImageView>(R.id.m5defeat)
        //Magica
        val m5magicast= findViewById<GifImageView>(R.id.m5magicast)
        val m5magicaatk= findViewById<GifImageView>(R.id.m5magicaatk)
        val m5magicadef= findViewById<GifImageView>(R.id.m5magicadef)
        //血量
        val m5hp= findViewById<TextView>(R.id.m5hp)
        val m5mhp= findViewById<TextView>(R.id.m5mhp)
        //特效
        val m5ultlazer= findViewById<ImageView>(R.id.m5ultlazer)
        val m5freezelazer= findViewById<ImageView>(R.id.m5freezelazer)
        val m5shield= findViewById<ImageView>(R.id.m5shield)
        //按鈕
        val m5attack= findViewById<Button>(R.id.m5attack)
        val m5defense= findViewById<Button>(R.id.m5defense)
        //變數
        var m5attackpoint = intent.getIntExtra("atk",0)
        var m5defensepoint = intent.getIntExtra("def",0)
        var m5healthpoint = intent.getIntExtra("hp",0)
        var m5mlv = intent.getIntExtra("mlv",0)
        var m5itemid = intent.getIntExtra("itemID",0)
        var m5mattackpoint = m5mlv*3+6
        var m5mdefensepoint = m5mlv*3+5
        var m5mhealthpoint = m5mlv*4+100
        //跳轉
        val m5gameset = Intent(this,Addpoint::class.java)
        val m5gameover = Intent(this,CharChoose::class.java)

        if(m5itemid==1){
            m5attackpoint=m5attackpoint+3
            m5mdefensepoint=m5mdefensepoint-3 }
        else if(m5itemid==2){m5attackpoint=m5attackpoint+3 }
        else if(m5itemid==3){m5attackpoint=m5attackpoint+2 }
        else if(m5itemid==4){m5healthpoint=m5healthpoint+10}
        else if(m5itemid==5){m5healthpoint=m5healthpoint+10
            m5mattackpoint=m5mattackpoint-5}
        else if(m5itemid==6){m5healthpoint=m5healthpoint+10}

        m5hp.text= m5healthpoint.toString()
        m5mhp.text= m5mhealthpoint.toString()

        m5attack.setOnClickListener {
            var firedata = Bundle()
            firedata.putInt("atk",intent.getIntExtra("atk",0))
            firedata.putInt("def",intent.getIntExtra("def",0))
            firedata.putInt("hp",intent.getIntExtra("hp",0))
            firedata.putInt("mlv",m5mlv+1)
            firedata.putInt("id",5)
            firedata.putInt("test",1)
            firedata.putInt("itemID",m5itemid)
            m5gameset.putExtras(firedata)

            if(m5itemid==6){m5healvaluetext.text="+"+10
                m5healthpoint=m5healthpoint+10
                if(m5healthpoint >= intent.getIntExtra("hp",0)+10){m5healthpoint = intent.getIntExtra("hp",0)+10}
                m5hp.text=m5healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { m5healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}


            m5attack.visibility= View.GONE
            m5defense.visibility= View.GONE
            m5ch1st.visibility= View.INVISIBLE
            m5ch1atk.visibility= View.VISIBLE
            m5fireeffect.visibility= View.VISIBLE

            var coin= (0..4).random()
            if(coin <= 1){
                var m5hurtvalue= m5mattackpoint
                m5healthpoint=m5healthpoint-m5hurtvalue
                var m5mhurtvalue=m5attackpoint
                m5mhealthpoint=m5mhealthpoint-m5mhurtvalue
                if(m5itemid==3){m5mhurtvalue=m5mhurtvalue+(0.1*m5mhealthpoint).roundToInt()}
                m5mhvalue.text="-"+m5mhurtvalue
                if(m5itemid==2){
                    var m2healvalue=(0.2*m5mhurtvalue).roundToInt()
                    m5healvaluetext.text="+"+m2healvalue
                    m5healthpoint=m5healthpoint+m2healvalue
                    m5hp.text=m5healthpoint.toString()
                    object :CountDownTimer (500,1000){
                        override fun onFinish() {
                            m5healvaluetext.text=""
                        }
                        override fun onTick(millisUntilFinished: Long) {
                        }
                    }.start()}
                object : CountDownTimer(1600,1000){
                    override fun onFinish() {
                        m5ch1st.visibility= View.VISIBLE
                        m5ch1atk.visibility= View.GONE
                        m5fireeffect.visibility= View.GONE
                        m5mhp.text=m5mhealthpoint.toString()
                        if(m5mhealthpoint<=0){
                            m5victory.visibility=View.VISIBLE
                            object:CountDownTimer(1000,1000){
                                override fun onFinish() {
                                    startActivity(m5gameset) }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()}
                        else{m5magicast.visibility= View.GONE
                            m5magicaatk.visibility= View.VISIBLE
                            object : CountDownTimer(150,1000){
                                override fun onFinish() {
                                    m5mhvalue.text=""
                                    m5freezelazer.visibility= View.VISIBLE
                                    m5hvalue.text="-"+m5hurtvalue
                                    if(m5itemid==5){m5mhvalue.text="-"+5
                                        m5mhealthpoint=m5mhealthpoint-5
                                        m5mhp.text=m5mhealthpoint.toString()
                                        object:CountDownTimer(500,1000){
                                            override fun onFinish() { m5mhvalue.text="" }
                                            override fun onTick(millisUntilFinished: Long) {}
                                        }.start()
                                        if (m5mhealthpoint <= 0){
                                            m5victory.visibility=View.VISIBLE
                                            object : CountDownTimer(500,1000)
                                            { override fun onFinish() { startActivity(m5gameset) }
                                                override fun onTick(millisUntilFinished: Long) {} }.start() }
                                    }
                                    if(m5healthpoint<=0){
                                        m5defeat.visibility=View.VISIBLE
                                        object :CountDownTimer(1000,1000){
                                            override fun onFinish() {
                                                startActivity(m5gameover)
                                            }
                                            override fun onTick(millisUntilFinished: Long) {}
                                        }.start()
                                    }
                                    else{
                                        object : CountDownTimer(1150,1000){
                                            override fun onFinish() {
                                                m5hvalue.text=""
                                                m5freezelazer.visibility= View.GONE
                                                m5magicast.visibility= View.VISIBLE
                                                m5magicaatk.visibility= View.GONE
                                            }
                                            override fun onTick(millisUntilFinished: Long) {}
                                        }.start()}
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()}
                         }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
            }
            else if (coin <= 3){
                var m5hurtvalue= m5mattackpoint
                m5healthpoint=m5healthpoint-m5hurtvalue
                var m5mhurtvalue = m5attackpoint-m5mdefensepoint
                if(m5mhurtvalue<=0){m5mhurtvalue=0}
                if(m5itemid==3){m5mhurtvalue=m5mhurtvalue+(0.1*m5mhealthpoint).roundToInt()}
                m5magicast.visibility= View.GONE
                m5magicadef.visibility= View.VISIBLE
                m5shield.visibility= View.VISIBLE
                m5mhvalue.text="-"+m5mhurtvalue
                if(m5itemid==2){
                    var m2healvalue=(0.2*m5mhurtvalue).roundToInt()
                    m5healvaluetext.text="+"+m2healvalue
                    m5healthpoint=m5healthpoint+m2healvalue
                    m5hp.text=m5healthpoint.toString()
                    object :CountDownTimer (500,1000){
                        override fun onFinish() {
                            m5healvaluetext.text=""
                        }
                        override fun onTick(millisUntilFinished: Long) {
                        }
                    }.start()}
                m5mhealthpoint=m5mhealthpoint-m5mhurtvalue
                m5mhp.text=m5mhealthpoint.toString()
                object :CountDownTimer(1600,1000){
                    override fun onFinish() {
                        m5ch1st.visibility= View.VISIBLE
                        m5ch1atk.visibility= View.GONE
                        m5fireeffect.visibility= View.GONE }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
                if(m5mhealthpoint<=0){
                    m5victory.visibility=View.VISIBLE
                object:CountDownTimer(1000,1000){
                    override fun onFinish() {
                        startActivity(m5gameset)
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start() }
                else{object : CountDownTimer(2500,1000) {
                    override fun onFinish() {
                        m5mhvalue.text=""
                        m5magicast.visibility = View.VISIBLE
                        m5magicadef.visibility = View.GONE
                        m5shield.visibility = View.GONE
                    }

                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}
                 }
            else {
                var m5hurtvalue= m5mattackpoint+5
                var m5mhurtvalue=m5attackpoint
                if(m5itemid==3){m5mhurtvalue=m5mhurtvalue+(0.1*m5mhealthpoint).roundToInt()}
                m5healthpoint=m5healthpoint-m5hurtvalue
                m5mhealthpoint=m5mhealthpoint-m5mhurtvalue
                m5mhvalue.text="-"+m5mhurtvalue
                if(m5itemid==2){
                    var m2healvalue=(0.2*m5mhurtvalue).roundToInt()
                    m5healvaluetext.text="+"+m2healvalue
                    m5healthpoint=m5healthpoint+m2healvalue
                    m5hp.text=m5healthpoint.toString()
                    object :CountDownTimer (500,1000){
                        override fun onFinish() {
                            m5healvaluetext.text=""
                        }
                        override fun onTick(millisUntilFinished: Long) {
                        }
                    }.start()}
                object : CountDownTimer(1600,1000){
                    override fun onFinish() {
                        m5ch1st.visibility= View.VISIBLE
                        m5ch1atk.visibility= View.GONE
                        m5fireeffect.visibility= View.GONE
                        m5mhp.text=m5mhealthpoint.toString()
                        if(m5mhealthpoint<=0){
                            m5victory.visibility=View.VISIBLE
                            object:CountDownTimer(1000,1000){
                                override fun onFinish() {
                                    startActivity(m5gameset) }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()}
                        else{object : CountDownTimer(0,1000){
                            override fun onFinish() {
                                m5mhvalue.text=""
                                m5ch1st.visibility= View.VISIBLE
                                m5ch1atk.visibility= View.GONE
                                m5fireeffect.visibility= View.GONE
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()}
                        m5magicast.visibility= View.GONE
                        m5magicaatk.visibility= View.VISIBLE
                        object : CountDownTimer(150,1000){
                            override fun onFinish() {
                                m5ultlazer.visibility= View.VISIBLE
                                m5hvalue.text="-"+m5hurtvalue
                                if(m5itemid==5){m5mhvalue.text="-"+5
                                    m5mhealthpoint=m5mhealthpoint-5
                                    m5mhp.text=m5mhealthpoint.toString()
                                    object:CountDownTimer(500,1000){
                                        override fun onFinish() { m5mhvalue.text="" }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                    if (m5mhealthpoint <= 0){
                                        m5victory.visibility=View.VISIBLE
                                        object : CountDownTimer(500,1000)
                                        { override fun onFinish() { startActivity(m5gameset) }
                                            override fun onTick(millisUntilFinished: Long) {} }.start() }
                                }
                                m5hp.text=m5healthpoint.toString()
                                if(m5healthpoint<=0){
                                    m5defeat.visibility=View.VISIBLE
                                    object :CountDownTimer(1000,1000){
                                        override fun onFinish() {
                                            startActivity(m5gameover)
                                        }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                }
                                else{ object : CountDownTimer(1150,1000){
                                    override fun onFinish() {
                                        m5hvalue.text=""
                                        m5ultlazer.visibility= View.GONE
                                        m5magicast.visibility= View.VISIBLE
                                        m5magicaatk.visibility= View.GONE
                                    }
                                    override fun onTick(millisUntilFinished: Long) {}
                                }.start()}
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
            }
        object :CountDownTimer(3000,3000){
            override fun onFinish() {
                m5attack.visibility= View.VISIBLE
                m5defense.visibility= View.VISIBLE
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
        }

        m5defense.setOnClickListener {
            var firedata = Bundle()
            firedata.putInt("atk",intent.getIntExtra("atk",0))
            firedata.putInt("def",intent.getIntExtra("def",0))
            firedata.putInt("hp",intent.getIntExtra("hp",0))
            firedata.putInt("mlv",m5mlv+1)
            firedata.putInt("id",5)
            firedata.putInt("test",1)
            firedata.putInt("itemID",m5itemid)
            m5gameset.putExtras(firedata)

            if(m5itemid==6){m5healvaluetext.text="+"+10
                m5healthpoint=m5healthpoint+10
                if(m5healthpoint >= intent.getIntExtra("hp",0)+10){m5healthpoint = intent.getIntExtra("hp",0)+10}
                m5hp.text=m5healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { m5healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}

            val animationnarrow = AnimationUtils.loadAnimation(this,R.anim.narrow)
            m5attack.visibility= View.GONE
            m5defense.visibility= View.GONE
            m5ch1st.visibility= View.INVISIBLE
            m5ch1def.visibility= View.VISIBLE

            m5ch1def.startAnimation(animationnarrow)

            var coin= (0..4).random()
            if(coin <= 1){
                var m5hurtvalue = m5mattackpoint-m5defensepoint
                if(m5hurtvalue<=0){m5hurtvalue=0}
                m5healthpoint = m5healthpoint-m5hurtvalue
                m5magicast.visibility= View.GONE
                m5magicaatk.visibility= View.VISIBLE
                object : CountDownTimer(150,1000){
                    override fun onFinish() {
                        m5freezelazer.visibility= View.VISIBLE
                        m5hvalue.text = "-"+m5hurtvalue
                        if(m5itemid==5){m5mhvalue.text="-"+5
                            m5mhealthpoint=m5mhealthpoint-5
                            m5mhp.text=m5mhealthpoint.toString()
                            object:CountDownTimer(500,1000){
                                override fun onFinish() { m5mhvalue.text="" }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()
                            if (m5mhealthpoint <= 0){
                                m5victory.visibility=View.VISIBLE
                                object : CountDownTimer(500,1000)
                                { override fun onFinish() { startActivity(m5gameset) }
                                    override fun onTick(millisUntilFinished: Long) {} }.start() }
                        }
                        m5hp.text= m5healthpoint.toString()
                        if(m5healthpoint<=0){
                            m5defeat.visibility =View.VISIBLE
                            object :CountDownTimer(1000,1000){
                                override fun onFinish() {
                                    startActivity(m5gameover)
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()
                        }
                        else{
                            object : CountDownTimer(1150,1000){
                                override fun onFinish() {
                                    m5hvalue.text = ""
                                    m5freezelazer.visibility= View.GONE
                                    m5magicast.visibility= View.VISIBLE
                                    m5magicaatk.visibility= View.GONE
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()
                        }
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start() }
            else if (coin <= 3){
                m5magicast.visibility= View.GONE
                m5magicadef.visibility= View.VISIBLE
                m5shield.visibility=View.VISIBLE
                object : CountDownTimer(1000,1000) {
                    override fun onFinish() {
                        m5magicast.visibility = View.VISIBLE
                        m5magicadef.visibility = View.GONE
                        m5shield.visibility = View.GONE
                    }

                    override fun onTick(millisUntilFinished: Long) {}
                }.start() }
            else {
                var m5hurtvalue = m5mattackpoint-m5defensepoint+5
                if(m5hurtvalue<=0){m5hurtvalue=0}
                m5healthpoint = m5healthpoint-m5hurtvalue
                m5magicast.visibility= View.GONE
                m5magicaatk.visibility= View.VISIBLE
                object : CountDownTimer(150,1000){
                    override fun onFinish() {
                        m5hp.text= m5healthpoint.toString()
                        m5hvalue.text = "-"+m5hurtvalue
                        if(m5itemid==5){m5mhvalue.text="-"+5
                            m5mhealthpoint=m5mhealthpoint-5
                            m5mhp.text=m5mhealthpoint.toString()
                            object:CountDownTimer(500,1000){
                                override fun onFinish() { m5mhvalue.text="" }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()
                            if (m5mhealthpoint <= 0){
                                m5victory.visibility=View.VISIBLE
                                object : CountDownTimer(500,1000)
                                { override fun onFinish() { startActivity(m5gameset) }
                                    override fun onTick(millisUntilFinished: Long) {} }.start() }
                        }
                        m5ultlazer.visibility= View.VISIBLE
                        if(m5healthpoint<=0){
                            m5defeat.visibility =View.VISIBLE
                            object :CountDownTimer(1000,1000){
                                override fun onFinish() {
                                    startActivity(m5gameover)
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()
                        }
                        else{object : CountDownTimer(1150,1000){
                            override fun onFinish() {
                                m5hvalue.text = ""
                                m5ultlazer.visibility= View.GONE
                                m5magicast.visibility= View.VISIBLE
                                m5magicaatk.visibility= View.GONE
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()}
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start() }
            object :CountDownTimer(2000,3000){
                override fun onFinish() {
                    m5attack.visibility= View.VISIBLE
                    m5defense.visibility= View.VISIBLE
                    m5ch1st.visibility=View.VISIBLE
                }
                override fun onTick(millisUntilFinished: Long) {}
            }.start()
        }


    }
}