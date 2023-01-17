package com.example.api_project.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface CartDao {
    @Insert
    fun inset(cartItem: CartItem)

    @Update
    fun select(cartItem: CartItem)


}