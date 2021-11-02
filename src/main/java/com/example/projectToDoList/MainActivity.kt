package com.example.projectToDoList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectToDoList.repostories.ToDoListRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ToDoListRepository.init(this)

    }
}