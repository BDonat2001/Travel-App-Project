package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

data class NavbarItem(val route:String, val label:String, val icon:ImageVector)


@Composable
fun Navigation(navController:NavHostController) {
    val currentDestination by navController.currentBackStackEntryAsState()
    val navigationItems = listOf(
        NavbarItem("home", "Home", Icons.Outlined.Home),
        NavbarItem("search", "Search", Icons.Outlined.Search),
        NavbarItem("lists", "Lists", Icons.AutoMirrored.Outlined.List),
        NavbarItem("profile", "Profile", Icons.Outlined.Person)
    )

    NavigationBar {
        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = currentDestination?.destination?.route == item.route,
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(text = item.label) },
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}