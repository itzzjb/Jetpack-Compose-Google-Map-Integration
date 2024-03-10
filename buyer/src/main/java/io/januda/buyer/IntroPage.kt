package io.januda.buyer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// We don't need the class IntroPage() {} here.
@Composable
fun IntroPage() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "Januda",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
            // textAlign = TextAlign.Center,
        )
        Text(
            text = "I like coding",
            fontSize = 30.sp,
            // textAlign = TextAlign.Center
        )
    }
}