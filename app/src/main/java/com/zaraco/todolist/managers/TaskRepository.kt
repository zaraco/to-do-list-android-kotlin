package com.zaraco.todolist.managers

import com.zaraco.todolist.models.Task

class TaskRepository {

    val tasks: MutableList<Task> = ArrayList()

    fun add(task: Task) {
        tasks.add(task)
    }
}