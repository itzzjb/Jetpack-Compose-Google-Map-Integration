package io.januda.buyer.data

import kotlinx.coroutines.flow.Flow

// Repository is something similar to Dao
// But in repository layer we will have a more abstract layer on top of Dao layer
// Repository is here for making some abstractions for the calls we do for the database.
// We don't directly call Dao and get things done.

// When we interacting with the application, the UI will be interacting with the repository.
// The Dao layer can be changed anytime. Repository layer won't change.
// Anytime in a scenario like, we are getting away from ROOM and find another alternative having a abstract layer will make the transition smooth.
// Because even if we delete the Dao layer the UI will not be affected because it is directly in contact with repository layer.

// This should be a repository
// This should map all the values we see in the Dao (One to one mapping)
interface ItemsRepository {

    fun getAllItemStream(): Flow<List<Item>>

    fun getItemStream(id: Int): Flow<Item?>

    suspend fun insertItem(item: Item)

    suspend fun deleteItem(item: Item)

    suspend fun updateItem(item: Item)

}