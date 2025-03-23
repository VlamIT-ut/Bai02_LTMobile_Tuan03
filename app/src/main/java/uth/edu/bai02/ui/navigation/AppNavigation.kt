package uth.edu.bai02.ui.navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uth.edu.bai02.ui.screen.GetStartedScreen1
import uth.edu.bai02.ui.screen.GetStartedScreen2
import uth.edu.bai02.ui.screen.GetStartedScreen3
import uth.edu.bai02.ui.screen.SplashScreen
import uth.edu.bai02.viewModel.TaskViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import uth.edu.bai02.ui.screen.TaskDetailScreen
import uth.edu.bai02.ui.screen.TaskListScreen

@Composable
fun AppNavigation(viewModel: TaskViewModel = viewModel()){
    val navController = rememberNavController()
    val taskList by viewModel.taskList
    val errorMessage by viewModel.errorMessage

    LaunchedEffect(Unit) {
        viewModel.fetchTasks()
    }
    NavHost(navController =navController,
        startDestination = "welcome"
    ) {
        composable("welcome"){ SplashScreen(navController) }
        composable("components_list1"){ GetStartedScreen1(navController) }
        composable("components_list2"){ GetStartedScreen2(navController) }
        composable("components_list3"){ GetStartedScreen3(navController) }
        composable("home"){TaskListScreen( navController,taskList)}
        composable("list") {
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = Color.Red, modifier = Modifier.padding(16.dp))
            } else {
                TaskListScreen(navController = navController, taskList = taskList)
            }
        }
        composable("detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            val selectedTask = taskList.find { it.id == taskId }

            if (selectedTask != null) {
                TaskDetailScreen(navController = navController, task = selectedTask)
            } else {
                Text("Task not found", modifier = Modifier.padding(16.dp))
            }
        }
    }
}