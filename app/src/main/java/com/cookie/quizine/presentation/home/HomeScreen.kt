package com.cookie.quizine.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cookie.quizine.R
import com.cookie.quizine.presentation.home.model.UiEvent
import com.cookie.quizine.presentation.home.model.UiState

@Composable
fun HomeScreen(
    viewModel: HomeScreenVM,
    navigateToQuiz: (String, String) -> Unit,
    navigateToResult: (String) -> Unit,
    navigateToCreate: () -> Unit
    ) {
    val uiState by viewModel.uiState.collectAsState()
    HomeScreen(uiState, {event->
        when(event){
            UiEvent.OnCreateConfirmClicked -> {navigateToCreate()}
            UiEvent.OnJoinConfirmClicked -> {navigateToQuiz(uiState.nickname, uiState.quizCode)}
            UiEvent.OnResultConfirmClicked -> {navigateToResult(uiState.quizCode)}
            else -> {viewModel.onUiEvent(event)}
        }
    })
}

@Composable
private fun HomeScreen(
    uiState: UiState,
    uiEvent: (UiEvent) -> Unit
) {
    if (uiState.onJoinQuizDialogVisible) {
        JoinQuizAlertDialog(uiEvent, uiState)
    }

    if (uiState.onCreateQuizDialogVisible) {
        QuizAlertDialog(
            onAction = { updatedCode ->
                uiEvent(UiEvent.OnQuizCodeUpdated(updatedCode))
            },
            onDismiss = { uiEvent(UiEvent.OnCreateQuizClicked) },
            quizCode = uiState.quizCode,
            action = "Create Quiz",
            onButtonClick = { uiEvent(UiEvent.OnCreateConfirmClicked) }
        )
    }

    if (uiState.onViewResultDialogVisible) {
        QuizAlertDialog(
            onAction = { updatedCode ->
                uiEvent(UiEvent.OnQuizCodeUpdated(updatedCode))
            },
            onDismiss = { uiEvent(UiEvent.OnViewResultClicked) },
            quizCode = uiState.quizCode,
            action = "View Result",
            onButtonClick = { uiEvent(UiEvent.OnResultConfirmClicked) }
        )
    }
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { uiEvent(UiEvent.OnJoinQuizClicked) },
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    stringResource(R.string.on_join_quiz)
                )
            }
            Button(
                onClick = { uiEvent(UiEvent.OnCreateQuizClicked) },
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    stringResource(R.string.on_create_quiz),
                    modifier = Modifier
                )
            }
            Button(
                onClick = { uiEvent(UiEvent.OnViewResultClicked) },
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    stringResource(R.string.view_quiz_result)
                )
            }
        }
    }
}

@Composable
fun JoinQuizAlertDialog(uiEvent: (UiEvent) -> Unit, uiState: UiState) {
    AlertDialog(
        onDismissRequest = { uiEvent(UiEvent.OnJoinQuizClicked) },
        title = {
            Text("Enter Nickname and Quizcode")
        },
        text = {
            Column {
                TextField(
                    value = uiState.nickname,
                    onValueChange = { updatedNickname ->
                        uiEvent(UiEvent.OnNicknameUpdated(updatedNickname))
                    },
                    placeholder = {
                        Text(stringResource(R.string.on_enter_nickname))
                    }
                )
                Spacer(Modifier.height(8.dp))
                TextField(
                    value = uiState.quizCode,
                    onValueChange = { updatedQuizCode ->
                        uiEvent(UiEvent.OnQuizCodeUpdated(updatedQuizCode))
                    },
                    placeholder = {
                        Text(stringResource(R.string.on_enter_quizcode))
                    }
                )
                Spacer(Modifier.height(8.dp))

            }
        },
        confirmButton = {
            Button(
                onClick = {
                    uiEvent(UiEvent.OnJoinConfirmClicked)
                },
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(stringResource(R.string.on_join_button))
            }
        }
    )
}

@Composable
fun QuizAlertDialog(
    onAction: (String) -> Unit,
    onDismiss: () -> Unit,
    quizCode: String,
    action: String,
    onButtonClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text("Enter Quiz Code")
        },
        text = {
            TextField(
                value = quizCode,
                onValueChange = { updatedQuizCode ->
                    onAction(updatedQuizCode)
                },
                placeholder = {
                    Text(stringResource(R.string.on_enter_quizcode))
                }
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    onButtonClick()
                },
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(action)
            }
        }
    )
}

@Preview
@Composable
private fun HomeScreenPrev1() {
    HomeScreen(
        uiState = UiState(
            onJoinQuizDialogVisible = false,
            onCreateQuizDialogVisible = true,
            onViewResultDialogVisible = false,
            nickname = "",
            quizCode = ""
        ),
        uiEvent = {}
    )
}