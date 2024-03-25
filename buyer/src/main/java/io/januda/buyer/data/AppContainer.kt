package io.januda.buyer.data

import android.content.Context
// This is like the initiation point of our application
interface AppContainer {
    // We are telling we require a Item repository.
    val itemsRepository: ItemsRepository
}

// The implementation of above AppContainer interface.
class AppDataContainer(private val context: Context) : AppContainer {
    override val itemsRepository: ItemsRepository by lazy {
        // Inside OfflineItemRepository we instantiate the  ItemRepository
        val dao =  InventoryDatabase.getDatabase(context)!!.itemDao()
        OfflineItemsRepository(dao)
    }
}