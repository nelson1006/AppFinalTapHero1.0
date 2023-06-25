package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class MagicaTest4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magica_test4)
        //角色
        val m4ch1st= findViewById<GifImageView>(R.id.m4ch1st)
        val m4ch1atk= findViewById<ImageView>(R.id.m4ch1attack)
        val m4ch1def= findViewById<GifImageView>(R.id.m4ch1defense)
        //Magica
        val m4magicast= findViewById<GifImageView>(R.id.m4magicast)
        val m4magicaatk= findViewById<GifImageView>(R.id.m4magicaatk)
        val m4magicadef= findViewById<GifImageView>(R.id.m4magicadef)
        //血量
        val m4hp= findViewById<TextView>(R.id.m4hp)
        val m4mhp= findViewById<TextView>(R.id.m4mhp)
        //特效
        val m4hvalue= findViewById<TextView>(R.id.m4hurtvalue)
        val m4bloody = findViewById<GifImageView>(R.id.m4bloodyeff)
        val m4ultlazer= findViewById<ImageView>(R.id.m4ultlazer)
        val m4freezelazer= findViewById<ImageView>(R.id.m4freezelazer)
        val m4shield= findViewById<ImageView>(R.id.m4shield)
        val m4victory = findViewById<GifImageView>(R.id.m4victory)
        val m4defeat = findViewById<GifImageView>(R.id.m4defeat)
        //按鈕
        val m4attack= findViewById<Button>(R.id.m4attack)
        val m4defense= findViewById<Button>(R.id.m4defense)
        //變數
        var m4healthpoint = intent.getIntExtra("hp",0)
        var m4mhealthpoint = 50
        //跳轉
        val m4gameset = Intent(this,Addpoint::class.java)
        val m4gameover = Intent(this,CharChoose::class.java)

        m4hp.text= m4healthpoint.toString()
        m4mhp.text= m4mhealthpoint.toString()

        m4attack.setOnClickListener {
            m4attack.visibility= View.GONE
            m4defense.visibility= View.GONE
            m4ch1st.visibility= View.GONE
            m4ch1atk.visibility= View.VISIBLE
            m4bloody.visibility= View.VISIBLE
            object : CountDownTimer(1000,1000){
                override fun onFinish() {
                    m4ch1atk.visibility = View.GONE
                    m4bloody.visibility= View.GONE
                    m4ch1st.visibility = View.VISIBLE
                    if(m4mhealthpoint <=0 ){
                        m4defeat.visibility=View.VISIBLE
                        object : CountDownTimer(1000,1000){
                            override fun onFinish() {  }
                            override fun onTick(millisUntilFinished: Long) {} }.start()
                    }
                    else{}}

                override fun onTick(millisUntilFinished: Long) {}
            }
        }
    }
}