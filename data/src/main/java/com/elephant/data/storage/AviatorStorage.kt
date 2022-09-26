package com.elephant.data.storage

interface AviatorStorage {
    fun get(fileName: String): String
}