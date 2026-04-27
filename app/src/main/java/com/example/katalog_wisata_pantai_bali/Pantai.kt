package com.example.katalog_wisata_pantai_bali

import java.io.Serializable

data class Pantai(
    val nama: String,
    val lokasi: String,
    val harga: String,
    val rating: Double,
    val jamBuka: String,
    val deskripsi: String,
    val fotoResId: Int
) : Serializable
