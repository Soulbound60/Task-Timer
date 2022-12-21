package com.example.tasktimer.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tasktimer.Model.Repository
import com.example.tasktimer.Model.TaskDatabase
import com.example.tasktimer.Model.TaskTable

class MainViewModel (application: Application): AndroidViewModel(application) {

    private val repository: Repository
    private val allTasks: LiveData<List<TaskTable>>

    init {
        val taskDao = TaskDatabase.getInstance(application).taskDao()
        repository = Repository(taskDao)
        allTasks = repository.getTasks
    }//end init




}// end VM