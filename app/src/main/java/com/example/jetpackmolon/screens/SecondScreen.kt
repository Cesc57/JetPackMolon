package com.example.jetpackmolon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackmolon.R

val Everest = "El monte Everest es la montaña más alta de la superficie del planeta Tierra," +
        " con una altitud de 8848 metros sobre el nivel del mar."

val K2 =
    "El K2 es una montaña perteneciente a la cordillera del Karakórum, en el sistema de los Himalayas." +
            " Mide 8611 metros de altura, es la segunda montaña más alta de la Tierra, " +
            "tras el monte Everest (8849 m. s. n. m.) y, posiblemente, " +
            "la más difícil de escalar, junto con el Annapurna y el Nanga Parbat."

val Kanchenjunga = "Kanchenjunga se traduce como \"Los cinco tesoros de las nieves\", " +
        "ya que la montaña tiene cinco picos, cuatro de ellos por encima de los 8.450 metros." +
        " Los tesoros representan los cinco repositorios de Dios, que son oro, plata, gemas, cereal y libros sagrados."

val Lhotse = "El Lhotse es la cuarta montaña más alta de la Tierra, " +
        "solo superada por el Everest, el K2 y el Kangchenjunga." +
        " Se halla muy cerca del Everest, con el que queda conectado a través del Collado Sur. " +
        "Lhotse significa literalmente “Pico Sur” en tibetano."

val Makalu =
    "El Makalu es la quinta montaña más alta de la Tierra con una altitud de 8.463 m s. n. m.." +
            " Está situada en la zona Mahalangur del Himalaya a 19 km al sureste del monte Everest, " +
            "en la frontera entre China y Nepal."


@Composable
fun SecondScreen(navController: NavController, text: String?) {
    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = text,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text.toString())
        }
    }) {
        SecondBodyContent(text)
    }
}

@Composable
fun SecondBodyContent(text: String?) {
    Column(modifier = Modifier
        .padding(16.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            when (text) {
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
            }, "Mi imagen",
        )
        Spacer(modifier = Modifier.width(32.dp))
        if (text == "Monte Everest") {
            Text(text = Everest)
        } else if (text == "K2") {
            Text(text = K2)
        } else if (text == "Kanchenjunga") {
            Text(text = Kanchenjunga)
        } else if (text == "Lhotse") {
            Text(text = Lhotse)
        } else if (text == "Makalu") {
            Text(text = Makalu)
        }

    }
}