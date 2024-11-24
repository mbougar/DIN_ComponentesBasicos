package com.mbougar.din_componentesbasicos.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.mbougar.din_componentesbasicos.ui.components.BotonMostrarObjetivo
import com.mbougar.din_componentesbasicos.ui.components.CampoTextoObjetivo
import com.mbougar.din_componentesbasicos.ui.components.FilaCambioTema
import com.mbougar.din_componentesbasicos.ui.components.FilaHabilitarBoton
import com.mbougar.din_componentesbasicos.ui.components.ListaCheckboxes

@Composable
fun PantallaPrincipal(
    esModoOscuro: Boolean,
    alCambiarTema: (Boolean) -> Unit
) {
    Scaffold { paddingValues ->
        var botonHabilitado by rememberSaveable { mutableStateOf(true) }
        var objetivoSeleccionado by rememberSaveable { mutableStateOf("") }
        // Referencia de uso: https://stackoverflow.com/questions/68885154/using-remembersaveable-with-mutablestatelistof
        val estadosCheckbox: MutableList<Boolean> = rememberSaveable(
            saver = listSaver<MutableList<Boolean>, Boolean> (
                save = { it.toList() },
                restore = { it.toMutableStateList() }
            )
        ) {
            mutableStateListOf(false, false, false)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                FilaCambioTema(
                    esModoOscuro = esModoOscuro,
                    alCambiarTema = alCambiarTema
                )
            }
            item {
                ListaCheckboxes(
                    estadosCheckbox = estadosCheckbox,
                    alCambiarEstadoCheckbox = { index, value ->
                        estadosCheckbox[index] = value
                    }
                )
            }
            item {
                CampoTextoObjetivo(objetivoTexto = objetivoSeleccionado)
            }
            item {
                FilaHabilitarBoton(
                    botonHabilitado = botonHabilitado,
                    alCambiarHabilitacion = { habilitado ->
                        botonHabilitado = habilitado
                        if (!habilitado) objetivoSeleccionado = ""
                    }
                )
            }
            item {
                BotonMostrarObjetivo(
                    botonHabilitado = botonHabilitado,
                    estadosCheckbox = estadosCheckbox,
                    alSeleccionarObjetivo = { objetivo -> objetivoSeleccionado = objetivo }
                )
            }
        }
    }
}