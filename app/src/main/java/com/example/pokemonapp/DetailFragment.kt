package com.example.pokemonapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    private lateinit var imageView:ImageView
    private lateinit var hpText:TextView
    private lateinit var attackText:TextView
    private lateinit var defenseText:TextView
    private lateinit var speedText:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        imageView=rootView.findViewById(R.id.iv_detail)
        hpText=rootView.findViewById(R.id.tv_hp)
        attackText=rootView.findViewById(R.id.tv_attack)
        defenseText=rootView.findViewById(R.id.tv_defense)
        speedText=rootView.findViewById(R.id.tv_speed)
        return rootView
    }

    fun setPokemonData(pokemon: Pokemon){
        Glide.with(this).load(pokemon.url).into(imageView);
        hpText.text = getString(R.string.hp_format,pokemon.hp)
        attackText.text=getString(R.string.attack_format,pokemon.attack)
        defenseText.text=getString(R.string.defense_format,pokemon.defense)
        speedText.text=getString(R.string.speed_format,pokemon.speed)
    }
}