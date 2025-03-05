package com.cookie.quizine.presentation

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cookie.quizine.presentation.home.HomeScreen
import com.cookie.quizine.presentation.home.HomeScreenVM

@Composable
fun App(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen"){
        composable(route = "home_screen") {
            val viewModel: HomeScreenVM = viewModel()
            HomeScreen(
                viewModel,
                navigateToQuiz = {nickname, quizcode->
                    navController.navigate("quiz_screen?nickname=${nickname}&quizcode=${quizcode}")
                },
                navigateToResult = {},
                navigateToCreate = {},
            )
        }

        composable(route = "create_quiz_screen") {  }

        composable(route = "quiz_screen?nickname={nickname}&quizcode={quizcode}", arguments = listOf(
            navArgument(
                name= "nickname",
                builder = {
                    type = NavType.StringType
                    nullable = false
                }
            ),
            navArgument(
                name = "quizcode",
                builder = {
                    type = NavType.StringType
                    nullable = false
                }
            )
        )) {backStackEntry->
            val nickname = backStackEntry.arguments?.getString("nickname")
            val quizcode = backStackEntry.arguments?.getString("quizcode")
            Text("$nickname&&$quizcode")
        }

        composable(route = "result_quiz_screen") {  }
    }
}