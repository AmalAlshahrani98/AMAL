package com.example.projectToDoList.view

import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projectToDoList.R
import com.example.projectToDoList.datebase.model.ItemModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ToDoAdapter
    (val items:List<ItemModel>,val viewModel: ToDoViewModel):
        RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapter.ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.itemlayout,parent,false

            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item =items[position]
        var date:LocalDate = LocalDate.now()


        var currentDate = Date()
        val format = SimpleDateFormat("yyyy/MM/dd")
        val stringasdate=format.parse(item.date)
       holder.textView.text = item.title

        if(currentDate > stringasdate)
        {
            holder.textView.setTextColor(Color.RED)
        }

        holder.checkBox.isChecked = item.checkbox
        holder.delete.setOnClickListener{
            viewModel.deleteItem(item)
            notifyDataSetChanged()
        }



        holder.itemView.setOnClickListener {
            viewModel.selectedItemMutableLiveData.postValue(item)
            it.findNavController().navigate(R.id.action_toDoListFragment_to_toDoDetailsFragment)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }





    class ToDoViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.textView_layout)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox_item_layout)
        val delete:ImageView = view.findViewById(R.id.delete_list_layout)
//        val edit :ImageView = view.findViewById(R.id.edit_list_layout)
    }
        }

