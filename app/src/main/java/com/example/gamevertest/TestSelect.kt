package com.example.gamevertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import pl.droidsonroids.gif.GifImageView

class TestSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_select)

        val slime = findViewById<ImageView>(R.id.slime)
        val magica = findViewById<ImageView>(R.id.magica)
        val magicast = findViewById<GifImageView>(R.id.magicast)
        val slimest = findViewById<GifImageView>(R.id.slimest)
        val challenge = findViewById<Button>(R.id.button3)

        val slimeTest2 = Intent(this,SlimeTest2::class.java)
        val slimeTest5 = Intent(this,SlimeTest5::class.java)

        val magicaTest2 = Intent(this,MagicaTest2::class.java)
        val magicaTest5 = Intent(this,MagicaTest5::class.java)
        //monster data
        val atkpt = findViewById<TextView>(R.id.atkpt)
        val defpt = findViewById<TextView>(R.id.defpt)
        val hpt = findViewById<TextView>(R.id.hpt)
        //載入角色數值
        var chaatk = intent.getIntExtra("atk",0)
        var chadef = intent.getIntExtra("def",0)
        var chahp = intent.getIntExtra("hp",0)
        var chaid = intent.getIntExtra("id",0)
        var item= intent.getIntExtra("itemID",0)
        var mlv = intent.getIntExtra("mlv",0)

        var bundle = Bundle()
        bundle.putInt("atk",chaatk)
        bundle.putInt("def",chadef)
        bundle.putInt("hp",chahp)
        bundle.putInt("mlv",mlv)
        bundle.putInt("id",chaid)
        bundle.putInt("itemID",item)

        slime.setOnClickListener {
            var mattackpoint = mlv*2+10
            var mdefensepoint = mlv*2+3
            var mhealthpoint = mlv*5+35
            slimest.visibility= View.VISIBLE
            magicast.visibility= View.GONE
            atkpt.text = mattackpoint.toString()
            defpt.text = mdefensepoint.toString()
            hpt.text = mhealthpoint.toString()
        }
        magica.setOnClickListener {
            var mattackpoint = mlv*3+6
            var mdefensepoint = mlv*3+5
            var mhealthpoint = mlv*4+100
            slimest.visibility= View.GONE
            magicast.visibility= View.VISIBLE
            atkpt.text = mattackpoint.toString()
            defpt.text = mdefensepoint.toString()
            hpt.text = mhealthpoint.toString()
        }
        challenge.setOnClickListener {
            if(slimest.visibility==View.VISIBLE){
                if(chaid==2){
                    slimeTest2.putExtras(bundle)
                    startActivity(slimeTest2)}
                if(chaid==5){
                    slimeTest5.putExtras(bundle)
                    startActivity(slimeTest5)}
            }
            else if(magicast.visibility==View.VISIBLE){
                if(chaid==2){
                    magicaTest2.putExtras(bundle)
                    startActivity(magicaTest2)}
                if(chaid==5){
                    magicaTest5.putExtras(bundle)
                    startActivity(magicaTest5)}
            }
        }



    }
}