package com.example.roomdatabaseexample

import android.app.Application
import androidx.lifecycle.LiveData


class TaskListRepository(context: Application){
    private val taskListDao: TaskListDao = TaskDatabase.getDatabase(context).TaskListDao()

    fun getTasks(sort: SortColumn = SortColumn.Priority
    ): LiveData<List<Task>> {
        return if(sort == SortColumn.Priority){
            taskListDao.getTasksByPriority(TaskStatus.Open.ordinal)
        } else{
            taskListDao.getTasksByTitle(TaskStatus.Open.ordinal)
        }


    }
}