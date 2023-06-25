package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class Addpoint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addpoint)
        //加數值圖片
        val addatkptpic = findViewById<GifImageView>(R.id.addattack)
        val adddefptpic = findViewById<ImageView>(R.id.adddefense)
        val addhptpic = findViewById<ImageView>(R.id.addhealth)
        //加數值文字
        var addatkplstext = findViewById<TextView>(R.id.attacktext)
        var adddefplstext = findViewById<TextView>(R.id.defensetext)
        val addhpplstext = findViewById<TextView>(R.id.healthtext)
        //加數值後跳轉
        val mgtst2 = Intent(this,MagicaTest2::class.java)
        val sltst2 = Intent(this,SlimeTest2::class.java)
        val dogatst2 = Intent(this,DogaTest2::class.java)

        val mgtst4 = Intent(this,MagicaTest4::class.java)
        val sltst4 = Intent(this,SlimeTest4::class.java)
        val dogatst4 = Intent(this,DogaTest2::class.java)

        val mgtst5 = Intent(this,MagicaTest5::class.java)
        val sltst5 = Intent(this,SlimeTest5::class.java)
        val dogatst5 = Intent(this,DogaTest2::class.java)

        val testSelect= Intent(this,TestSelect::class.java)

        var bundle = Bundle()
        //識別角色gotofight若數值為1代表史萊姆關 2代表dog關
        val addid = intent.getIntExtra("id",0)
        val gotofight = intent.getIntExtra("test",0)
        val monsterlevel = intent.getIntExtra("mlv",0)
        //載入角色數值
        var chaatk = intent.getIntExtra("atk",0)
        var chadef = intent.getIntExtra("def",0)
        var chahp = intent.getIntExtra("hp",0)
        var item=intent.getIntExtra("itemID",0)
        //角色數值
        val chaatktext = findViewById<TextView>(R.id.characterattackpointtext)
        val chadeftext = findViewById<TextView>(R.id.characterdefensepointtext)
        val chahptext = findViewById<TextView>(R.id.characterhealthpointtext)
        var nextmonsterlvview = findViewById<TextView>(R.id.nextmonsterleveltext)
        chaatktext.text= chaatk.toString()
        chadeftext.text= chadef.toString()
        chahptext.text= chahp.toString()
        nextmonsterlvview.text= monsterlevel.toString()
        //角色備戰圖片
        val ch2light = findViewById<GifImageView>(R.id.ch2light)
        val ch4knight = findViewById<GifImageView>(R.id.ch4knight)
        val ch5fire = findViewById<GifImageView>(R.id.ch5fire)


        //define_light_add_point
        if(addid==2){
            ch2light.visibility= View.VISIBLE
            addatkplstext.text = "+"+7
            adddefplstext.text = "+"+2
            addhpplstext.text= "+"+1
            addatkptpic.setOnClickListener {
                bundle.putInt("atk",chaatk+7)
                bundle.putInt("def",chadef)
                bundle.putInt("hp",chahp)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",2)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect) }
            adddefptpic.setOnClickListener{
                bundle.putInt("atk",chaatk)
                bundle.putInt("def",chadef+2)
                bundle.putInt("hp",chahp)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",2)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect)   }
            addhptpic.setOnClickListener{
                bundle.putInt("atk",chaatk)
                bundle.putInt("def",chadef)
                bundle.putInt("hp",chahp+1)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",2)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect) }
        }
        else if (addid==4){
            ch4knight.visibility= View.VISIBLE
            addatkplstext.text = "+"+1
            adddefplstext.text = "+"+1
            addhpplstext.text= "+"+5
            addatkptpic.setOnClickListener {
                bundle.putInt("atk",chaatk+1)
                bundle.putInt("def",chadef)
                bundle.putInt("hp",chahp)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",2)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect)}
            adddefptpic.setOnClickListener {
                bundle.putInt("atk",chaatk)
                bundle.putInt("def",chadef+1)
                bundle.putInt("hp",chahp)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",2)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect)}
            addhptpic.setOnClickListener {
                bundle.putInt("atk",chaatk)
                bundle.putInt("def",chadef)
                bundle.putInt("hp",chahp+5)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",2)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect)}
        }
        //cha_fire_add_point
        else if (addid==5){
            ch5fire.visibility= View.VISIBLE
            addatkplstext.text = "+"+3
            adddefplstext.text = "+"+1
            addhpplstext.text= "+"+4
            addatkptpic.setOnClickListener {
                bundle.putInt("atk",chaatk+3)
                bundle.putInt("def",chadef)
                bundle.putInt("hp",chahp)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",5)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect)}
            adddefptpic.setOnClickListener {
                bundle.putInt("atk",chaatk)
                bundle.putInt("def",chadef+1)
                bundle.putInt("hp",chahp)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",5)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect)}
            addhptpic.setOnClickListener {
                bundle.putInt("atk",chaatk)
                bundle.putInt("def",chadef)
                bundle.putInt("hp",chahp+4)
                bundle.putInt("mlv",monsterlevel)
                bundle.putInt("id",5)
                bundle.putInt("test",gotofight)
                bundle.putInt("itemID",item)
                testSelect.putExtras(bundle)
                startActivity(testSelect)}
        }
        else{ }
    }
}