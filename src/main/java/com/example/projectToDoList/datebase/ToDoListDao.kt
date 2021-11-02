package com.example.projectToDoList.datebase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projectToDoList.datebase.model.ItemModel


@Dao
interface ToDoListDao {
    @Insert
    suspend fun addItem(itemModel:ItemModel)


    @Query("SELECT*FROM ItemModel")
    fun getItems():LiveData<List<ItemModel>>

    @Update
    suspend fun updateItem(itemModel: ItemModel)


    @Delete
    suspend fun deleteItem(itemModel: ItemModel)
}