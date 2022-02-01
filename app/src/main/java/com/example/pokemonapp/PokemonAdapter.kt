package com.example.pokemonapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (Pokemon) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val id = view.findViewById<TextView>(R.id.tv_pokemon_id)
        private val name = view.findViewById<TextView>(R.id.tv_pokemon_name)
        private val image = view.findViewById<ImageView>(R.id.iv_pokemon_type)

        fun bind(pokemon: Pokemon) {
            id.text = pokemon.id.toString()
            name.text = pokemon.name
            val imageId = PokemonType.from(pokemon.type)
            image.setImageResource(imageId)

            view.setOnClickListener{
                if (::onItemClickListener.isInitialized)
                onItemClickListener(pokemon)
            }
        }
    }

}
