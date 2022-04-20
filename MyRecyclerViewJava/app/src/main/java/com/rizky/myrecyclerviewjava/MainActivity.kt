package com.rizky.myrecyclerviewjava

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle

import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private var rvHeroes: RecyclerView? = null
    private val list = ArrayList<Hero>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes!!.setHasFixedSize(true)

        list.addAll(HeroesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvHeroes!!.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes!!.adapter = listHeroAdapter
    }

    private fun showRecyclerGrid() {
        rvHeroes!!.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes!!.adapter = gridHeroAdapter
    }

}