package io.januda.buyer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// This will be the entity for the application
// Entity represents the tables in the Database
// When using ROOM the tables will be automatically created according to entity classes
// We can make this a data class because we use this to hold data
// When we use data classes we can create models without constructors
// data classes are written inside () not {}

// We need to add @Entity here
// Entity represents a table. So give the table name to it.
@Entity(tableName = "items")
data class Item (
    // To uniquely identify something in the database we need an ID
    // We need to annotate a field as a PrimaryKey
    // We can tell the ID to auto generate it's value, So we don't have to think about the uniqueness.
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val price: Double,
    val quantity: Int
)