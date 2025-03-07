package com.cookie.quizine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cookie.quizine.presentation.App
import com.cookie.quizine.presentation.home.HomeScreen
import com.cookie.quizine.presentation.home.HomeScreenVM
import com.cookie.quizine.presentation.pizza.PizzaScreen
import com.cookie.quizine.presentation.theme.QuizineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizineTheme {
                PizzaScreen()
            }
        }
    }
}
