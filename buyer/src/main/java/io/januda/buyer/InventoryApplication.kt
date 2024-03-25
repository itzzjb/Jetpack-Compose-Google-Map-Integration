package io.januda.buyer

import android.app.Application
import io.januda.buyer.data.AppContainer
import io.januda.buyer.data.AppDataContainer

class InventoryApplication : Application() {

    // We create a AppContainer instance
    private lateinit var  container: AppContainer

    override fun onCreate() {
        super.onCreate()
        // A App data container will be assigned here
        // context -> The place we are calling our application
        container = AppDataContainer(this)
    }

}