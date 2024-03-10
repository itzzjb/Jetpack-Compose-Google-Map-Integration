package io.januda.gamelist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.januda.gamelist.ui.theme.MeredioTheme

@Composable
fun GameList() {

}

@Preview(showBackground = true)
@Composable
fun GameListPreview() {
    // We use MeredioTheme in Preview
    MeredioTheme {
        GameList()
    }
}
