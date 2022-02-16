package com.example.pokemonapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    interface PokemonSelectListener{
        fun onPokemonSelected(pokemon:Pokemon)
    }

    private lateinit var pokemonSelectLister:PokemonSelectListener

    //Primer metodo que se ejecuta cuando se llama al fragment
    override fun onAttach(context: Context) {
        super.onAttach(context)
        //El activity que implemente este fragment debe implementar a fuerza PokemonSelectListener
        pokemonSelectLister= try{
            context as PokemonSelectListener
        }catch (e:ClassCastException){
            throw ClassCastException("$context must implement PokemonSelectListener")
        }

    }

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
            pokemonSelectLister.onPokemonSelected(it)
        }

        val pokemonList = mutableListOf(
            Pokemon(
                id = 1,
                name = "Pikachu",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.ELECTRIC,
                url = "https://wallpaperaccess.com/full/201914.jpg"
            ),
            Pokemon(
                id = 2,
                name = "Bulbasaur",
                hp = 400,
                attack = 200,
                defense = 100,
                speed = 100,
                PokemonType.GRASS,
                url = "http://pm1.narvii.com/7626/2dab04d59531d3d1399cccf3516046f6cb08e26br1-1200-776v2_uhq.jpg"
            ),
            Pokemon(
                id = 3,
                name = "Ponyta",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.FIRE,
                url = "https://i.pinimg.com/originals/c0/a2/43/c0a2435578dcf6e6b84aaa272548d8f6.jpg"
            ),
            Pokemon(
                id = 4,
                name = "Machop",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.FIGHTER,
                url = "https://sooluciona.com/wp-content/uploads/2018/09/Machoke.jpg"
            ),
            Pokemon(
                id = 5,
                name = "Squirtle",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.WATER,
                url = "https://www.tonica.la/__export/1610402225188/sites/debate/img/2021/01/11/squirtle-vistos-como-varios-tipos-de-pokxmon.jpg_1902800913.jpg"
            )
            ,
            Pokemon(
                id = 6,
                name = "Charmander",
                hp = 200,
                attack = 100,
                defense = 200,
                speed = 200,
                PokemonType.FIRE,
                url="https://cdn.custom-cursor.com/cursors/pokemon_charmander__and_charizard_893.png",
            )
        )
        adapter.submitList(pokemonList)

        return view
    }
}