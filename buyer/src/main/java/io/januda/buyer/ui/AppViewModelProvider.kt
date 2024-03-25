package io.januda.buyer.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import io.januda.buyer.InventoryApplication
import io.januda.buyer.ui.item.ItemEntryViewModel

object AppViewModelProvider {

    val Factory = viewModelFactory {

//        initializer {
//            ItemEditViewModel (
//                this.createSavedStateHandle()
//            )
//        }

        initializer {
            ItemEntryViewModel()
        }

//        initializer {
//            ItemDetailsViewModel(
//                this.createSavedStateHandle()
//            )
//        }
//
//        initializer {
//            HomeViewModel()
//        }

    }
}

fun CreationExtras.inventoryApplication() : InventoryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)