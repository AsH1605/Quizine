package com.cookie.quizine.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cookie.quizine.presentation.home.HomeScreen
import com.cookie.quizine.presentation.home.HomeScreenVM

@Composable
fun App(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen"){
        composable(route = "home_screen") {
            val viewModel: HomeScreenVM = viewModel()
            HomeScreen(viewModel)
        }
    }
}