package io.januda.buyer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// We need to configure the database ( Create a DB connection )
// Database doesn't run within the application itself. It will be running in a Sandbox environment.
// Database will be in a separate location that is dedicated to the application instance ( Here buyer application )

// This should be an abstract class
// We need to extend this class from RoomDatabase()
// We need to have the @Database here
// We need to provide the entities that are in the database here. Provide all in this array.
// And there might be migrations of the databases in the future. So we need to give the version.
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    // Now we need to include all our DAO s
    // We will have a function called itemDao() that will be use to access ItemDao
    abstract fun itemDao(): ItemDao

    // Now we need to make the database connection.
    // We need to think about that there should be only one single database connection through the application.
    // Because,
    // 1. Database connectivity is considered as a resource consuming operation. Making a connection with a database required significant amount of resources.
    // 2. Also databases have a limited number of concurrent connections it can have at a time.

    // So , we use Singleton design pattern
    // For that we need to use companion objects in Kotlin

    companion object {
        // We need to add the @Volatile
        // It will prevent the the access for the database from multiple coroutines or threads at a time. (Concurrently)
        // The instance will be available for one thread or coroutine at a time.
        // When it's done the next tread or coroutine will get a chance.
        @Volatile
        private var Instance: InventoryDatabase? = null

        // Now we will implement the Singleton pattern here.
        // Context -> From where we are accessing the Database ? / Who's responsible for calling this ?
        fun getDatabase(context: Context): InventoryDatabase? {
            // If the Instance is not null, return it, otherwise create a new database instance.
            // synchronized(lock) -> If two threads or coroutines are trying to access this getDatabase method it want allow. Only allows a single one.
            return Instance ?: synchronized(this) {

                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                   // The builder pattern is used here
                    .build()
                    // The variables will be automatically names as "it" when instantiating.
                    .also { Instance = it }
            }
        }

    }

}