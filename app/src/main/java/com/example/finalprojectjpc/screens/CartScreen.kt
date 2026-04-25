package com.example.finalprojectjpc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.finalprojectjpc.R
import com.example.finalprojectjpc.components.BottomNavBar

@Composable
fun CartScreen(navController: NavHostController) {

    val products = listOf(
        R.drawable.product_laser,
        R.drawable.product_laser,
        R.drawable.product_laser,
        R.drawable.product_laser
    )
    Scaffold(
        bottomBar = {
            BottomNavBar(navController, "cart")
        }) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5)).padding(padding)
        ) {
            Text(
                text = "Cart(4)",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f).padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(products) { image ->
                    CartItem(image)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SubTotal", modifier = Modifier.weight(1f)
                )
                Text(
                    text = "$45.00"
                )
            }

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB9252A)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Buy now", fontSize = 18.sp, color = Color.White
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun CartItem(image: Int) {
    var quantity by remember { mutableStateOf(1) }
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = { },
                    modifier = Modifier.align(Alignment.TopEnd).size(24.dp)
                        .background(Color.White, CircleShape)
                ) {
                    Icon(
                        Icons.Default.Close, contentDescription = null, tint = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Device Laser Hair Rem...", color = Color.Black, fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$10.00", color = Color.Red
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { if (quantity > 1) quantity-- }) {

                    Icon(Icons.Default.Remove, null, tint = Color.Black)
                }
                Text(quantity.toString(), color = Color.Black)
                IconButton(onClick = { quantity++ }) {
                    Icon(Icons.Default.Add, null, tint = Color.Black)
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Buy now", color = Color.Red
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.Info, contentDescription = null, tint = Color.Gray
                )
            }
        }
    }
}