package com.cookie.quizine.presentation.home

import androidx.lifecycle.ViewModel
import com.cookie.quizine.presentation.home.model.UiEvent
import com.cookie.quizine.presentation.home.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenVM : ViewModel(){
    private val _uiState = MutableStateFlow(UiState(
        onJoinQuizDialogVisible = false,
        onCreateQuizDialogVisible = false,
        onViewResultDialogVisible = false,
        nickname = "",
        quizCode = ""
    ))
    val uiState = _uiState.asStateFlow()

    fun onUiEvent(event: UiEvent) {
        when(event){
            UiEvent.OnJoinQuizClicked -> {
                _uiState.update { it.copy(
                    onJoinQuizDialogVisible = !it.onJoinQuizDialogVisible
                ) }
            }
            UiEvent.OnCreateConfirmClicked -> {}
            UiEvent.OnCreateQuizClicked -> {
                _uiState.update {
                    it.copy(
                        onCreateQuizDialogVisible = !it.onCreateQuizDialogVisible
                    )
                }
            }
            UiEvent.OnJoinConfirmClicked -> {}
            is UiEvent.OnNicknameUpdated -> {
                _uiState.update { it.copy(
                    nickname = event.updatedNickname
                ) }
            }
            is UiEvent.OnQuizCodeUpdated -> {
                _uiState.update { it.copy(
                    quizCode = event.updatedQuizCode
                ) }
            }
            UiEvent.OnResultConfirmClicked -> {}
            UiEvent.OnViewResultClicked -> {
                _uiState.update { it.copy(
                    onViewResultDialogVisible = !it.onViewResultDialogVisible
                ) }
            }
        }
    }
}