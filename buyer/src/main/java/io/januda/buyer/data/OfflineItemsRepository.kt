package io.januda.buyer.data

import kotlinx.coroutines.flow.Flow

// This is the implementation of ItemsRepository interface

// We need to provide a ItemDao instance whenever we need to create a instance of OfflineItemsRepository.
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {

    /*
    override fun getAllItemStream(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }
    */

    // You can implement the above statement like below.
    override fun getAllItemStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)

}