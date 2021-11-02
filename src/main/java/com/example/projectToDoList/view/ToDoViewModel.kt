package com.example.projectToDoList.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectToDoList.datebase.model.ItemModel
import com.example.projectToDoList.repostories.ToDoListRepository
import kotlinx.coroutines.launch

class ToDoViewModel:ViewModel() {
    private val  toDoListRepository = ToDoListRepository.get()

       var toDoListItems = toDoListRepository.getItems()

       var selectedItemMutableLiveData = MutableLiveData<ItemModel>()


       fun addItem(itemModel: ItemModel){
           viewModelScope.launch {
               toDoListRepository.addItem(itemModel)
           }
       }
    fun updateItem(itemModel: ItemModel){
        viewModelScope.launch {
            toDoListRepository.updateItem(itemModel)
        }
    }
    fun deleteItem(itemModel: ItemModel){
        viewModelScope.launch {
            toDoListRepository.deleteItem(itemModel)
        }
    }
}

