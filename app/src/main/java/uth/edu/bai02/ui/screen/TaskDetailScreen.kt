@file:OptIn(ExperimentalMaterial3Api::class)

package uth.edu.bai02.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun TaskDetailScreen(task: Task, navController:NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_2),
                                contentDescription = "Back",
                                modifier = Modifier.size(40.dp).weight(1f).
                                clickable { navController.navigate("home") }
                            )
                            Column {
                                Text("SmartTasks", fontSize = 24.sp)
                                Text("A simple and efficient to-do app", fontSize = 16.sp)
                            }
                            Image(
                                painter = painterResource(id = R.drawable.image_15),
                                contentDescription = "Loa",
                                modifier = Modifier.size(40.dp).weight(1f)
                            )
                        }
                    }
                        },


            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            Text(text = task.title, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = task.description, color = Color.Gray, fontSize = 16.sp)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFD9AAB3)) // Màu nền phù hợp
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(painterResource(id = R.drawable.group_9), contentDescription = null,
                                modifier = Modifier.size(28.dp))
                            Text(text = "Category", fontSize = 16.sp, color = Color.Black)
                            Text(text = task.category, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(painterResource(id = R.drawable.image_9), contentDescription = null,
                                modifier = Modifier.size(28.dp))
                            Text(text = "Status", fontSize = 16.sp, color = Color.Black)
                            Text(text = task.status, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(painterResource(id = R.drawable.image_10), contentDescription = null,
                                modifier = Modifier.size(28.dp))
                            Text(text = "Priority", fontSize = 16.sp, color = Color.Black)
                            Text(text = task.priority, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Subtasks", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            task.subtasks.forEach {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Row {
                        var checked by remember { mutableStateOf(false) }

                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                        Text(
                            text = it.title,
                            modifier = Modifier.padding(8.dp),
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Attachments", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            task.attachments.forEach {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Row {
                        var checked by remember { mutableStateOf(false) }

                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )
                        Text(
                            text = it.fileName,
                            modifier = Modifier.padding(8.dp),
                            fontSize = 14.sp
                        )
                    }

                }
            }
        }
    }
}
