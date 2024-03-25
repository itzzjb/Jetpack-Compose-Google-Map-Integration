package io.januda.buyer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// DAO - Data Access Object
// This is similar to Repository in Spring-boot
// We need dao inorder to access and interact (CRUD operations) with a database.
// This is like the executor of our application

// This should not be a class. It should be an interface.
// We need to annotate this with @Dao
@Dao
interface ItemDao {

    // We need to use suspend functions here.

    // In Jetpack Compose, a suspend function is a function that can pause and resume execution at certain points.
    // This type of function is used for operations that may take some time to complete, such as fetching data from a network or reading from a database.
    // When you call a suspend function, it can pause execution until the operation is finished, without blocking the main thread of your app.
    // This helps keep your UI responsive and smooth. You can identify suspend functions in Jetpack Compose by the 'suspend' keyword before their declaration.

    // Conflicts might occur when we are dealing with a database
    // ex - We can't have two items with the same id
    // So, We need to do conflict handling
    // We need to tell what action should be taken in an event of a conflict
    //      Abort: Stop the operation entirely if there's a conflict.
    //      Ignore: Proceed with the operation, ignoring any conflicts.
    //      None: Do nothing in response to conflicts, leaving it to the developer to handle them.
    //      Replace: Replace conflicting data with the new data being provided.
    //      Fail: Immediately stop the operation and raise an error if there's a conflict.
    //      Rollback: Undo the changes made by the operation if there's a conflict, reverting to the previous state.

    // We need to tell that this is an insert function
    // So we need to add the @Insert annotation
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    // We need to tell that this is an update function
    // So we need to add the @Update annotation
    @Update
    suspend fun update(item: Item)


    @Delete
    suspend fun delete(item: Item)

    // When you need to use custom queries
    // :id -> given Id ( id that comes as a parameter for the getItem method )
    // Called "binding"
    @Query("SELECT * FROM items WHERE id = :id")
    // Wrapped with FLOW
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * FROM items ORDER BY name ASC")
    // Wrapped with FLOW
    fun getAllItems(): Flow<List<Item>>

}