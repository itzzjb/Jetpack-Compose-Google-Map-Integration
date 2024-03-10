package io.januda.buyer

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroPage()
        }
    }
}

@Preview(showBackground = true)
// Inorder to preview it should be a composable.
@Composable
fun IntroPagePreview() {
    // We are calling the IntroPage() Composable here.
    IntroPage()
}

// The dark mode configuration is wrong. Check it.
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
// Inorder to preview it should be a composable.
@Composable
fun IntroPagePreviewDark() {
    // We are calling the IntroPage() Composable here.
    IntroPage()
}


