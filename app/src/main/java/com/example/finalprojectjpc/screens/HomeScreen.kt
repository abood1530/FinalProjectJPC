package com.example.finalprojectjpc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.finalprojectjpc.R
import com.example.finalprojectjpc.components.BottomNavBar
import com.example.finalprojectjpc.components.ProductCard

@Composable
fun HomeScreen(navController: NavHostController) {

    val products = listOf(
        Product("Device Laser Hair Rem...", "Qmele", 20.0, 18.0, 70, R.drawable.product_brush),
        Product("Device Laser Hair Rem...", "Qmele", 15.0, 10.0, 50, R.drawable.product_laser),
        Product("Cherry Darling", "Brand", null, null, 0, R.drawable.product_brush, "-50%"),
        Product("Makeup Brushes", "Brand", null, null, 0, R.drawable.product_brush, "-33%")
    )

    Scaffold(

        bottomBar = {
            BottomNavBar(navController, "home")
        }) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).background(Color(0xFFF5F5F5))
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Good morning",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        color = Color.Black
                    )
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, null)
                    }
                    Box {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Notifications, null)
                        }

                        Box(
                            modifier = Modifier.size(8.dp).background(Color.Red, CircleShape)
                                .align(Alignment.TopEnd)
                        )
                    }
                }

            }

            item {

                Box(
                    modifier = Modifier.fillMaxWidth().height(160.dp).padding(horizontal = 16.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.banner_lipstick),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(10.dp))
                    )
                    Column(
                        modifier = Modifier.align(Alignment.CenterStart).padding(start = 16.dp)
                    ) {
                        Text(
                            text = "lipsticks set", fontSize = 18.sp
                        )
                        Text(
                            text = "$10",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { }, colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFB9252A)
                            )
                        ) {
                            Text("Shop Now")
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.height(600.dp).padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
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
}

data class Product(
    val name: String,
    val brand: String,
    val oldPrice: Double?,
    val price: Double?,
    val sold: Int,
    val image: Int,
    val discount: String? = null
)