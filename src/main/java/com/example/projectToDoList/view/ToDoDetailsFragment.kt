package com.example.projectToDoList.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.projectToDoList.R
import com.example.projectToDoList.datebase.model.ItemModel


class ToDoDetailsFragment : Fragment() {

    private val toDoViewModel: ToDoViewModel by activityViewModels()
    private lateinit var selectedItem: ItemModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView : EditText = view .findViewById(R.id.title_details_fragment)
        val dateTextView : EditText = view .findViewById(R.id.date_details_fragment)
        val descriptionTextView : EditText = view .findViewById(R.id.ddescription_details_fragment)
        val  deleteButton : Button = view .findViewById(R.id.delete_button)
        val editButton : Button = view .findViewById(R.id.edit_fragment)




        toDoViewModel.selectedItemMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { item ->
                titleTextView.setText( item.title)
                dateTextView.setText( item .date)
                descriptionTextView.setText(item .description)
                selectedItem = item


            }
        })
            deleteButton.setOnClickListener {
                toDoViewModel.deleteItem(selectedItem)
                findNavController().popBackStack()
            }

             editButton.setOnClickListener {

                 val title = titleTextView.text.toString()
                 val date = dateTextView.text.toString()
                 val description = descriptionTextView.text.toString()

                 selectedItem.title = title
                 selectedItem.date = date
                 selectedItem.description = description

                 toDoViewModel.updateItem(selectedItem)
                 findNavController().popBackStack()
             }
        }
    }

