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

class SlimeTest5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slimetest5)
        //角色
        val s5ch1st= findViewById<GifImageView>(R.id.s5ch1st)
        val s5ch1atk= findViewById<ImageView>(R.id.s5ch1attack)
        val s5ch1def= findViewById<GifImageView>(R.id.s5ch1defense)
        //史萊姆
        val s5slime= findViewById<GifImageView>(R.id.s5slime)
        val s5slimeatk= findViewById<ImageView>(R.id.s5slimeattack)
        //血量
        val s5hp= findViewById<TextView>(R.id.s5hp)
        val s5mhp= findViewById<TextView>(R.id.s5mhp)
        //特效
        val s5watermagic= findViewById<ImageView>(R.id.s5watermagic1)
        val s5fireeffect= findViewById<GifImageView>(R.id.s5fireeff)
        val s5monstereff= findViewById<ImageView>(R.id.s5monstereff)
        val s5mhvalue= findViewById<TextView>(R.id.s5mhurtvalue)
        val s5hvalue= findViewById<TextView>(R.id.s5hurtvalue)
        val s5healvaluetext= findViewById<TextView>(R.id.s5healvalue)
        val s5victory = findViewById<GifImageView>(R.id.s5victory)
        val s5defeat = findViewById<GifImageView>(R.id.s5defeat)
        //按鈕
        val s5attack= findViewById<Button>(R.id.s5attack)
        val s5defense= findViewById<Button>(R.id.s5defense)
        //變數
        var s5attackpoint = intent.getIntExtra("atk",0)
        var s5defensepoint = intent.getIntExtra("def",0)
        var s5healthpoint = intent.getIntExtra("hp",0)
        var s5mlv = intent.getIntExtra("mlv",0)
        var s5itemid= intent.getIntExtra("itemID",0)
        var s5mattackpoint = s5mlv*2+10
        var s5mdefensepoint = s5mlv*2+3
        var s5mhealthpoint = s5mlv*5+35
        s5hp.text= s5healthpoint.toString()
        s5mhp.text= s5mhealthpoint.toString()
        //跳轉
        val s5gameset = Intent(this,Addpoint::class.java)
        val s5gameover = Intent(this,CharChoose::class.java)

        if(s5itemid==1){
            s5attackpoint=s5attackpoint+3
            s5mdefensepoint=s5mdefensepoint-3 }
        else if(s5itemid==2){s5attackpoint=s5attackpoint+3 }
        else if(s5itemid==3){s5attackpoint=s5attackpoint+2 }
        else if(s5itemid==4){s5healthpoint=s5healthpoint+10
            s5mattackpoint=s5mattackpoint-5}
        else if(s5itemid==5){s5healthpoint=s5healthpoint+10}
        else if(s5itemid==6){s5healthpoint=s5healthpoint+10}

        s5hp.text= s5healthpoint.toString()
        s5mhp.text= s5mhealthpoint.toString()

        s5attack.setOnClickListener {
            var firedata = Bundle()
            firedata.putInt("atk",intent.getIntExtra("atk",0))
            firedata.putInt("def",intent.getIntExtra("def",0))
            firedata.putInt("hp",intent.getIntExtra("hp",0))
            firedata.putInt("mlv",s5mlv+1)
            firedata.putInt("id",5)
            firedata.putInt("test",2)
            firedata.putInt("itemID",s5itemid)
            s5gameset.putExtras(firedata)

            if(s5itemid==6){s5healvaluetext.text="+"+10
                s5healthpoint=s5healthpoint+10
                if(s5healthpoint >= intent.getIntExtra("hp",0)+10){s5healthpoint = intent.getIntExtra("hp",0)+10}
                s5hp.text=s5healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { s5healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}

            val s5animationmagicanim = AnimationUtils.loadAnimation(this,R.anim.magic_anim)
            val s5animationbigger = AnimationUtils.loadAnimation(this,R.anim.zoom_in)
            val s5animationsmaller = AnimationUtils.loadAnimation(this,R.anim.zoom_out)

            var s5mhurtvalue = s5attackpoint-s5mdefensepoint
            var s5hurtvalue = s5mattackpoint
            if(s5mhurtvalue<=0){s5mhurtvalue=0}
            if(s5hurtvalue<=0){s5hurtvalue=0}

            if(s5itemid==3){s5mhurtvalue=s5mhurtvalue+(0.1*s5mhealthpoint).roundToInt()}

            s5mhealthpoint = s5mhealthpoint-s5mhurtvalue
            s5healthpoint = s5healthpoint-s5hurtvalue

            s5attack.visibility= View.GONE
            s5defense.visibility= View.GONE
            s5ch1st.visibility= View.INVISIBLE
            s5ch1atk.visibility= View.VISIBLE
            s5fireeffect.visibility= View.VISIBLE
            object : CountDownTimer(1000,1000){
                override fun onFinish() {
                    s5mhp.text= s5mhealthpoint.toString()
                    s5ch1atk.visibility = View.GONE
                    s5ch1st.visibility = View.VISIBLE
                    s5fireeffect.visibility= View.INVISIBLE
                    if (s5mhealthpoint<=0){
                        s5victory.visibility=View.VISIBLE
                        object:CountDownTimer(1000,1000){
                            override fun onFinish() { startActivity(s5gameset) }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                    }
                    else{s5mhvalue.text = "-"+s5mhurtvalue
                        if(s5itemid==2){
                            var s2healvalue=(0.2*s5mhurtvalue).roundToInt()
                            s5healvaluetext.text="+"+s2healvalue
                            s5healthpoint=s5healthpoint+s2healvalue
                            s5hp.text=s5healthpoint.toString()
                            object:CountDownTimer(500,1000){
                                override fun onFinish() {
                                    s5healvaluetext.text=""
                                }
                                override fun onTick(millisUntilFinished: Long) {}
                            }.start()}
                        object : CountDownTimer(350,1000){
                            override fun onFinish() {
                                s5mhvalue.text = ""
                                s5slimeatk.visibility= View.VISIBLE
                                s5slime.visibility= View.GONE
                                s5watermagic.visibility= View.VISIBLE
                                s5watermagic.startAnimation(s5animationmagicanim)

                            }

                            override fun onTick(millisUntilFinished: Long) {
                            }
                        }.start()

                        object : CountDownTimer(750,1000){
                            override fun onFinish() {
                                s5slimeatk.visibility= View.GONE
                                s5slime.visibility= View.VISIBLE
                                s5monstereff.visibility= View.VISIBLE
                                s5monstereff.startAnimation(s5animationbigger)
                                s5hvalue.text = "-"+s5hurtvalue
                                if(s5itemid==5){s5mhvalue.text="-"+5
                                    s5mhealthpoint=s5mhealthpoint-5
                                    s5mhp.text=s5mhealthpoint.toString()
                                    object:CountDownTimer(500,1000){
                                        override fun onFinish() { s5mhvalue.text="" }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()
                                    if (s5mhealthpoint <= 0){
                                        s5victory.visibility=View.VISIBLE
                                        object : CountDownTimer(500,1000)
                                        { override fun onFinish() { startActivity(s5gameset) }
                                            override fun onTick(millisUntilFinished: Long) {} }.start() }
                                }
                                s5hp.text= s5healthpoint.toString()
                                if (s5healthpoint<=0){
                                    s5defeat.visibility=View.VISIBLE
                                    object:CountDownTimer(1000,1000){
                                        override fun onFinish() { startActivity(s5gameover) }
                                        override fun onTick(millisUntilFinished: Long) {}
                                    }.start()}
                                else{
                                    object : CountDownTimer(1000,1000){
                                    override fun onFinish() {
                                        s5hvalue.text = ""
                                        s5monstereff.clearAnimation()
                                        s5watermagic.clearAnimation()
                                        s5monstereff.visibility= View.GONE
                                        s5watermagic.visibility= View.GONE
                                        s5attack.visibility= View.VISIBLE
                                        s5defense.visibility= View.VISIBLE }
                                    override fun onTick(millisUntilFinished: Long) {
                                    }
                                }.start()}
                            }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                        }
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }.start()
        }

        s5defense.setOnClickListener {
            if(s5itemid==6){s5healvaluetext.text="+"+10
                s5healthpoint=s5healthpoint+10
                if(s5healthpoint >= intent.getIntExtra("hp",0)+10){s5healthpoint = intent.getIntExtra("hp",0)+10}
                s5hp.text=s5healthpoint.toString()
                object:CountDownTimer(500,1000){
                    override fun onFinish() { s5healvaluetext.text="" }
                    override fun onTick(millisUntilFinished: Long) {}
                }.start()}

            var s5hurtvalue = s5mattackpoint-s5defensepoint
            if(s5hurtvalue<=0){s5hurtvalue=0}
            s5healthpoint = s5healthpoint-s5hurtvalue
            val animationnarrow = AnimationUtils.loadAnimation(this,R.anim.narrow)
            val animationleft = AnimationUtils.loadAnimation(this,R.anim.magic_miss)
            s5attack.visibility= View.GONE
            s5defense.visibility= View.GONE
            s5ch1st.visibility= View.INVISIBLE
            s5ch1def.visibility= View.VISIBLE
//史萊姆攻擊
            s5slimeatk.visibility= View.VISIBLE
            s5slime.visibility= View.GONE
            s5watermagic.visibility= View.VISIBLE
            s5watermagic.startAnimation(animationleft)

            object : CountDownTimer(500,1000){
                override fun onFinish() {
                    s5ch1def.startAnimation(animationnarrow)
                    s5hvalue.text = "-"+s5hurtvalue
                    if(s5itemid==5){s5mhvalue.text="-"+5
                        s5mhealthpoint=s5mhealthpoint-5
                        s5mhp.text=s5mhealthpoint.toString()
                        object:CountDownTimer(500,1000){
                            override fun onFinish() { s5mhvalue.text="" }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()
                        if (s5mhealthpoint <= 0){
                            s5victory.visibility=View.VISIBLE
                            object : CountDownTimer(500,1000)
                            { override fun onFinish() { startActivity(s5gameset) }
                                override fun onTick(millisUntilFinished: Long) {} }.start() }
                    }
                    s5hp.text= s5healthpoint.toString()
                    if (s5healthpoint<=0){
                        s5defeat.visibility=View.VISIBLE
                        object:CountDownTimer(1000,1000){
                            override fun onFinish() { startActivity(s5gameover) }
                            override fun onTick(millisUntilFinished: Long) {}
                        }.start()}
                    else {
                        object : CountDownTimer(1300, 1000) {
                            override fun onFinish() {
                                s5hvalue.text = ""
                                s5attack.visibility = View.VISIBLE
                                s5defense.visibility = View.VISIBLE
                                s5ch1def.clearAnimation()
                                s5ch1def.visibility = View.GONE
                                s5ch1st.visibility = View.VISIBLE
                                s5watermagic.clearAnimation()
                                s5watermagic.visibility = View.GONE
                                s5slimeatk.visibility = View.GONE
                                s5slime.visibility = View.VISIBLE
                            }

                            override fun onTick(millisUntilFinished: Long) {
                            }
                        }.start()
                    }
                }

                override fun onTick(millisUntilFinished: Long) {}
            }.start()
        }
    }
}