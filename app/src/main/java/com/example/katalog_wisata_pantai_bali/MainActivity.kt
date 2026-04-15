package com.example.katalog_wisata_pantai_bali

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var btnSortAZ: Button
    private lateinit var btnSortZA: Button
    private lateinit var btnReset: Button
    private lateinit var lvPantai: ListView
    private lateinit var tvEmpty: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSearch  = findViewById(R.id.etSearch)
        btnSearch = findViewById(R.id.btnSearch)
        btnSortAZ = findViewById(R.id.btnSortAZ)
        btnSortZA = findViewById(R.id.btnSortZA)
        btnReset  = findViewById(R.id.btnReset)
        lvPantai  = findViewById(R.id.lvPantai)
        tvEmpty   = findViewById(R.id.tvEmpty)

        // TODO Minggu 2: Intent ke DetailActivity + kirim data + validasi input
        // TODO Minggu 3: data Array pantai + Linear Search + Bubble Sort
        // TODO Minggu 4: try-catch + Logcat dengan tag NIM
    }
}