package com.example.pokemonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(),ListFragment.PokemonSelectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPokemonSelected(pokemon: Pokemon) {
         Toast.makeText(this,"Pokemon:${pokemon.name}",Toast.LENGTH_SHORT).show()
    }

}