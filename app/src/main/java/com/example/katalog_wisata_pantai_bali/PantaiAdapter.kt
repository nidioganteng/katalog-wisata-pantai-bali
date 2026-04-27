package com.example.katalog_wisata_pantai_bali

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PantaiAdapter(context: Context, private val list: ArrayList<Pantai>) :
    ArrayAdapter<Pantai>(context, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView
            ?: LayoutInflater.from(context).inflate(R.layout.item_pantai, parent, false)

        val pantai = list[position]

        view.findViewById<ImageView>(R.id.imgThumbnail).setImageResource(pantai.fotoResId)
        view.findViewById<TextView>(R.id.tvItemNama).text = pantai.nama
        view.findViewById<TextView>(R.id.tvItemLokasi).text = "📍 ${pantai.lokasi}"
        view.findViewById<TextView>(R.id.tvItemHarga).text = "🎫 ${pantai.harga}"
        view.findViewById<TextView>(R.id.tvItemRating).text = "${pantai.rating}"

        return view
    }
}
