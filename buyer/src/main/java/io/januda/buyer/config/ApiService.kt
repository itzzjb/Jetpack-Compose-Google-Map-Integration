package io.januda.buyer.config

import io.januda.buyer.models.Game
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory


// First thing we need to add the Base URL of the API as the starting point of the application.
// For the base URL we only need the link until .../api/
const val BASE_URL = "https://www.freetogame.com/api/"

// This is an interface class.
interface ApiService {

    // In Jetpack Compose, a suspend function is a function that can pause and resume execution at certain points.
    // This type of function is used for operations that may take some time to complete, such as fetching data from a network or reading from a database.
    // When you call a suspend function, it can pause execution until the operation is finished, without blocking the main thread of your app.
    // This helps keep your UI responsive and smooth. You can identify suspend functions in Jetpack Compose by the 'suspend' keyword before their declaration.

    // We need to annotate that this is a GET request
    // The annotations comes from retrofit
    // calls BASE_URL/games
    @GET("games")
    suspend fun getGames() : List<Game>

    // Companion Object ->
    // In Kotlin, a companion object is a special kind of object that is tied to a class rather than to instances of the class.
    // It allows you to define methods and properties that can be accessed directly via the class name, similar to static members in Java.
    // You can give a companion object a name as well
    // In summary, companion objects in Kotlin provide a way to organize utility functions and properties related to a class, allowing you to access them conveniently without needing an instance of the class.

    companion object {

        // declaring a variable named apiService of type ApiService that can be nullable.
        // In Kotlin, the ? after the type indicates that the variable can hold a null value.
        private var apiService: ApiService? = null
        fun getInstance() : ApiService {
            // Here we are using the singleton design pattern.
            // We only instantiate an object of this class if that class doesn't exist.
                if(apiService == null) {

                    // Here we are using the builder design pattern.
                    apiService = Retrofit.Builder()
                        // We need to add the base url and the converter to the apiService object
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(ApiService::class.java)

                    //Retrofit.Builder() creates a new instance of Retrofit.Builder.
                    //.baseUrl(BASE_URL) sets the base URL for the API endpoints.
                    //.addConverterFactory(GsonConverterFactory.create()) adds a converter factory for serialization and deserialization of JSON payloads using Gson.
                    //.build() constructs the Retrofit instance with the specified configurations.
                    //.create(ApiService::class.java) creates an implementation of the ApiService interface using the configured Retrofit instance.

                }

            //  apiService!! asserts that apiService is not null, and if it is, it will throw a NullPointerException.
            //So essentially, this line of code returns apiService if it's not null, and if it is null, it throws an exception.
            return apiService!!;
        }

    }
}

// Note -

// var vs val -
// val: Declares a read-only variable (immutable). Once initialized, its value cannot be changed. It's similar to declaring a final variable in Java.
// var: Declares a mutable variable. Its value can be reassigned after initialization.
// It's generally recommended to use val whenever possible, as it promotes immutability, which can lead to safer and more predictable code.
// Use var only when you actually need to mutate the variable's value.
