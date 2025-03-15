package uth.edu.bai02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import uth.edu.bai02.ui.theme.Bai02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai02Theme {
                AppNavigation()
                }
        }
    }
}

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController =navController,
        startDestination = "welcome"
    ) {
    composable("welcome"){ WelcomeScreen(navController)}
        composable("components_list1"){ ComponentScreen1(navController)}
        composable("components_list2"){ ComponentScreen2(navController)}
        composable("components_list3"){ ComponentScreen3(navController) }
    }
}
@Composable
fun WelcomeScreen(navController: NavController){
    // Sử dụng LaunchedEffect để kích hoạt hành động sau 10 giây
    LaunchedEffect(Unit) {
        delay(10000) // 10 giây
        navController.navigate("components_list1") // Chuyển sang màn hình danh sách UI Components
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(painterResource(id=R.drawable.image_2), contentDescription = "UTH",
            modifier = Modifier.size(100.dp))
        Spacer(modifier = Modifier.padding(8.dp))
        Text("UTH SmartTasks", fontSize = 40.sp,
            fontWeight = FontWeight.Bold, color = Color.Blue,)
    }
}
@Composable
fun ComponentScreen2(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Indicator (3 dots)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    for (i in 0..2) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(if (i == 1) Color.Blue else Color.LightGray)
                        )
                    }
                }

                // Skip button
                Text(
                    text = "skip",
                    color = Color.Blue,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { navController.navigate("components_list3") },
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.bro),
                contentDescription = "Time Management",
                modifier = Modifier.size(250.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tiêu đề
            Text(
                text = "Increase Work Effectiveness",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Nội dung mô tả
            Text(
                text = "Time management and the determination" +
                        " of more important tasks will give your job" +
                        " statistics better and always improve",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(275.dp)) // Đẩy nút xuống cuối

            Row (modifier = Modifier.fillMaxWidth()) {
               Row(modifier = Modifier.weight(1f)) {  Button(onClick = {navController.navigate("components_list1")},
                   modifier = Modifier.fillMaxWidth().height(56.dp),
                   colors =ButtonDefaults.buttonColors(containerColor = Color.Blue),) {
                   Icon(Icons.Default.ArrowBack, contentDescription = null)
               } }
                Row(modifier = Modifier.weight(4f)){
                    Button(onClick = {navController.navigate("components_list3")}, modifier = Modifier.fillMaxWidth().height(56.dp),
                        colors =ButtonDefaults.buttonColors(containerColor = Color.Blue),) {
                        Text(text = "Next", fontSize = 16.sp, color = Color.White)
                    }
                }
            }
        }

    }
@Composable
fun ComponentScreen3(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Indicator (3 dots)
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                for (i in 0..2) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(if (i == 2) Color.Blue else Color.LightGray)
                    )
                }
            }

            // Skip button
            Text(
                text = "skip",
                color = Color.Blue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { navController.navigate("components_list4") },
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.bro),
            contentDescription = "Time Management",
            modifier = Modifier.size(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tiêu đề
        Text(
            text = "Reminder Notification",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Nội dung mô tả
        Text(
            text = "The advantage of this application is that it" +
                    " also provides reminders for you so you" +
                    " don't forget to keep doing your" +
                    " assignments well and according to the" +
                    " time you have set",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(250.dp)) // Đẩy nút xuống cuối

        Row (modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.weight(1f)) {  Button(onClick = {navController.navigate("components_list2")},
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors =ButtonDefaults.buttonColors(containerColor = Color.Blue),) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            } }
            Row(modifier = Modifier.weight(4f)){
                Button(onClick = {navController.navigate("components_list4")}, modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors =ButtonDefaults.buttonColors(containerColor = Color.Blue),) {
                    Text(text = "Next", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }

}
@Composable
fun ComponentScreen1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Indicator (3 dots)
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                for (i in 0..2) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(if (i == 0) Color.Blue else Color.LightGray)
                    )
                }
            }

            // Skip button
            Text(
                text = "skip",
                color = Color.Blue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { navController.navigate("components_list2") }
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.bro), // Thay bằng ảnh của bạn
            contentDescription = "Time Management",
            modifier = Modifier.size(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tiêu đề
        Text(
            text = "Easy Time Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Nội dung mô tả
        Text(
            text = "With management based on priority and daily tasks, it will give you convenience " +
                    "in managing and determining the tasks that must be done first",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(275.dp)) // Đẩy nút xuống cuối

        Button(onClick = {navController.navigate("components_list2")}, modifier = Modifier.fillMaxWidth().height(56.dp),
            colors =ButtonDefaults.buttonColors(containerColor = Color.Blue),) {
            Text(text = "Next", fontSize = 16.sp, color = Color.White)
        }
    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Bai02Theme {
        AppNavigation()
    }
}