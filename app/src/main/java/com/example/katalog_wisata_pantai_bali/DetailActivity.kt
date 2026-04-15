package com.example.katalog_wisata_pantai_bali

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var imgDetailFoto: ImageView
    private lateinit var tvNamaPantai: TextView
    private lateinit var tvLokasi: TextView
    private lateinit var tvHarga: TextView
    private lateinit var tvRating: TextView
    private lateinit var tvJamBuka: TextView
    private lateinit var tvDeskripsi: TextView
    private lateinit var btnKembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imgDetailFoto = findViewById(R.id.imgDetailFoto)
        tvNamaPantai  = findViewById(R.id.tvNamaPantai)
        tvLokasi      = findViewById(R.id.tvLokasi)
        tvHarga       = findViewById(R.id.tvHarga)
        tvRating      = findViewById(R.id.tvRating)
        tvJamBuka     = findViewById(R.id.tvJamBuka)
        tvDeskripsi   = findViewById(R.id.tvDeskripsi)
        btnKembali    = findViewById(R.id.btnKembali)

        btnKembali.setOnClickListener {
            finish()
        }

        // TODO Minggu 2: terima data dari Intent, isi semua TextView & ImageView
        // TODO Minggu 4: tambahkan Logcat dengan tag NIM
    }
}