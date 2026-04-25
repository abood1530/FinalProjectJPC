package com.example.finalprojectjpc.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ViewList
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavHostController, currentRoute: String) {

    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = currentRoute == "home", onClick = {
                navController.navigate("home") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }, icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp)
                )
            }, label = { Text("Home") }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFB9252A), unselectedIconColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = currentRoute == "categories", onClick = {
                navController.navigate("categories") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }, icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ViewList,
                    contentDescription = "Categories",
                    modifier = Modifier.size(24.dp)
                )
            }, label = { Text("Categories") }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFB9252A), unselectedIconColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = currentRoute == "cart", onClick = {
                navController.navigate("cart") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }, icon = {
                BadgedBox(
                    badge = {
                        Badge {
                            Text("3")
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart"
                    )
                }
            }, label = { Text("Cart") }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFB9252A), unselectedIconColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = currentRoute == "favorite", onClick = {
                navController.navigate("favorite") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }, icon = {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder, contentDescription = "Favorite"
                )
            }, label = { Text("Favorite") }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFB9252A), unselectedIconColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = currentRoute == "account", onClick = {
                navController.navigate("account") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }, icon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "Account"
                )
            }, label = { Text("Account") }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFB9252A), unselectedIconColor = Color.Gray
            )
        )
    }
}