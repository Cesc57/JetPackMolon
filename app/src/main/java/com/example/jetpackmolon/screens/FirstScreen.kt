package com.example.jetpackmolon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackmolon.R
import com.example.jetpackmolon.navigation.AppScreens

@Composable
fun FirstScreen(navController: NavController) {
    Scaffold (topBar = {
        TopAppBar {
            Text(text = "Mis montes")
        }
    }) {
        BodyContent(navController)

    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Composable
fun MyTexts(message: MyMessage) {

    Column(modifier = Modifier.padding(start = 8.dp)) {

        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1)

        Spacer(modifier = Modifier.height(16.dp))

//        MyText(
//            message.altura,
//            MaterialTheme.colors.primaryVariant,
//            MaterialTheme.typography.subtitle2)
//
//        Spacer(modifier = Modifier.height(16.dp))

        MyText(
            message.cordillera,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle2)


    }

}

@Composable
fun MyImage(title: String, navController: NavController) {

    Image(

        when (title) {
            "Monte Everest" -> {
                painterResource(R.drawable.everest)
            }
            "K2" -> {
                painterResource(R.drawable.ktwo)
            }
            "Kanchenjunga" -> {
                painterResource(R.drawable.kangchenjunga)
            }
            "Lhotse" -> {
                painterResource(R.drawable.lhotse)
            }
            else -> {
                painterResource(R.drawable.makalu)
            }
        },

        "Mi imagen",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp).clickable {
                
                navController.navigate(AppScreens.SecondScreen.route + "/$title")
            }
    
    )
}

@Composable
fun MyComponent(message: MyMessage, navController: NavController) {
    Row(modifier = Modifier
        .padding(8.dp)
        .background(MaterialTheme.colors.background)) {
        MyImage(message.title, navController)
        MyTexts(message)
    }
}

@Composable
fun BodyContent(navController: NavController) {
    LazyColumn{
        items(message){ message ->
            MyComponent(message,navController)
        }
    }
}

private val message: List<MyMessage> = listOf(
    MyMessage("Monte Everest", "Himalaya",
        R.drawable.everest),

    MyMessage(
        "K2", "Karakórum",
        R.drawable.ktwo),

    MyMessage("Kanchenjunga", "Himalaya",
        R.drawable.kangchenjunga),

    MyMessage(
        "Lhotse", "Himalaya",
        R.drawable.lhotse),

    MyMessage(
        "Makalu", "Himalaya",
        R.drawable.makalu)

)

data class MyMessage(
    val title: String, val cordillera: String, val image: Int,
)
