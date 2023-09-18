package com.yildirimtechnologies.sqlliteprojesi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val veriTabanim = this.openOrCreateDatabase("Ürünler", Context.MODE_PRIVATE,null)
            veriTabanim.execSQL("CREATE TABLE IF NOT EXISTS ürünler(id INTEGER PRIMARY KEY, isim TEXT, fiyat INTEGER)")
            //veriTabanim.execSQL("INSERT INTO ürünler(isim , fiyat) VALUES ('Casio Saat',2500)")
           // veriTabanim.execSQL("INSERT INTO ürünler(isim , fiyat) VALUES ('Casio Saat',2500)")
            //veriTabanim.execSQL("INSERT INTO ürünler(isim , fiyat) VALUES ('Nazar Saat',2500)")
            //execSQL("UPDATE ürünler SET fiyat = 3000 WHERE id = 3")
            veriTabanim.execSQL("DELETE FROM ürünler WHERE isim = 'Nazar Saat'")
            val cursor = veriTabanim.rawQuery("SELECT * FROM ürünler ",null)
            val isimIx = cursor.getColumnIndex("isim")
            val fiyatIX = cursor.getColumnIndex("fiyat")
            val idIX = cursor.getColumnIndex("id")
            while (cursor.moveToNext()){
                println("İsim:"+cursor.getString(isimIx))
                println("Fiyat:"+cursor.getInt(fiyatIX))
                println("Id:" + cursor.getInt(idIX))
            }

        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}
