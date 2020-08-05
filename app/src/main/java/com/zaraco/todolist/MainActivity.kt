package com.zaraco.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zaraco.todolist.managers.TaskRepository
import com.zaraco.todolist.models.Task

class MainActivity : AppCompatActivity() {

    val taskRepository = TaskRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addTask(text: String) {
        val task = Task()
        task.text = text
        taskRepository.add(task)
    }
}