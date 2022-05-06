package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dosyayolu="com.example.sharedpreferences"
        val anahtarisim="isim"
        val anahtaryas="yas"

        var kaydet=findViewById<Button>(R.id.button)
        var sil=findViewById<Button>(R.id.button2)
        var goster=findViewById<Button>(R.id.gosterbtn)

        var yastext = findViewById<EditText>(R.id.yas)
        var isimtext = findViewById<EditText>(R.id.isim)

        val tutucu = getSharedPreferences(dosyayolu,Context.MODE_PRIVATE)
        val tutucuedit=tutucu.edit()



        kaydet.setOnClickListener {
            tutucuedit.putString(anahtarisim,isimtext.text.toString())
            tutucuedit.putInt(anahtaryas,yastext.text.toString().toInt())
            tutucuedit.apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_SHORT).show()
        }

        sil.setOnClickListener {
            tutucuedit.remove(anahtarisim)
            tutucuedit.remove(anahtaryas)
            tutucuedit.commit()
            Toast.makeText(applicationContext,"Kayıt silindi",Toast.LENGTH_SHORT).show()
        }

        goster.setOnClickListener {
            Toast.makeText(applicationContext,
                "isim : ${tutucu.getString(anahtarisim,"Değer yok")}\n" +
                        "yas : ${tutucu.getInt(anahtaryas,0)}",Toast.LENGTH_SHORT).show()
        }

    }
}