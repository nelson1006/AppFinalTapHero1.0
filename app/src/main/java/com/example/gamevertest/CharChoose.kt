package com.example.gamevertest

import android.content.Intent
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class CharChoose : AppCompatActivity() {
    private var music = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charchoose)

        val mediaPlayer = MediaPlayer.create(this,R.raw.theraisingfightingspirit)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        val switchmusic = findViewById<ImageView>(R.id.volumeView)

        //播放or靜音背景音樂
        switchmusic.setOnClickListener {
            if (music==true) {
                // 關閉音樂
                switchmusic.setImageResource(R.drawable.mute)
                // 在這裡添加關閉音樂的邏輯
                mediaPlayer.pause()
                music = false
            } else {
                // 開啟音樂
                switchmusic.setImageResource(R.drawable.volume)
                // 在這裡添加開啟音樂的邏輯
                mediaPlayer.start()
                music = true
            }
        }

        //選擇角色的縮圖
        val acc1 = findViewById<ImageView>(R.id.acc1)
        val acc2 = findViewById<ImageView>(R.id.acc2)
        val acc4 = findViewById<ImageView>(R.id.acc4)
        val acc5 = findViewById<ImageView>(R.id.acc5)
        //選擇道具
        val itemselect = findViewById<ImageView>(R.id.itemselect)
        val itemname = findViewById<TextView>(R.id.itemname)
        //角色動圖
        val ch1choose = findViewById<ImageView>(R.id.ch1choose)
        val ch2choose = findViewById<ImageView>(R.id.ch2choose)
        val ch4choose = findViewById<ImageView>(R.id.ch4choose)
        val ch5choose = findViewById<ImageView>(R.id.ch5choose)

        //跳轉場地
        val chs = findViewById<Button>(R.id.chs)
        var testSelect = Intent(this,TestSelect::class.java)
        var test2 = Intent(this,SlimeTest2::class.java)
        var test4 = Intent(this,SlimeTest4::class.java)
        var test5 = Intent(this,SlimeTest5::class.java)
        val itemchoose = Intent(this,itemchoose1::class.java)

        //角色數值
        var chaatkpt = findViewById<TextView>(R.id.atkpt)
        var chadefpt = findViewById<TextView>(R.id.defpt)
        var chahpt = findViewById<TextView>(R.id.hpt)
        var charitemid = intent.getIntExtra("selectionitem",0)

        val warning = findViewById<TextView>(R.id.warning)

        chs.visibility= View.GONE
        val atkpic = findViewById<ImageView>(R.id.imageView12)
        val defpic = findViewById<ImageView>(R.id.imageView14)
        val hppic = findViewById<ImageView>(R.id.imageView15)

        itemselect.setOnClickListener { startActivity(itemchoose) }

        if(charitemid==1){
            itemname.text="黑色切割者\n"+"atk+3,無視3點def"
            itemselect.setImageResource(R.drawable.blackcleaver)
        }

        if(charitemid==2){
            itemname.text="嗜血者\n"+"atk+3,恢復傷害20％血量"
            itemselect.setImageResource(R.drawable.bloodthirster)
        }

        if(charitemid==3){
            itemname.text="殞落王者之劍\n"+"atk+2,額外敵方hp10%傷害"
            itemselect.setImageResource(R.drawable.ruinedblade)
        }

        if(charitemid==4){
            itemname.text="冰霜之心\n"+"hp+10,受到傷害-5"
            itemselect.setImageResource(R.drawable.frozenheart)
        }

        if(charitemid==5){
            itemname.text="荊棘之甲\n"+"hp+10,受到傷害反彈5點"
            itemselect.setImageResource(R.drawable.thornmail)
        }

        if(charitemid==6){
            itemname.text="好戰者鎧甲\n"+"hp+10,每回合恢復生命10點"
            itemselect.setImageResource(R.drawable.warmogarmor)
        }


        acc1.setOnClickListener{
            chs.visibility= View.GONE
            ch1choose.visibility= View.VISIBLE
            ch2choose.visibility= View.GONE
            ch4choose.visibility= View.GONE
            ch5choose.visibility= View.GONE
            atkpic.visibility=View.GONE
            defpic.visibility=View.GONE
            hppic.visibility=View.GONE
            chaatkpt.text="coming"
            chadefpt.text="soon"
            chahpt.text=""
            warning.visibility=View.VISIBLE
        }

        acc2.setOnClickListener{
            chs.visibility= View.VISIBLE
            ch1choose.visibility= View.GONE
            ch2choose.visibility= View.VISIBLE
            ch4choose.visibility= View.GONE
            ch5choose.visibility= View.GONE
            atkpic.visibility=View.VISIBLE
            defpic.visibility=View.VISIBLE
            hppic.visibility=View.VISIBLE
            chaatkpt.text="17+7"
            chadefpt.text="15+2"
            chahpt.text="65+1"
            warning.visibility=View.GONE
        }

        acc4.setOnClickListener{
            chs.visibility= View.GONE
            ch1choose.visibility= View.GONE
            ch2choose.visibility= View.GONE
            ch4choose.visibility= View.VISIBLE
            ch5choose.visibility= View.GONE
            atkpic.visibility=View.GONE
            defpic.visibility=View.GONE
            hppic.visibility=View.GONE
            chaatkpt.text="coming"
            chadefpt.text="soon"
            chahpt.text=""
            warning.visibility=View.VISIBLE
        }
        acc5.setOnClickListener{
            chs.visibility= View.VISIBLE
            ch1choose.visibility= View.GONE
            ch2choose.visibility= View.GONE
            ch4choose.visibility= View.GONE
            ch5choose.visibility= View.VISIBLE
            atkpic.visibility=View.VISIBLE
            defpic.visibility=View.VISIBLE
            hppic.visibility=View.VISIBLE
            chaatkpt.text="25+3"
            chadefpt.text="5+1"
            chahpt.text="75+4"
            warning.visibility=View.GONE
        }

        chs.setOnClickListener {
            if (ch1choose.visibility == View.VISIBLE){
                startActivity(testSelect)
            }
            else if(ch2choose.visibility == View.VISIBLE){
                //light數值
                var lightdata = Bundle()
                lightdata.putInt("atk",17)
                lightdata.putInt("def",15)
                lightdata.putInt("hp",65)
                lightdata.putInt("mlv",1)
                lightdata.putInt("id",2)
                lightdata.putInt("test",0)
                lightdata.putInt("itemID",charitemid)
                testSelect.putExtras(lightdata)
                startActivity(testSelect)
            }
            else if(ch4choose.visibility == View.VISIBLE){
                //knight數值
                var knightdata = Bundle()
                knightdata.putInt("atk",10)
                knightdata.putInt("def",20)
                knightdata.putInt("hp",85)
                knightdata.putInt("mlv",1)
                knightdata.putInt("id",4)
                knightdata.putInt("test",0)
                knightdata.putInt("itemID",charitemid)
                testSelect.putExtras(knightdata)
                startActivity(testSelect)
            }
            else if(ch5choose.visibility == View.VISIBLE){
                //fire數值
                var firedata = Bundle()
                firedata.putInt("atk",20)
                firedata.putInt("def",5)
                firedata.putInt("hp",75)
                firedata.putInt("mlv",1)
                firedata.putInt("id",5)
                firedata.putInt("test",0)
                firedata.putInt("itemID",charitemid)
                testSelect.putExtras(firedata)
                startActivity(testSelect)
            }
            else{} }
    }
}