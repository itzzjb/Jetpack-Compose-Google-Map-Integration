package io.januda.buyer.models

// This is not a UI class
// This is like a data type for Game ( Object of this class represents a game )
// This is a model to use in the GameList
// When we use data classes we can create models without constructors.
data class Game(
    val name: String,
    val description: String,
    val imageUrl: String
)
