package com.example.finalprojectjpc.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finalprojectjpc.R
import com.example.finalprojectjpc.components.BottomNavBar
import com.example.finalprojectjpc.components.CategoryCard

@Composable
fun CategoriesScreen(navController: NavHostController) {

    val categories = listOf(
        Category("Skin creams", R.drawable.cat_skin_creams),
        Category("Nail products", R.drawable.cat_nails),
        Category("Perfume", R.drawable.cat_perfume),
        Category("Skin care tools", R.drawable.cat_skin_tools),
        Category("Makeup", R.drawable.cat_makeup),
        Category("Hair care tools", R.drawable.cat_hair_tools)
    )
    Scaffold(
        bottomBar = {
            BottomNavBar(navController, "categories")
        }

    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5)).padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(categories) { category ->
                CategoryCard(
                    category = category, onClick = {
                        navController.navigate("home")
                    })
            }
        }
    }
}

data class Category(
    val name: String, val image: Int
)