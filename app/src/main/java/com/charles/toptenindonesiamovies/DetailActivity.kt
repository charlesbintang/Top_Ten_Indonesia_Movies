package com.charles.toptenindonesiamovies

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val imgPoster: ImageView = findViewById(R.id.detail_poster)
        val tvTitle: TextView = findViewById(R.id.detail_title)
        val tvDescription: TextView = findViewById(R.id.detail_description)
        val tvTahun: TextView = findViewById(R.id.detail_tahun)
        val tvPenonton: TextView = findViewById(R.id.detail_penonton)
        val tvSutradara: TextView = findViewById(R.id.detail_sutradara)
        val tvProduksi: TextView = findViewById(R.id.detail_produksi)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(EXTRA_DATA, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(EXTRA_DATA)
        }

        if (dataHero != null) {
            Glide.with(this).load(dataHero.poster).into(imgPoster)
            tvTitle.text = dataHero.title
            tvDescription.text = dataHero.description
            tvTahun.text = "Tahun: ${dataHero.tahun}"
            tvPenonton.text = "Penonton: ${dataHero.penonton}"
            tvSutradara.text = "Disutradarai Oleh: ${dataHero.sutradara}"
            tvProduksi.text = dataHero.produksi
        }
    }
}