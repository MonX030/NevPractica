package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaMenuDesplegable()
            }
        }
    }
}

@Composable
fun PantallaMenuDesplegable() {
    var expandido by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("") }

    val opcionUno = stringResource(R.string.opcion_uno)
    val opcionDos = stringResource(R.string.opcion_dos)
    val opcionTres = stringResource(R.string.opcion_tres)

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text(
            text = if (resultado.isEmpty()) stringResource(R.string.texto_inicial)
            else stringResource(R.string.elegiste, resultado),
            style = MaterialTheme.typography.titleMedium
        )

        Box(modifier = Modifier.padding(top = 16.dp)) {
            Button(onClick = { expandido = true }) {
                Text(stringResource(R.string.abrir_menu))
            }
            DropdownMenu(
                expanded = expandido,
                onDismissRequest = { expandido = false }
            ) {
                DropdownMenuItem(
                    text = { Text(opcionUno) },
                    onClick = { resultado = opcionUno; expandido = false }
                )
                DropdownMenuItem(
                    text = { Text(opcionDos) },
                    onClick = { resultado = opcionDos; expandido = false }
                )
                DropdownMenuItem(
                    text = { Text(opcionTres) },
                    onClick = { resultado = opcionTres; expandido = false }
                )
            }
        }
    }
}