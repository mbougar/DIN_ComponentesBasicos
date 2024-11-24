package com.mbougar.din_componentesbasicos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListaCheckboxes(
    estadosCheckbox: List<Boolean>,
    alCambiarEstadoCheckbox: (Int, Boolean) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        estadosCheckbox.forEachIndexed { index, estaMarcado ->
            FilaCheckbox(
                texto = "Objetivo ${index + 1}",
                estaMarcado = estaMarcado,
                alCambiarEstado = { alCambiarEstadoCheckbox(index, it) }
            )
        }
    }
}