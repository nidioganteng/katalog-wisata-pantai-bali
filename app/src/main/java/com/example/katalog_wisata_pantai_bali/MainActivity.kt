package com.example.katalog_wisata_pantai_bali

import android.content.Intent
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

    // Daftar nama pantai sementara untuk menampilkan ListView
    // (data lengkap Array akan dibuat di Minggu 3)
    private val namaPantai = arrayListOf(
        "Pantai Amed",
        "Pantai Balangan",
        "Pantai Bias Tugel",
        "Pantai Dreamland",
        "Pantai Kuta",
        "Pantai Lovina",
        "Pantai Nusa Dua",
        "Pantai Pandawa",
        "Pantai Sanur",
        "Pantai Seminyak"
    )

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

        // Setup ListView dengan daftar nama sementara
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namaPantai)
        lvPantai.adapter = adapter

        // ── INTENT KE DETAIL ACTIVITY (Minggu 2) ─────────────────────────────
        lvPantai.setOnItemClickListener { _, _, position, _ ->
            val nama = namaPantai[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("NAMA", nama)
            }
            startActivity(intent)
        }

        // ── VALIDASI INPUT SEARCH (Minggu 2) ──────────────────────────────────
        btnSearch.setOnClickListener {
            val keyword = etSearch.text.toString().trim()
            if (keyword.isEmpty()) {
                Toast.makeText(this, "Kolom pencarian tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Mencari: \"$keyword\"", Toast.LENGTH_SHORT).show()
                // TODO Minggu 3: implementasi Linear Search
            }
        }

        // TODO Minggu 3: implementasi Bubble Sort A-Z, Z-A, dan Reset
    }
}
