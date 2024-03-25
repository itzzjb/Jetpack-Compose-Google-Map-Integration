package io.januda.buyer.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

// You can get the code of this directly from the Google Maps Platform website too
@Composable
fun GoogleMapView() {
    // Specifying the latitude and the longitude of a location
    // LatLng -> Latitude Longitude
    val sigiriya = LatLng(7.95416285, 80.75583031)
    val colombo = LatLng(6.927079, 79.861244)

    // Camera position represents the zoom level and the initial position of the bird eye view of google map
    // Zoom level (high) -> Closer to the object  ---> Highest 17f
    // This is a state. So whenever the google map is redrawing the map we are remembering this position.
    val cameraPositionState = rememberCameraPositionState {
        // Camera position contains both initial position and the zoom level
        // initial position will be the center of the application on the screen. And the map will be zoomed around it.
        position = CameraPosition.fromLatLngZoom(colombo, 8f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        // We can even go without a Marker.
        // But in that case we will only see the Map.
        // The marker will show a specific location in the Map.
        Marker(
            state = MarkerState(position = sigiriya),
            title = "Sigiriya",
            // snippet is like a small description
            snippet = "Marker in Sigiriya"
        )
    }
}
// We need to add the API key to the AndroidManifest.xml