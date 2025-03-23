package uth.edu.bai02.ui.screen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uth.edu.bai02.R

@Composable
fun SplashScreen(navController: NavController){
    // Sử dụng LaunchedEffect để kích hoạt hành động sau 10 giây
    LaunchedEffect(Unit) {
        delay(10000) // 10 giây
        navController.navigate("components_list1") // Chuyển sang màn hình danh sách UI Components
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(
            painterResource(id= R.drawable.image_2), contentDescription = "UTH",
            modifier = Modifier.size(100.dp))
        Spacer(modifier = Modifier.padding(8.dp))
        Text("UTH SmartTasks", fontSize = 40.sp,
            fontWeight = FontWeight.Bold, color = Color.Blue,)
    }
}