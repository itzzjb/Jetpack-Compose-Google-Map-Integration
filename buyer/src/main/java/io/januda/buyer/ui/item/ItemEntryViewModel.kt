package io.januda.buyer.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.januda.buyer.data.Item

// Because this is a viewmodel in should be extended by a ViewModel class.
// This class is created similar to GameViewModel class.
class ItemEntryViewModel : ViewModel() {

    // Current UI state will be held here.
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    // We don't expose the states to outside.
    // So, we use functions like this to work with it.
    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =  ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            // Whenever we are getting a ItemDetail we are checking whether that UI state has all of these attributes entered.
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }

}


// We need to create a UI state here.
// Within our application we need to maintain the current values of the view.
// We need to keep track on what things have changed in the UI.
data class ItemUiState(
    // Within a given UI state we will have the ItemDetails
    val itemDetails: ItemDetails =  ItemDetails(),
    val isEntryValid: Boolean = false
)

// This is very similar to Item entity class. ( But not the exact representation )
// You can use Item entity class instead of this. But it is not good.
// This is in the UI layer.
// But , entity class is in the data layer. It is purely about data accessing and Database.
// We have to keep them separate
// And also if we want to do some changes to the data in the database and display or do some changes to the inputted data from the ui and save to the database, we need to keep these separate.
// ex - first name + last name ---> username
data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)

// We need to convert ItemDetails into Item (entity)
fun ItemDetails.toItem(): Item = Item (
    id = id,
    name = name,
    // To change the string value into Double
    // If the String is empty the value will be 0.0
    price = price.toDoubleOrNull() ?: 0.0,
    // To change the string value into Int
    // If the String is empty the value will be 0
    quantity = quantity.toIntOrNull() ?: 0

)

// We need to convert ItemDetails into Item (entity)
fun Item.toItemDetails(): ItemDetails = ItemDetails (
    id = id,
    name = name,
    // To change the Double value into String
    price = price.toString(),
    // To change the Int value into String
    quantity = quantity.toString()
)