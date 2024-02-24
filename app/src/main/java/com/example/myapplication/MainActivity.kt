package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_food)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListHeroes(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.title_foods)
        val dataDescription = resources.getStringArray(R.array.description_foods)
        val dataPhoto = resources.obtainTypedArray(R.array.image_foods)
        val listHero = ArrayList<Food>()
        for(i in dataName.indices){
            val hero = Food(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvHeroes.adapter = listFoodAdapter
    }

}