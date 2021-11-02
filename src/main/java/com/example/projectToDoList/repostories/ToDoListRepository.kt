package com.example.projectToDoList.repostories

import android.content.Context
import androidx.room.Room
import com.example.projectToDoList.datebase.ToDoListDatabase
import com.example.projectToDoList.datebase.model.ItemModel
import java.lang.Exception

private const val DATABASE_NAME = "todolist_database"

class ToDoListRepository(context: Context) {

    private val database :ToDoListDatabase =
        Room.databaseBuilder(
            context,
            ToDoListDatabase::class.java,
            DATABASE_NAME

        ).fallbackToDestructiveMigration().build()

         private val toDoListDao = database.toDoListDao()

    fun getItems() = toDoListDao.getItems()

    suspend fun addItem(itemModel: ItemModel) = toDoListDao.addItem(itemModel)
    suspend fun updateItem(itemModel: ItemModel) = toDoListDao.updateItem(itemModel)
    suspend fun deleteItem(itemModel: ItemModel) = toDoListDao.deleteItem(itemModel)

    companion object{
        private var instance :ToDoListRepository? =null

        fun init(context: Context){
            if (instance == null)
                instance = ToDoListRepository(context)



            }

        fun get():ToDoListRepository{
            return instance ?: throw Exception("ToDoListRepository must be initialized")
        }
    }
}