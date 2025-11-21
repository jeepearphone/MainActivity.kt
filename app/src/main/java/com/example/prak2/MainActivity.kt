package com.example.prak2

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prak2.ui.theme.AddPrimaryButtonColors
import com.example.prak2.ui.theme.Prak2Theme
import com.example.prak2.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prak2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (modifier = Modifier.padding(innerPadding)){
                        //Task6Fun1()
                        //Task6Fun2()
                        //Task7Fun1("", "", "", "", "")
                        //Task7Fun2()
                        //Task7Fun3()
                        WaterTracker()
                    }
                }
            }
        }
    }
}


@Composable
fun Task6Fun1() {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(color = Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Circle"
        )
    }
}

@Composable
fun Task6Fun2() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(color = Color.Blue)
    ){
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Circle",
            colorFilter = ColorFilter.tint(Purple40),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun Task7Fun1(name : String, thirdName : String, secondName : String, phone : String, adress : String) {
    Column{
        Text(text = "Имя: $name")
        Text("Отчество: $thirdName")
        Text("Фамилия: $secondName")
        Text("Мобильный телефон: $thirdName")
        Text("Адрес: $adress")
    }
}

@Composable
fun Task7Fun2() {
    Column (
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ){
            Task7Fun1("", "fr", "", "", "")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ){
            Task7Fun1("", "vf", "fr", "3", "")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ){
            Task7Fun1("fe", "ds", "das", "das", "das")
        }
    }
}

@Composable
fun Task7Fun3() {
     Box (
         modifier = Modifier
             .padding(10.dp)
             .background(Color.LightGray)
             .fillMaxWidth()
     ){
         Row() {
             Box(
                 contentAlignment = Alignment.Center
             ) {
                 Task7Fun1("Pavel", "Olegovich", "Karelin", "78778987534", "Yerushalaem")
                 Image(
                     painter = painterResource(R.drawable.star),
                     contentDescription = "Star",
                     colorFilter = ColorFilter.tint(Color(0xFFFFA500)),
                     alignment = Alignment.CenterEnd,
                     modifier = Modifier.fillMaxWidth()
                 )
             }
         }
     }
}

@Composable
fun WaterTracker(){
    var waterCount by remember { mutableStateOf(0) }
    var countDays by remember { mutableStateOf(0) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Трекер воды",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.testTag("countWater"),
                text = "$waterCount мл",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                colors = AddPrimaryButtonColors(),
                onClick = { waterCount += 250 }
            ) {
                Text(
                    modifier = Modifier.testTag("plus"),
                    text = "+250 мл",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                colors = AddPrimaryButtonColors(),
                onClick = {
                    if (waterCount >= 1500) {
                        countDays++
                    }
                    else {
                        countDays = 0
                    }
                    waterCount = 0
                }
            ) {
                Text(
                    modifier = Modifier.testTag("endDay"),
                    text = "Завершить день",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.testTag("countDay"),
                text = "Количество дней подряд, в которые было выпито более 1500 мл - $countDays",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}





