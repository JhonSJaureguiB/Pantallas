package com.example.pantallas.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun navigationExample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_a") {
        composable("screen_a") {
            ScreenA(navController)
        }
        composable(
            route = "screen_b/{name}/{lastName}/{age}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("lastName") { type = NavType.StringType },
                navArgument("age") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val lastName = backStackEntry.arguments?.getString("lastName")
            val age = backStackEntry.arguments?.getString("age")
            ScreenB(navController, name, lastName, age)
        }
    }
}