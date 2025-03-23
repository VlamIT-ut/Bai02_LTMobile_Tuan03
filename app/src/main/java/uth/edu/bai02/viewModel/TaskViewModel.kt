package uth.edu.bai02.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import uth.edu.bai02.api.TaskApiService
import uth.edu.bai02.model.Task

class TaskViewModel : ViewModel() {
    private val apiService = TaskApiService.instance

    var taskList = mutableStateOf<List<Task>>(emptyList())
    var errorMessage = mutableStateOf("")

    fun fetchTasks() {
        viewModelScope.launch {
            try {
                val response = apiService.getTasks()
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.isSuccess) {
                            taskList.value = it.data
                        } else {
                            errorMessage.value = "API Error: ${it.message}"
                        }
                    }
                } else {
                    errorMessage.value = "Server Error: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage.value = "Network Error: ${e.message}"
            }
        }
    }
}
