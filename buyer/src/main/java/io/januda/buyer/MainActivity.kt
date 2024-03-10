package io.januda.buyer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.januda.buyer.models.Game
import io.januda.buyer.ui.components.GameRow
import io.januda.buyer.ui.theme.MeredioTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeredioTheme (darkTheme = true) {
                val game = Game(
                    "Assassin's Creed Mirage",
                    "Assassin's Creed Mirage is a 2023 action-adventure game developed by Ubisoft Bordeaux and published by Ubisoft.",
                    "https://upload.wikimedia.org/wikipedia/en/2/23/Assassin%27s_Creed_Mirage_cover.jpeg"
                )
                GameRow(game = game)
            }
        }
    }
}


@Preview(showBackground = true)
// Inorder to preview it should be a composable.
@Composable
fun IntroPagePreview() {
    // We are calling the GameRow() Composable here.
    MeredioTheme (darkTheme = true) {
        val game = Game(
            "Assassin's Creed Mirage",
            "Assassin's Creed Mirage is a 2023 action-adventure game developed by Ubisoft Bordeaux and published by Ubisoft.",
            "https://upload.wikimedia.org/wikipedia/en/2/23/Assassin%27s_Creed_Mirage_cover.jpeg"
        )
        GameRow(game = game)
    }
}

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



