@file:OptIn(ExperimentalMaterial3Api::class)

package uth.edu.bai02.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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

@Composable
fun TaskDetailScreen(task: Task, navController:NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center)
                    {
                    Text("Detail", fontWeight = FontWeight.Bold) }
                        },
                navigationIcon = {
                    IconButton(onClick ={navController.popBackStack() }) {
                        Image(painterResource(id = R.drawable.image_2), contentDescription = "Back",
                            modifier = Modifier.size(40.dp))
                    }
                },


            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            Text(text = task.title, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = task.description, color = Color.Gray, fontSize = 16.sp)

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Subtasks", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            task.subtasks.forEach {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Text(
                        text = it.title,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 14.sp
                    )
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
                    Text(
                        text = it.fileName,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 14.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Reminders", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            task.reminders.forEach {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Text(
                        text = it.time,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 14.sp
                    )
                    Text(
                        text = it.type,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
