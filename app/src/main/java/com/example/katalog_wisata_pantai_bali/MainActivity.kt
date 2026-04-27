package com.example.katalog_wisata_pantai_bali

import android.content.Intent
import android.os.Bundle
import android.view.View
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

    // displayList adalah salinan kerja yang ditampilkan di ListView.
    // Data asli tetap aman di DataPantai.daftarPantai.
    private val displayList = ArrayList<Pantai>()
    private lateinit var adapter: PantaiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSearch = findViewById(R.id.etSearch)
        btnSearch = findViewById(R.id.btnSearch)
        btnSortAZ = findViewById(R.id.btnSortAZ)
        btnSortZA = findViewById(R.id.btnSortZA)
        btnReset  = findViewById(R.id.btnReset)
        lvPantai  = findViewById(R.id.lvPantai)
        tvEmpty   = findViewById(R.id.tvEmpty)

        // Isi displayList dengan seluruh data, lalu pasang adapter
        displayList.addAll(DataPantai.daftarPantai)
        adapter = PantaiAdapter(this, displayList)
        lvPantai.adapter = adapter
        updateEmptyState()

        // ── INTENT KE DETAIL ACTIVITY ─────────────────────────────────────────
        lvPantai.setOnItemClickListener { _, _, position, _ ->
            val pantai = displayList[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("PANTAI", pantai)
            }
            startActivity(intent)
        }

        // ── VALIDASI + LINEAR SEARCH ──────────────────────────────────────────
        btnSearch.setOnClickListener {
            val keyword = etSearch.text.toString().trim()
            if (keyword.isEmpty()) {
                Toast.makeText(this, "Kolom pencarian tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            linearSearch(keyword)
        }

        // ── BUBBLE SORT A → Z ─────────────────────────────────────────────────
        btnSortAZ.setOnClickListener {
            bubbleSort(ascending = true)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Diurutkan A → Z", Toast.LENGTH_SHORT).show()
        }

        // ── BUBBLE SORT Z → A ─────────────────────────────────────────────────
        btnSortZA.setOnClickListener {
            bubbleSort(ascending = false)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Diurutkan Z → A", Toast.LENGTH_SHORT).show()
        }

        // ── RESET ─────────────────────────────────────────────────────────────
        btnReset.setOnClickListener {
            displayList.clear()
            displayList.addAll(DataPantai.daftarPantai)
            etSearch.setText("")
            adapter.notifyDataSetChanged()
            updateEmptyState()
            Toast.makeText(this, "Data direset ke semula", Toast.LENGTH_SHORT).show()
        }
    }

    // ── ALGORITMA LINEAR SEARCH ───────────────────────────────────────────────
    // Mencari pantai berdasarkan nama secara berurutan satu per satu.
    private fun linearSearch(keyword: String) {
        val hasil = ArrayList<Pantai>()
        for (pantai in DataPantai.daftarPantai) {
            if (pantai.nama.contains(keyword, ignoreCase = true)) {
                hasil.add(pantai)
            }
        }

        displayList.clear()
        displayList.addAll(hasil)
        adapter.notifyDataSetChanged()
        updateEmptyState()

        if (hasil.isEmpty()) {
            Toast.makeText(this, "Pantai \"$keyword\" tidak ditemukan", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ditemukan ${hasil.size} hasil untuk \"$keyword\"", Toast.LENGTH_SHORT).show()
        }
    }

    // ── ALGORITMA BUBBLE SORT ─────────────────────────────────────────────────
    // Mengurutkan displayList berdasarkan nama dengan cara menukar dua elemen
    // yang bersebelahan apabila urutannya tidak sesuai.
    private fun bubbleSort(ascending: Boolean) {
        val n = displayList.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - 1 - i) {
                val perluDitukar = if (ascending) {
                    displayList[j].nama > displayList[j + 1].nama
                } else {
                    displayList[j].nama < displayList[j + 1].nama
                }
                if (perluDitukar) {
                    val temp = displayList[j]
                    displayList[j] = displayList[j + 1]
                    displayList[j + 1] = temp
                }
            }
        }
    }

    // ── EMPTY STATE ───────────────────────────────────────────────────────────
    private fun updateEmptyState() {
        if (displayList.isEmpty()) {
            lvPantai.visibility = View.GONE
            tvEmpty.visibility = View.VISIBLE
        } else {
            lvPantai.visibility = View.VISIBLE
            tvEmpty.visibility = View.GONE
        }
    }
}
