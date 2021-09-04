package com.example.eventcademycomposeui.model

import java.io.Serializable

data class PostItem(
    val id: Int,
    val name: String,
    val year: Int,
    val rating: Double,
    val  imageId: Int,
    val overview: String
): Serializable
