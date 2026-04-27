package com.example.katalog_wisata_pantai_bali

import android.os.Build
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

        // ── TERIMA OBJECT PANTAI DARI INTENT ──────────────────────────────────
        val pantai = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("PANTAI", Pantai::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("PANTAI") as? Pantai
        }

        // ── TAMPILKAN DATA KE SEMUA VIEW ──────────────────────────────────────
        if (pantai != null) {
            imgDetailFoto.setImageResource(pantai.fotoResId)
            tvNamaPantai.text = pantai.nama
            tvLokasi.text     = "📍 ${pantai.lokasi}"
            tvHarga.text      = pantai.harga
            tvRating.text     = "${pantai.rating} / 5.0"
            tvJamBuka.text    = pantai.jamBuka
            tvDeskripsi.text  = pantai.deskripsi
        }

        // ── TOMBOL KEMBALI ────────────────────────────────────────────────────
        btnKembali.setOnClickListener {
            finish()
        }

        // TODO Minggu 4: tambahkan Logcat dengan tag NIM 42430032
    }
}
