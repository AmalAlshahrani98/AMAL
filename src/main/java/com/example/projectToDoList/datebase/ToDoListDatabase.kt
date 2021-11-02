package com.example.projectToDoList.datebase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projectToDoList.datebase.model.ItemModel

@Database(entities = [ItemModel::class],version = 1)
abstract class ToDoListDatabase :RoomDatabase(){
    abstract fun toDoListDao(): ToDoListDao
}
