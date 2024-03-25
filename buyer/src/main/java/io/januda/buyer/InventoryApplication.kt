package io.januda.buyer

import android.app.Application
import io.januda.buyer.data.AppContainer
import io.januda.buyer.data.AppDataContainer

class InventoryApplication : Application() {

    private lateinit var  container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}