package com.example.pokemonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_list)
        //require activity gets context from parent activity
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recycler.adapter = adapter
        adapter.onItemClickListener = {
            Toast.makeText(requireActivity(),it.name,Toast.LENGTH_LONG)
        }

        val pokemonList = mutableListOf<Pokemon>(
            Pokemon(
                id = 1,
                name = "Pikachu",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.ELECTRIC
            ),
            Pokemon(
                id = 2,
                name = "Raichu",
                hp = 400,
                attack = 200,
                defense = 100,
                speed = 100,
                PokemonType.ELECTRIC
            ),
            Pokemon(
                id = 3,
                name = "Ponyta",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.FIRE
            ),
            Pokemon(
                id = 4,
                name = "Machop",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.FIGHTER
            ),
            Pokemon(
                id = 5,
                name = "Squirtle",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.WATER
            )
            ,
            Pokemon(
                id = 6,
                name = "Squirtle",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.WATER
            )
            ,
            Pokemon(
                id = 7,
                name = "Squirtle",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.WATER
            )
            ,
            Pokemon(
                id = 8,
                name = "Squirtle",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.WATER
            )
        )
        adapter.submitList(pokemonList)

        return view
    }
}