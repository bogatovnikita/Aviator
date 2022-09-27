package com.elephant.data.storage

import android.content.Context
import java.io.IOException

class AviatorStorageImplementation(val context: Context) : AviatorStorage {

    override fun get(fileName: String): String {
        var jsonString = ""
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return jsonString
    }
}