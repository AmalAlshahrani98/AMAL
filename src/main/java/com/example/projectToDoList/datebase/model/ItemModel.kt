package com.example.projectToDoList.datebase.model

import android.icu.text.CaseMap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemModel (
    var title:String,
    var date:String,
    var description:String,
    var checkbox:Boolean,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0


        )
