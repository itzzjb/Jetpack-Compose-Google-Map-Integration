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

// Creating some dummy games for use.
val mirage = Game(
    "Assassin's Creed Mirage",
    "Assassin's Creed Mirage is a 2023 action-adventure game developed by Ubisoft Bordeaux and published by Ubisoft.",
    "https://upload.wikimedia.org/wikipedia/en/2/23/Assassin%27s_Creed_Mirage_cover.jpeg"
)

val valorant =  Game (
    "Valorant",
    "Valorant is a free-to-play first-person tactical hero shooter developed and published by Riot Games, for Windows.",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Valorant_logo_-_pink_color_version.svg/2880px-Valorant_logo_-_pink_color_version.svg.png"
)

val lol =  Game (
    "Leauge Of Legends",
    "League of Legends, commonly referred to as League, is a 2009 multiplayer online battle arena video game developed and published by Riot Games.",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/League_of_Legends_2019_vector.svg/2880px-League_of_Legends_2019_vector.svg.png"
)

// Creating a dummy game list from above created dummy games.
// You need listOf function here to create a list
val games = listOf<Game>(mirage, valorant,lol,mirage, valorant,lol,mirage, valorant,lol,mirage, valorant,lol,mirage, valorant,lol)