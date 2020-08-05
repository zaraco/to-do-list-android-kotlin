package com.zaraco.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zaraco.todolist.managers.TaskRepository
import com.zaraco.todolist.models.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val taskRepository = TaskRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBtn?.setOnClickListener {
            addTask(taskEt?.text?.toString())
        }
    }

    private fun addTask(text: String?) {
        val task = Task()
        task.text = text
        taskRepository.add(task)
        Log.i("task", text ?: "")
    }
}