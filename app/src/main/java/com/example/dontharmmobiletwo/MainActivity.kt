package com.example.dontharmmobiletwo

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dontharmmobiletwo.data.model.Service
import com.example.dontharmmobiletwo.ui.navigation.NavBarItems
import com.example.dontharmmobiletwo.ui.navigation.NavRoutes
import com.example.dontharmmobiletwo.ui.screens.NewsScreen
import com.example.dontharmmobiletwo.ui.screens.ProfileScreen
import com.example.dontharmmobiletwo.ui.screens.ServiceScreen
import com.example.dontharmmobiletwo.ui.theme.DontHarmMobileTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DontHarmMobileTwoTheme {
                Main(this)
            }
        }
    }
}

@Composable
fun Main(context: Context) {
    val navController = rememberNavController()
    Column(Modifier.padding(8.dp)) {
        NavHost(navController, startDestination = NavRoutes.Service.route, modifier = Modifier.weight(1f)) {
            composable(NavRoutes.Service.route) {
                ServiceScreen()
            }
            composable(NavRoutes.News.route) {
                NewsScreen(context)
            }
            composable(NavRoutes.Profile.route) {
                ProfileScreen()
            }
        }
        BottomNavBar(navController = navController)
    }
}

@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        NavBarItems.barItems.forEach { navItem ->
            NavigationBarItem(selected = currentRoute == navItem.route, onClick = {
                navController.navigate(navItem.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true

                }
            },
            icon = {Icon(imageVector = navItem.image, contentDescription = navItem.title)},
            label = {Text(text = navItem.title)})
        }
    }
}