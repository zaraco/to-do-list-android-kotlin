package com.zaraco.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaraco.todolist.managers.TaskRepository
import com.zaraco.todolist.models.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val taskRepository = TaskRepository()

    private var adapter: TaskAdapter? = null
    private var layoutManager: LinearLayoutManager? = null

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
        clearTaskInput()
        Log.i("task", text ?: "")
        showTasks(taskRepository.tasks)
    }

    private fun clearTaskInput() {
        taskEt?.text = null
    }

    private fun showTasks(tasks: List<Task>) {
        adapter = TaskAdapter(this, tasks)
        recyclerView?.adapter = adapter
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
    }
}