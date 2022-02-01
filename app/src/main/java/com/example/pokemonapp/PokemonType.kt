package com.example.pokemonapp

enum class PokemonType{
    GRASS,FIRE,WATER,FIGHTER,ELECTRIC;

    companion object
}

fun PokemonType.Companion.from(type:PokemonType) = when (type) {
    PokemonType.GRASS -> R.drawable.ic_grass_ic
    PokemonType.FIRE -> R.drawable.ic_fire_ic
    PokemonType.WATER -> R.drawable.ic_water_ic
    PokemonType.FIGHTER -> R.drawable.ic_fighting_ic
    PokemonType.ELECTRIC -> R.drawable.ic_electric_ic
}