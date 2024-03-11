package io.januda.buyer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.januda.buyer.models.Game
import io.januda.buyer.models.games
import io.januda.buyer.ui.components.GameRow
import io.januda.buyer.ui.theme.MeredioTheme

@Composable
fun GameList(games: List<Game>) {
    // LazyColumn is a Composable in Jetpack Compose.
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        // If you only have one item to show
        /*
        item  {
            Text(text = "Januda")
        }
        */

        // items(games) -> Says to iterate over items in games: List<Game>
        items (games) {
            // For each item of games: List<Game> called game Call GameRow composable.
            game -> GameRow(game = game)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameListPreview() {
    // We use MeredioTheme in Preview
    MeredioTheme {
        // You can now directly get the dummy list created in models
        GameList(games = games)
    }
}

// Note -

/*
1. Column:
- `Column` is a simple layout component that arranges its children in a vertical sequence.
- It eagerly composes all the children regardless of whether they are visible or not.
- This means that even if you have a long list of items, all items will be composed and rendered in the layout, which might lead to performance issues if the list is too long.

2. Lazy Column:
- `LazyColumn` is a more optimized version of `Column`.
- It is designed to efficiently handle large lists of items by lazily composing and rendering only the items that are currently visible on the screen.
- As the user scrolls through the list, `LazyColumn` dynamically composes and displays only the items that need to be shown, which improves performance significantly, especially for long lists.

In summary, if you have a small number of items to display vertically, you can use `Column` without any performance concerns.
However, if you're dealing with a potentially large dataset, such as a list of items retrieved from a database or an API, it's recommended to use `LazyColumn` to ensure smooth scrolling and better performance.
*/