package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailFoodActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_FOOD_KEY = "detail_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        val food = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(DETAIL_FOOD_KEY, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(DETAIL_FOOD_KEY)
        }

        if (food != null){
            val title: TextView = findViewById(R.id.name_food_detail)
            val description: TextView = findViewById(R.id.description_food_detail)
            val image: ImageView = findViewById(R.id.image_food_detail)

            title.text = food.name
            description.text = food.description
            image.setImageResource(food.photo)
        }
    }
}