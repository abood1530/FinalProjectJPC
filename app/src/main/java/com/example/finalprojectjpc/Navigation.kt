package com.example.finalprojectjpc

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalprojectjpc.screens.AccountScreen
import com.example.finalprojectjpc.screens.CartScreen
import com.example.finalprojectjpc.screens.CategoriesScreen
import com.example.finalprojectjpc.screens.FavoriteScreen
import com.example.finalprojectjpc.screens.HomeScreen
import com.example.finalprojectjpc.screens.LoginScreen
import com.example.finalprojectjpc.screens.ProductDetailsScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }
        composable("categories") {
            CategoriesScreen(navController)
        }
        composable("cart") {
            CartScreen(navController)
        }

        composable("favorite") {
            FavoriteScreen(navController)
        }

        composable("account") {
            AccountScreen(navController)
        }
        composable("product_details") {
            ProductDetailsScreen(navController)
        }
    }
}