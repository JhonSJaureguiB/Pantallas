package com.example.pantallas.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
var personas: MutableList<persona> = mutableListOf()
@Composable

fun ScreenB(navController: NavController, name: String?, lastName: String?, age: String?) {
    val newPerson = persona(name.toString(), lastName.toString(), age.toString())

    if (!personas.contains(newPerson)) {
        personas.add(newPerson)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cabecera de la tabla
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(0.9f).border(BorderStroke(1.dp, Color.Black),
                        RoundedCornerShape(8.dp)
                    ),
                    horizontalArrangement = Arrangement.SpaceEvenly,


                ) {
                    Text(
                        text = "Nombre",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Apellido",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Edad",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                }
            }
            items(personas.size) { index ->
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(0.9f).border(BorderStroke(0.5.dp, Color.Black), RoundedCornerShape(8.dp)),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = personas[index].nombre.capitalize(),
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                    Text(
                        text = personas[index].apellido.capitalize(),
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                    Text(
                        text = personas[index].edad,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                }
            }

        }
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Volver a Pantalla A")
        }
    }
}