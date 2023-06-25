package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class chardata : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chardata)
        val bundle = Bundle()
        var currentlv: Int = intent.getIntExtra("lv", 0)
        var selection: Int = intent.getIntExtra("selectionitem",0)
        val btntogame = findViewById<Button>(R.id.button)
        val startgame = Intent(this, GameTest::class.java)
        val items = findViewById<ImageView>(R.id.imageViewitem1)
        val tvlv = findViewById<TextView>(R.id.textViewLv)
        val tvatk = findViewById<TextView>(R.id.textViewAtk)
        val tvhp = findViewById<TextView>(R.id.textViewHp)
        val item = findViewById<TextView>(R.id.textViewitem)

        val basiccharhp : Int = 10
        val basiccharatk: Int = 2


        var charhp = currentlv*3+basiccharhp
        var charatk = currentlv*2+basiccharatk

        tvlv.text="Lv."+currentlv.toString()
        tvatk.text="攻擊力："+charatk.toString()
        tvhp.text="生命值："+charhp.toString()
        //item.text=selection.toString()







        if(selection==1){
            item.text="黑色切割者"
        }

        if(selection==2){
            item.text="嗜血者"
        }

        if(selection==3){
            item.text="殞落王者之劍"
        }

        if(selection==4){
            item.text="冰霜之心"
        }

        if(selection==5){
            item.text="荊棘之甲"
        }

        if(selection==6){
            item.text="好戰者鎧甲"
        }


        btntogame.setOnClickListener {
            startgame.putExtra("lv",currentlv)
            startActivity(startgame)
        }

        items.setOnClickListener {
            startActivity(Intent(this,itemchoose1::class.java))
        }

    }
}
