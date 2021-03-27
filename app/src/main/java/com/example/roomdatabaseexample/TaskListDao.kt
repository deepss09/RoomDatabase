package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TaskListDao{
    @Query(value =  "SELECT * FROM task WHERE status = :status ORDER BY priority DESC")
    fun getTasksByPriority(status: Int): LiveData<List<Task>>

    @Query(value =  "SELECT * FROM task WHERE status = :status ORDER BY title")
    fun getTasksByTitle(status: Int): LiveData<List<Task>>

}
