package com.example.api_project.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartItem (

    val cart_title: String?,
    @PrimaryKey val link :String,
    val cart_image: String?,
    val cart_category1: String?,
    val cart_category2: String?

    )