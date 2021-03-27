package com.example.roomdatabaseexample

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.app.Person.fromBundle
import androidx.core.content.ContextCompat
import androidx.media.AudioAttributesCompat.fromBundle
import kotlinx.android.synthetic.main.fragment_task_detail.*


class TaskDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val priorities = mutableListOf<String>()
        PriorityLevel.values().forEach { priorities.add(it.name)}
        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, priorities)
        task_priority.adapter = arrayAdapter

        task_priority?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateTaskPriorityView(position)
            }
        }
        val id = TaskDetailFragmentArgs.fromBundle(requireArguments()).id
    }

    private fun updateTaskPriorityView(priority: Int){
        when(priority){
            PriorityLevel.High.ordinal ->{
                task_priority_view.setBackgroundColor(
                    ContextCompat.getColor(requireActivity(), R.color.colorPriorityHigh))
            }
            PriorityLevel.Medium.ordinal ->{
                task_priority_view.setBackgroundColor(
                    ContextCompat.getColor(requireActivity(), R.color.colorPriorityMedium))
            }
            else ->  task_priority_view.setBackgroundColor(
                ContextCompat.getColor(requireActivity(), R.color.colorPriorityLow))
        }
    }
}

