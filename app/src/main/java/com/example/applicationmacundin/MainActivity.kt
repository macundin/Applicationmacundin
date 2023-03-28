package com.example.applicationmacundin

import android.graphics.Color.parseColor
import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applicationmacundin.ui.theme.ApplicationmacundinTheme
import java.text.SimpleDateFormat
import java.util.Date


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationmacundinTheme {
                MyApp()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MyApp(){
    ListadoEventos()
}

@Composable
fun ListadoEventos(){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(listadoEventos){
            Tarjet(evento = it)
        }
    }

}

@Composable
fun Tarjet(evento:Evento){
    var isFavorite by remember{
        mutableStateOf(false)
    }
    Card(elevation = 6.dp, shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
    Row(modifier = Modifier.fillMaxSize()){
        
        Image(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            painter = painterResource(id = evento.img), contentDescription =null,
            contentScale = ContentScale.Crop)

        Column(modifier = Modifier
            .fillMaxSize()
            .weight(2f)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = evento.nombreEvento, style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.ExtraBold, maxLines = 1
            )
            Text(text = evento.descripcionEvento,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 3
            )

            //AÑADIR FECHA

            Icon(modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    isFavorite = !isFavorite
                },
            imageVector =if(isFavorite)Icons.Default.Favorite else
                Icons.Default.FavoriteBorder, contentDescription = null,
                tint = if(isFavorite) "#F55455".color else Color.Black
            )

        }
    }
    }
}

data class Evento(val nombreEvento:String, val descripcionEvento:String,val img:Int, val diaEvento:Date)
val listadoEventos = listOf(
    Evento("Cumple Marcos","Es el cumpleaños de mi gran amigo Marcos",R.drawable.tarta_cumple,SimpleDateFormat("dd/MM/yyyy").parse("30/03/2023")) ,
    Evento("Asado finca","Es hora de realizar una cena de clase en el asado de TU FINCA DE CONFIANZA",R.drawable._0fcbaa4a048ff5dd2557c9a83a32a80,SimpleDateFormat("dd/MM/yyyy").parse("30/03/2023")) ,
    Evento("Cumple Marcos","Es el cumpleaños de mi gran amigo Marcos",R.drawable.tarta_cumple,SimpleDateFormat("dd/MM/yyyy").parse("30/03/2023")) ,
    Evento("Asado finca","Es hora de realizar una cena de clase en el asado de TU FINCA DE CONFIANZA",R.drawable._0fcbaa4a048ff5dd2557c9a83a32a80,SimpleDateFormat("dd/MM/yyyy").parse("30/03/2023")) ,
    Evento("Cumple Marcos","Es el cumpleaños de mi gran amigo Marcos",R.drawable.tarta_cumple,SimpleDateFormat("dd/MM/yyyy").parse("30/03/2023")) ,
    Evento("Asado finca","Es hora de realizar una cena de clase en el asado de TU FINCA DE CONFIANZA",R.drawable._0fcbaa4a048ff5dd2557c9a83a32a80,SimpleDateFormat("dd/MM/yyyy").parse("30/03/2023")) ,
    )
val String.color
    get()=Color(parseColor(this))
