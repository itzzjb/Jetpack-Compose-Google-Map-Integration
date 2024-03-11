package io.januda.buyer.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import io.januda.buyer.R
import io.januda.buyer.models.Game
import io.januda.buyer.models.valorant
import io.januda.buyer.ui.theme.MeredioTheme

// Small parts of the ui like One single row of the Game list are added

// When using beta libraries we need to add @OptIn to say that we know that this might change in the future
// And if something happen I will make sure I will change this in the future.
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
// We need to pass in a Game ( data class - object ) into this composable function
fun GameRow(game: Game) {
    Row() {

        // Getting the image of the game to display in the UI
        // painterResource is used to get an image from the resource -> drawable
        // R file is not in the file of the project. We are getting a generated R file under the hood. This will map all the resources to a Kotlin class.
        // We need to select the correct R file in the correct interface because there can be many R files in the project for different different
        // Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = game.name )

        // We need to get permission from the user of the device inorder to connect to camera, microphone, location, internet etc.
        // Ask the permission using AndroidManifest.xml
        // We need to use 3rd party libraries in order to get images from URLs.
        // Glide -> An image loading and caching library for Android focused on smooth scrolling

        GlideImage(
            model = game.imageUrl,
            contentDescription = game.name,
            // This is a default image got from the drawables which will only be output when loading the screen from the internet.
            // You need a placeHolder Composable here.
            loading = placeholder(R.drawable.ic_launcher_background),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(8.dp)
        )
        Column(modifier = Modifier.padding(8.dp)) {
            // Getting the name and  description to the UI as text composable.
            Text(text = game.name)
            // We don't need a Modifier here to do customizations
            Text(text = game.description, fontSize= 12.sp, lineHeight = 15.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameRowPreview() {
    MeredioTheme {
        // We need to create a Game object and pass it on to the preview.
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

// Note -

// dp (Density-independent Pixels):
// This is a unit of measurement that represents the physical size of a pixel on a screen with a density of 160 dots per inch (dpi).
// It is a commonly used unit in Android development because it scales with the screen density.
// 1 dp is equivalent to one pixel on a 160 dpi screen, but on higher density screens, such as those found on modern smartphones, 1 dp might translate to multiple physical pixels.

// sp (Scale-independent Pixels):
// This is similar to dp but it also takes into account the user's preferred text size settings in the device's settings.
// It's mainly used for specifying text sizes, ensuring that text remains legible across different devices and screen sizes, even if the user has set their preferred text size to be larger or smaller than the default.