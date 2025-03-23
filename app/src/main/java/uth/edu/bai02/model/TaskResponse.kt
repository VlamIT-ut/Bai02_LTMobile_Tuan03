package uth.edu.bai02.model

data class TaskResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task>
)
