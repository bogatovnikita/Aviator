package com.elephant.data.storage.models

data class InfoModel(
    val images: Set<String>,
    val texts: List<TextModel>,
    var title: String = "",
    var id: Int = 0
)

data class TextModel(
    val text: String,
    val isHeader: Boolean = false
)