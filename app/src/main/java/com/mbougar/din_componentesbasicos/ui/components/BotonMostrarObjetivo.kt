package com.mbougar.din_componentesbasicos.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BotonMostrarObjetivo(
    botonHabilitado: Boolean,
    estadosCheckbox: List<Boolean>,
    alSeleccionarObjetivo: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                val indexSeleccionado = estadosCheckbox.indexOfFirst { it }
                alSeleccionarObjetivo(
                    when (indexSeleccionado) {
                        -1 -> ""
                        else -> "Objetivo ${indexSeleccionado + 1}"
                    }
                )
            },
            enabled = botonHabilitado,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Mostrar Objetivo")
        }
    }
}