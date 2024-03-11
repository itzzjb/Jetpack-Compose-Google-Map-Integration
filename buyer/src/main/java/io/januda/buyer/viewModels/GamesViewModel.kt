package io.januda.buyer.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.januda.buyer.config.ApiService
import io.januda.buyer.models.Game
import kotlinx.coroutines.launch

// View Model is the glue that holds ui and the models together. (Acts as the bridge between the data layer and the view itself)

// In an Android app, you typically use the ViewModel to hold and manage the UI-related data in a way that survives configuration changes (like screen rotations) and is independent of the UI controller lifecycle (like an Activity or Fragment).
// You can use this GamesViewModel to interact with your data sources (such as APIs or databases), process the data, and provide it to your UI components (Fragments or Activities).
// You can also handle user interactions and trigger appropriate actions based on those interactions within this ViewModel.

// GamesViewModel class -> extends ViewModel
class GamesViewModel : ViewModel() {

    // A list that we can add values and remove values as an observable. (This is like a changing variable)
    // _games ->
    // _propertyName is a convention used for naming private properties or local variables.
    // It's a common practice to prefix private properties with an underscore to differentiate them from public properties and to indicate that they are not intended for direct access outside of the class.
    private val _games = mutableStateListOf<Game>()
    // Changes the value of the String according to the error.
    // Mutable state variables are observable properties that can trigger UI updates when their values change
    var error: String by mutableStateOf<String>("")

    //  This line declares a read-only property games of type List<Game>, which provides access to the _games list.
    //  It allows external classes to retrieve the list of games but not modify it directly. ( No Setters only Getter )
    val games : List<Game>
        get() = _games

    //  This function is responsible for fetching games data.
    fun getGames() {
        //  This launches a coroutine within the ViewModel's scope.
        //  Coroutines are used for asynchronous programming in Kotlin.
        viewModelScope.launch{
            // This retrieves an instance of an ApiService, likely used to communicate with a backend server.
            val apiService = ApiService.getInstance()
            // This block attempts to fetch the games data from the API, catching any exceptions that might occur.
            try {
                // This clears the _games list before populating it with fresh data.
                _games.clear()
                // This fetches games data from the API using the getGames() method of apiService and adds it to the _games list.
                _games.addAll(apiService.getGames())
            } catch (e: Exception) {
                // If an exception occurs during the API call, the error message is assigned to the error variable.
                // This will trigger any UI components observing error to update accordingly.
                error = e.message.toString()
            }
        }
    }
}

// Note -

// UI of an Android application is running on the main tread. ( Completely allocated to rendering UIs )
// If we are going to launch something that is going to block the UI it is not running on the main thread.
// It will run on a view model scope.

// UI blocking tasks / Asynchronous task ( Tasks that occur at the same time ) -> These tasks will get completed but we can't guarantee the time it will take.
// While we are waiting that task to be completed, the main thread will be stopped/blocked.
// So inorder to solve this, when we are doing a blocking task -> We are giving it a separate thread.
// Once that task it done it will let know the main thread that it is done.
// So, During that time main thread won't get blocked.
// In kotlin we implement this using coroutines.
// There are many types of coroutines. Here we are using view model scopes.




// For example, If we want to receive API information and the information we want to receive is in another server.
// We need to call the Rest API and the Rest API needs to respond. It's gonna take some time.
// In


