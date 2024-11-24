package com.mbougar.din_componentesbasicos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.mbougar.din_componentesbasicos.ui.screens.PantallaPrincipal
import com.mbougar.din_componentesbasicos.ui.theme.MyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var esModoOscuro by rememberSaveable { mutableStateOf(true) }
            MyTheme(darkTheme = esModoOscuro) {
                PantallaPrincipal(
                    esModoOscuro = esModoOscuro,
                    alCambiarTema = { esModoOscuro = it }
                )
            }
        }
    }
}