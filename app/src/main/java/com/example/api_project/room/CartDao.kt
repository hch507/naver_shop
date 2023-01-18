package com.example.api_project.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CartDao {
    @Insert
    fun inset(cartItem: CartItem)

    @Query("SELECT * FROM CartItem") // 테이블의 모든 값을 가져와라
    fun getAll(): List<CartItem>


}