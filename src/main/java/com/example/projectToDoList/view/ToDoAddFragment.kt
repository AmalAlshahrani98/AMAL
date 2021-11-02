package com.example.projectToDoList.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projectToDoList.R
import com.example.projectToDoList.datebase.model.ItemModel


class ToDoAddFragment : Fragment() {

     private val toDoViewModel:ToDoViewModel by  activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleEditText : EditText = view .findViewById(R.id.title_add_fragment)
         val dateEditText : EditText = view .findViewById(R.id.date_add_fragment)
         val descriptionEditText: EditText = view .findViewById(R.id.description_add_fragment)
        val addButton: Button = view .findViewById(R.id.Add_button)


        addButton.setOnClickListener {

            val title = titleEditText.text.toString()
            val date = dateEditText.text.toString()
            val description = descriptionEditText.text.toString()

            if (title.isNotEmpty() && date.isNotEmpty() && description.isNotEmpty()){
                toDoViewModel.addItem(ItemModel(title,date,description,false))
                findNavController().popBackStack()
            }

        }
    }

}