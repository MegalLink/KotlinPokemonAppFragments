package com.example.pokemonapp

data class Pokemon(
    val id: Long,
    val name: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val type:PokemonType
)