package com.charles.toptenindonesiamovies

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Top Ten Indonesia Movies"

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_page, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("Recycle")
    private fun getListHeroes(): ArrayList<Hero> {
        val dataPoster = resources.getStringArray(R.array.data_poster)
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataTahun = resources.getStringArray(R.array.data_tahun)
        val dataPenonton = resources.getStringArray(R.array.data_penonton)
        val dataProduksi = resources.getStringArray(R.array.data_produksi)
        val dataSutradara = resources.getStringArray(R.array.data_sutradara)
        val listHero = ArrayList<Hero>()
        for (i in dataJudul.indices) {
            val hero = Hero(
                dataJudul[i],
                dataDescription[i],
                dataPoster[i],
                dataTahun[i],
                dataPenonton[i],
                dataSutradara[i],
                dataProduksi[i],
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }
}