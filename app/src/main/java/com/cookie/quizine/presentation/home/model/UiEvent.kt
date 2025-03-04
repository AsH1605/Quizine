package com.cookie.quizine.presentation.home.model

sealed interface UiEvent {
    data object OnJoinQuizClicked: UiEvent
    data object OnCreateQuizClicked: UiEvent
    data object OnViewResultClicked: UiEvent
    data object OnJoinConfirmClicked: UiEvent
    data object OnCreateConfirmClicked: UiEvent
    data object OnResultConfirmClicked: UiEvent
    data class OnQuizCodeUpdated(val updatedQuizCode: String): UiEvent
    data class OnNicknameUpdated(val updatedNickname: String): UiEvent
}