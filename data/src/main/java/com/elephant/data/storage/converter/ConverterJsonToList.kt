package com.elephant.data.storage.converter

import android.content.Context
import com.elephant.data.storage.AviatorStorage
import java.io.IOException

class ConverterJsonToList(val context: Context) : AviatorStorage {

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