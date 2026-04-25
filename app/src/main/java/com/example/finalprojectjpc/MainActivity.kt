package com.example.finalprojectjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.finalprojectjpc.ui.theme.FinalProjectJPCTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalProjectJPCTheme {
                val navController = rememberNavController()

                Navigation(navController)

            }
        }
    }
}