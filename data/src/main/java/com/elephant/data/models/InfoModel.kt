package com.elephant.data.models

import java.io.Serializable


@kotlinx.serialization.Serializable
data class InfoModel(
    val images: Set<String>,
    val texts: List<TextModel>,
    var title: String = "",
    var id: Int = 0
) : Serializable

@kotlinx.serialization.Serializable
data class TextModel(
    val text: String,
    val isHeader: Boolean = false
) : Serializable