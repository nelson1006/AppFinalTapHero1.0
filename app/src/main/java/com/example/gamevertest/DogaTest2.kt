package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.view.animation.AnimationUtils
import pl.droidsonroids.gif.GifImageView

class DogaTest2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doga_test2)
        //角色
        val m2ch1st= findViewById<GifImageView>(R.id.d2ch1st)
        val m2ch1atk1 = findViewById<ImageView>(R.id.d2ch1atk1)
        val m2ch1atk2 = findViewById<ImageView>(R.id.d2ch1atk2)
        val m2ch1atk3 = findViewById<ImageView>(R.id.d2ch1atk3)
        val m2ch1atk4 = findViewById<ImageView>(R.id.d2ch1atk4)
        val m2ch1atk5 = findViewById<ImageView>(R.id.d2ch1atk5)
        val m2ch1atk6 = findViewById<ImageView>(R.id.d2ch1atk6)
        val m2ch1atk7 = findViewById<ImageView>(R.id.d2ch1atk7)
        val m2ch1atk8 = findViewById<ImageView>(R.id.d2ch1atk8)
        val m2ch1atk9 = findViewById<ImageView>(R.id.d2ch1atk9)
        val m2ch1atk10 = findViewById<ImageView>(R.id.d2ch1atk10)
        val m2ch1atk11 = findViewById<ImageView>(R.id.d2ch1atk11)
        val m2ch1atk12 = findViewById<ImageView>(R.id.d2ch1atk12)
        val m2ch1atk13 = findViewById<ImageView>(R.id.d2ch1atk13)
        val m2ch1atk14 = findViewById<ImageView>(R.id.d2ch1atk14)
        val m2ch1atk15 = findViewById<ImageView>(R.id.d2ch1atk15)
        //Magica
        val d2dogast= findViewById<GifImageView>(R.id.d2dogast)
        val d2dogaatk= findViewById<GifImageView>(R.id.d2dogaatk)
        val d2dogadef= findViewById<GifImageView>(R.id.d2dogadef)
        //血量
        val m2hp= findViewById<TextView>(R.id.d2hp)
        val m2mhp= findViewById<TextView>(R.id.d2mhp)
        //特效
        val d2fireball= findViewById<GifImageView>(R.id.d2fireball)
        val d2fireballboom = findViewById<GifImageView>(R.id.d2fireballboom)
        val m2mhvalue= findViewById<TextView>(R.id.d2mhurtvalue)
        val m2hvalue= findViewById<TextView>(R.id.d2hurtvalue)
        val m2lightning = findViewById<GifImageView>(R.id.d2lightningeff)
        val d2fireimprove = findViewById<GifImageView>(R.id.d2fireimprove)
        val m2victory = findViewById<GifImageView>(R.id.m2victory)
        val m2defeat = findViewById<GifImageView>(R.id.m2defeat)
        //按鈕
        val m2attack= findViewById<Button>(R.id.d2attack)
        val m2defense= findViewById<Button>(R.id.d2defense)
        val d2gameset = Intent(this,Addpoint::class.java)
        val d2gameover = Intent(this,CharChoose::class.java)
        //變數
        val m2id = intent.getIntExtra("id",0)
        var m2attackpoint = intent.getIntExtra("atk",0)
        var m2defensepoint = intent.getIntExtra("def",0)
        var m2healthpoint = intent.getIntExtra("hp",0)
        var m2mlv = intent.getIntExtra("mlv",0)
        var m2mattackpoint = m2mlv*2+6
        var m2mdefensepoint = m2mlv*3+5
        var m2mhealthpoint = m2mlv*5+100
        m2hp.text= m2healthpoint.toString()
        m2mhp.text= m2mhealthpoint.toString()

        m2attack.setOnClickListener {
            m2attack.visibility= View.GONE
            m2defense.visibility= View.GONE
            m2ch1st.visibility= View.GONE
            m2ch1atk1.visibility= View.VISIBLE

            var lightdata = Bundle()
            lightdata.putInt("atk",m2attackpoint)
            lightdata.putInt("def",m2defensepoint)
            lightdata.putInt("hp",intent.getIntExtra("hp",0))
            lightdata.putInt("mlv",m2mlv+1)
            lightdata.putInt("id",m2id)
            lightdata.putInt("test",1)
            d2gameset.putExtras(lightdata)

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
                                                                                                                                    m2hvalue.text = ""
                                                                                                                                    m2lightning.visibility= View.INVISIBLE
                                                                                                                                    m2ch1atk15.visibility= View.GONE
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

            val fireballanim = AnimationUtils.loadAnimation(this,R.anim.leftmove)
            val fireboomanim = AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            var coin = (0..7).random()
            if(coin <=4){
                var m2mhurtvalue = m2attackpoint
                var m2hurtvalue = m2mattackpoint
                if (m2hurtvalue<=0){m2hurtvalue=0}
                if (m2mhurtvalue<=0){m2mhurtvalue=0}
                m2healthpoint = m2healthpoint-m2hurtvalue
                m2mhealthpoint = m2mhealthpoint-m2mhurtvalue
                object:CountDownTimer(700,1000){
                    override fun onFinish() {
                        m2mhvalue.text="-"+m2mhurtvalue
                        m2mhp.text = m2mhealthpoint.toString()
                        if (m2mhealthpoint<=0){
                            m2victory.visibility=View.VISIBLE
                            object:CountDownTimer(1000,1000){
                            override fun onFinish() {
                                startActivity(d2gameset)
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()}
                        else{object:CountDownTimer(800,1000){
                            override fun onFinish() {
                                m2mhvalue.text=""
                                d2dogast.visibility=View.GONE
                                d2dogaatk.visibility=View.VISIBLE
                                object:CountDownTimer(100,1000){
                                    override fun onFinish() {
                                        d2fireball.visibility=View.VISIBLE
                                        d2fireball.startAnimation(fireballanim)
                                        object:CountDownTimer(500,1000){
                                            override fun onFinish() {
                                                d2fireball.clearAnimation()
                                                d2fireball.visibility=View.GONE
                                                d2fireballboom.visibility= View.VISIBLE
                                                d2fireballboom.startAnimation(fireboomanim)
                                                m2hvalue.text="-"+m2hurtvalue
                                                m2hp.text=m2healthpoint.toString()
                                                if(m2healthpoint<=0){ m2defeat.visibility=View.VISIBLE
                                                    object:CountDownTimer(800,1000){
                                                        override fun onFinish() {
                                                            startActivity(d2gameover)
                                                        }
                                                        override fun onTick(millisUntilFinished: Long) {}
                                                    }.start()}
                                                else{object:CountDownTimer(800,1000){
                                                    override fun onFinish() {
                                                        d2fireballboom.clearAnimation()
                                                        d2fireballboom.visibility=View.GONE
                                                        m2attack.visibility= View.VISIBLE
                                                        m2defense.visibility= View.VISIBLE
                                                        d2dogast.visibility=View.VISIBLE
                                                        d2dogaatk.visibility=View.GONE
                                                        m2hvalue.text=""
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
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()}
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()

            }
            else if(coin<=6){
                d2dogast.visibility=View.GONE
                d2dogadef.visibility=View.VISIBLE
                var m2mhurtvalue = m2attackpoint-m2mdefensepoint
                var m2hurtvalue = m2mattackpoint
                if (m2hurtvalue<=0){m2hurtvalue=0}
                if (m2mhurtvalue<=0){m2mhurtvalue=0}
                m2healthpoint = m2healthpoint-m2hurtvalue
                m2mhealthpoint = m2mhealthpoint-m2mhurtvalue
                object:CountDownTimer(700,1000){
                    override fun onFinish() {
                        m2mhvalue.text="-"+m2mhurtvalue
                        m2mhp.text = m2mhealthpoint.toString()
                        if (m2mhealthpoint<=0){
                            m2victory.visibility=View.VISIBLE
                            object:CountDownTimer(1000,1000){
                                override fun onFinish() {
                                    startActivity(d2gameset)
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()}
                        else{object:CountDownTimer(800,1000){
                            override fun onFinish() {
                                m2mhvalue.text=""
                                d2dogadef.visibility=View.GONE
                                d2dogaatk.visibility=View.VISIBLE
                                object:CountDownTimer(100,1000){
                                    override fun onFinish() {
                                        d2fireball.visibility=View.VISIBLE
                                        d2fireball.startAnimation(fireballanim)
                                        object:CountDownTimer(500,1000){
                                            override fun onFinish() {
                                                d2fireball.clearAnimation()
                                                d2fireball.visibility=View.GONE
                                                d2fireballboom.visibility= View.VISIBLE
                                                d2fireballboom.startAnimation(fireboomanim)
                                                m2hvalue.text="-"+m2hurtvalue
                                                m2hp.text = m2healthpoint.toString()
                                                if(m2healthpoint<=0){
                                                    m2defeat.visibility=View.VISIBLE
                                                    object:CountDownTimer(800,1000){
                                                        override fun onFinish() {
                                                            startActivity(d2gameover)
                                                        }
                                                        override fun onTick(millisUntilFinished: Long) {}
                                                    }.start()
                                                }else{
                                                    object:CountDownTimer(800,1000){
                                                    override fun onFinish() {
                                                        m2hvalue.text=""
                                                        d2fireballboom.clearAnimation()
                                                        d2fireballboom.visibility=View.GONE
                                                        m2attack.visibility= View.VISIBLE
                                                        m2defense.visibility= View.VISIBLE
                                                        d2dogast.visibility=View.VISIBLE
                                                        d2dogaatk.visibility=View.GONE
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
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()}
                    }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()

            }
            else{
                d2dogast.visibility=View.GONE
                d2dogaatk.visibility=View.VISIBLE
                d2fireimprove.visibility=View.VISIBLE
                var m2mhurtvalue = m2attackpoint
                if (m2mhurtvalue<=0){m2mhurtvalue=0}
                m2mhealthpoint = m2mhealthpoint-m2mhurtvalue
                object:CountDownTimer(700,1000){
                    override fun onFinish() {
                        m2mhvalue.text="-"+m2mhurtvalue
                        m2mhp.text=m2mhealthpoint.toString()
                        if (m2mhealthpoint<=0){
                            m2victory.visibility=View.VISIBLE
                            object:CountDownTimer(1000,1000){
                                override fun onFinish() {
                                    startActivity(d2gameset)
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()}
                    else{object:CountDownTimer(2000,1000){
                            override fun onFinish() {
                                m2mhvalue.text=""
                                m2mattackpoint=m2mattackpoint+3
                                m2mhealthpoint=m2mhealthpoint+10
                                m2mhp.text=m2mhealthpoint.toString()
                                d2dogast.visibility=View.VISIBLE
                                d2dogaatk.visibility=View.GONE
                                d2fireimprove.visibility=View.GONE
                                m2attack.visibility=View.VISIBLE
                                m2defense.visibility=View.VISIBLE
                            }
                            override fun onTick(millisUntilFinished: Long) {
                            }
                    }.start()}}

                    override fun onTick(millisUntilFinished: Long) {}
                }.start()
            }

        }
    }
}