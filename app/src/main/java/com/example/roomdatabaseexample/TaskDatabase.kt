package com.example.roomdatabaseexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun TaskListDao(): TaskListDao
    abstract fun TaskDetailDao(): TaskDetailDao

    companion object{
        @Volatile
        private var instance:TaskDatabase?=null

        fun getDatabase(context: Context) = instance
            ?: synchronized(lock = this){
               Room.databaseBuilder(
                   context.applicationContext,
                   TaskDatabase::class.java,
                   "task_database"
               ).build().also { instance = it }
        }
    }
}