package io.januda.buyer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.januda.buyer.ui.components.GameList
import io.januda.buyer.ui.theme.MeredioTheme
import io.januda.buyer.viewModels.GamesViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // We need to instantiate the a view mode.
        val vm = GamesViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            MeredioTheme (darkTheme = true) {

                // You can now directly get the dummy objects created in models
                // GameList(games = games)

                // We are putting the instantiated vm as an argument
                GameList(vm = vm)

            }
        }
    }
}


/*
@Preview(showBackground = true)
// Inorder to preview it should be a composable.
@Composable
fun IntroPagePreview() {
    // We are calling the GameRow() Composable here.
    MeredioTheme (darkTheme = true) {
        /*
        val game = Game(
            "Assassin's Creed Mirage",
            "Assassin's Creed Mirage is a 2023 action-adventure game developed by Ubisoft Bordeaux and published by Ubisoft.",
            "https://upload.wikimedia.org/wikipedia/en/2/23/Assassin%27s_Creed_Mirage_cover.jpeg"
        )
        GameRow(game = game)
         */
        // You can now directly get the dummy objects created in models
        GameRow(game = valorant)
    }
}
*/

/*
// The dark mode configuration is wrong. Check it.
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
// Inorder to preview it should be a composable.
@Composable
fun IntroPagePreviewDark() {
    // We are calling the IntroPage() Composable here.
    IntroPage()
}
*/



