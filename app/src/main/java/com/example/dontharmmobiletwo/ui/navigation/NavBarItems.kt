package com.example.dontharmmobiletwo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

object NavBarItems {
    var barItems = listOf(
        BarItem("Services", Icons.Filled.Menu, "service"),
        BarItem("News", Icons.Filled.ShoppingCart, "news"),
        BarItem("Profile", Icons.Filled.AccountCircle, "profile"),
    )
}

data class BarItem (
    val title: String,
    val image: ImageVector,
    val route: String
)