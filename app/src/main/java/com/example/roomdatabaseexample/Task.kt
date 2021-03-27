package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Entity
import androidx.room.PrimaryKey
enum class SortColumn{
Tilte,Priority
}
enum class TaskStatus{
Open, Closed
}
enum class PriorityLevel{
    Low,Medium,High
}
@Entity(tableName = "task")
data class Task(@PrimaryKey(autoGenerate = true)val id:Long,
                val title:String,
                 val detail:String,
                 val priority:Int,
                  val status:Int)
