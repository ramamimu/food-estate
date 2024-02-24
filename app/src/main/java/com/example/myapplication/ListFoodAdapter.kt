package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFoodAdapter(private val listFood: ArrayList<Food>) :RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    interface OnItemClickCallback{
        fun onItemClicked(data: Food)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_food_item)
        val tvTitle: TextView = itemView.findViewById(R.id.title_food_item)
        val tvDescription: TextView = itemView.findViewById(R.id.description_food_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_food_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFood.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFood[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvTitle.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            val moveIntent = Intent(holder.itemView.context, DetailFoodActivity::class.java)
            moveIntent.putExtra(DetailFoodActivity.DETAIL_FOOD_KEY,  listFood[holder.adapterPosition])
            holder.itemView.context.startActivity(moveIntent)
        }
    }
}