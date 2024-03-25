package io.januda.buyer.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.rememberCameraPositionState

// You can get the code of this directly from the Google Maps Platform website too
@Composable
fun GoogleMapView() {
    // Specifying the latitude and the longitude of a location
    // LatLng -> Latitude Longitude
    val sigiriya = LatLng(7.95416285, 80.75583031)
    val colombo = LatLng(6.927079, 79.861244)
    val diyabeduma = LatLng(7.9297, 80.8710)
    val dambulla = LatLng(7.8742, 80.6511)

    // We need to provide the points to the polygon as a list
    // Let's call that as points
    val points = listOf(sigiriya,diyabeduma,dambulla)

    // Camera position represents the zoom level and the initial position of the bird eye view of google map
    // Zoom level (high) -> Closer to the object  ---> Highest 17f
    // This is a state. So whenever the google map is redrawing the map we are remembering this position.
    val cameraPositionState = rememberCameraPositionState {
        // Camera position contains both initial position and the zoom level
        // initial position will be the center of the application on the screen. And the map will be zoomed around it.
        position = CameraPosition.fromLatLngZoom(colombo, 8f)
    }

    // To change the type of the Map ( Like to Satellite view, Hybrid view etc. )
    // And we need to pass this properties state to the GoogleMap() too.
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }

    // To change some UI settings
    // And we need to pass this uiSettings state to the GoogleMap()
    var uiSettings by remember { mutableStateOf(MapUiSettings()) }

    // We need to create a Box to keep box represented ui components Google Map and Switch
    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Google Map
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings
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
            // To create a polygon we least need 3 points.
            // It we only have 2 point it will be something similar to a line.
            Polygon(
                points = points,
                // We can add more customization too. These codes are in google's documents.
                // Outline color ..
                strokeColor = Color.Blue,
                // Inside fill color
                // Adjusting the transparency to 50%
                fillColor = Color.Black.copy(alpha = 0.5f)
            )
        }
        // 2. Switch
        // This switch will give us the option to remove the zoom in zoom out buttons on the map screen.
        Switch(
            checked = uiSettings.zoomControlsEnabled,
            onCheckedChange = {
                uiSettings = uiSettings.copy(zoomControlsEnabled = it)
            }
        )
    }
}
// We need to add the API key to the AndroidManifest.xml file