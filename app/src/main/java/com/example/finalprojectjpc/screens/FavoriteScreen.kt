package com.example.finalprojectjpc.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.finalprojectjpc.R
import com.example.finalprojectjpc.components.BottomNavBar
import com.example.finalprojectjpc.components.ProductCard

@Composable
fun FavoriteScreen(navController: NavHostController) {

    val products = listOf(
        Product("Device Laser Hair Rem...", "Qmele", null, 10.0, 50, R.drawable.product_laser),
        Product("Device Laser Hair Rem...", "Qmele", null, 10.0, 50, R.drawable.product_laser),
        Product("Device Laser Hair Rem...", "Qmele", null, 10.0, 50, R.drawable.product_laser),
        Product("Device Laser Hair Rem...", "Qmele", null, 10.0, 50, R.drawable.product_laser),
        Product("Device Laser Hair Rem...", "Qmele", null, 10.0, 50, R.drawable.product_laser),
        Product("Device Laser Hair Rem...", "Qmele", null, 10.0, 50, R.drawable.product_laser)
    )
    Scaffold(
        bottomBar = {
            BottomNavBar(navController, "favorite")
        }) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5)).padding(padding)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Favorite",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = { }) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                items(products) { product ->
                    ProductCard(
                        product = product, onClick = {
                            navController.navigate("product_details")
                        })
                }
            }
        }
    }
}