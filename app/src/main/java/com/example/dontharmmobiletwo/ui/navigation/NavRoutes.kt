package com.example.dontharmmobiletwo.ui.navigation

sealed class NavRoutes(val route: String) {
    object Service: NavRoutes("service")
    object News: NavRoutes("news")
    object Profile: NavRoutes("profile")


}