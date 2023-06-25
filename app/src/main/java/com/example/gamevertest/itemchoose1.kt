package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class itemchoose1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itemchoose1)

        var selection:Int = 0
        val btnchoose = findViewById<Button>(R.id.button2)
        val choosetext = findViewById<TextView>(R.id.textViewchoose)
        val charchoose = Intent(this, CharChoose::class.java)

        val bc = findViewById<ImageView>(R.id.imageViewbc)
        val bt = findViewById<ImageView>(R.id.imageViewbt)
        val rb = findViewById<ImageView>(R.id.imageViewrb)
        val fh = findViewById<ImageView>(R.id.imageViewfh)
        val tm = findViewById<ImageView>(R.id.imageViewtm)
        val wa = findViewById<ImageView>(R.id.imageViewwa)

        bc.setOnClickListener {
            selection = 1
            choosetext.text = "裝備：黑色切割者\n"+"屬性：攻擊力+3\n" + "效果：無視3點敵方減傷能力"
            btnchoose.visibility= View.VISIBLE}

        bt.setOnClickListener {
            selection = 2
            choosetext.text = "裝備：嗜血者\n"+"屬性：攻擊力+3\n" + "效果：恢復造成傷害20%血量"
            btnchoose.visibility= View.VISIBLE}

        rb.setOnClickListener {
            selection = 3
            choosetext.text = "裝備：殞落王者之劍\n"+"屬性：攻擊力+2\n" + "效果：攻擊額外造成敵方當前生命10%傷害"
            btnchoose.visibility= View.VISIBLE}

        fh.setOnClickListener {
            selection = 4
            choosetext.text = "裝備：冰霜之心\n"+"屬性：生命力+10\n" + "效果：每次所受傷害-5"
            btnchoose.visibility= View.VISIBLE}

        tm.setOnClickListener {
            selection = 5
            choosetext.text = "裝備：荊棘之甲\n"+"屬性：生命力+10\n" + "效果：承受敵方傷害對敵方反彈5點傷害"
            btnchoose.visibility= View.VISIBLE}

        wa.setOnClickListener {
            selection = 6
            choosetext.text = "裝備：好戰者鎧甲\n"+"屬性：生命力+10\n" + "效果：每回合回復10點生命"
            btnchoose.visibility= View.VISIBLE}

        btnchoose.setOnClickListener {
            charchoose.putExtra("selectionitem",selection)
            startActivity(charchoose)
            }
    }
    }
