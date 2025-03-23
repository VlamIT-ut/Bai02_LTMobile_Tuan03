@file:OptIn(ExperimentalMaterial3Api::class)

package uth.edu.bai02.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uth.edu.bai02.R
import uth.edu.bai02.model.Task
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun TaskListScreen(navController: NavController, taskList: List<Task>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {  Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,){
                        Image(painterResource(id = R.drawable.image_2),
                            contentDescription = "Back",
                            modifier = Modifier.size(40.dp).weight(1f))
                        Column{
                            Text("SmartTasks", fontSize = 24.sp)
                            Text("A simple and efficient to-do app", fontSize = 16.sp)
                        }
                        Image(painterResource(id = R.drawable.image_17),
                            contentDescription = "Loa",
                            modifier = Modifier.size(40.dp).weight(1f))

                    }
                } },

            )
        },
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        if (taskList.isEmpty()) {
            EmptyTaskScreen()
        } else {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(taskList) { task ->
                    TaskItem(task = task, onClick = {
                        navController.navigate("detail/${task.id}") // Chuyển sang màn hình chi tiết
                    })
                }
            }
        }
    }
}


@Composable
fun TaskItem(task: Task, onClick: () -> Unit) {
    val backgroundColor = when (task.priority) {
        "High" -> Color(0xFFFFCDD2)  // Đỏ nhạt
        "Medium" -> Color(0xFFFFF9C4) // Vàng nhạt
        "Low" -> Color(0xFFC8E6C9)   // Xanh lá nhạt
        else -> Color(0xFFBBDEFB)     // Xanh dương nhạt
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(backgroundColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(modifier = Modifier.weight(1f)) {
                Text(text = task.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = task.description, color = Color.Gray, fontSize = 14.sp)
            }
//

        }
    }
}
@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { /* TODO: Handle click */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Add, contentDescription = "Add") },
            label = { Text("Add") },
            selected = false,
            onClick = { /* TODO: Handle click */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = false,
            onClick = { }
        )
    }
}



