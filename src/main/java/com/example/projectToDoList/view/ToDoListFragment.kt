package com.example.projectToDoList.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projectToDoList.R
import com.example.projectToDoList.datebase.model.ItemModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class ToDoListFragment : Fragment() {

      private val todolist = mutableListOf<ItemModel>()

      private val toDoViewModel: ToDoViewModel by activityViewModels()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_list_fragment)
        val addButton: FloatingActionButton = view.findViewById(R.id.add_list_button)
        val adapter = ToDoAdapter(todolist,toDoViewModel)

        recyclerView.adapter = adapter

        toDoViewModel.toDoListItems.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            it?.let {

                todolist.clear()
                todolist.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

        addButton.setOnClickListener{


            findNavController().navigate(R.id.action_toDoListFragment_to_toDoAddFragment)

        }



    }
}