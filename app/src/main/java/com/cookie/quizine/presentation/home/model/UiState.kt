package com.cookie.quizine.presentation.home.model

data class UiState(
    val onJoinQuizDialogVisible: Boolean,
    val onCreateQuizDialogVisible: Boolean,
    val onViewResultDialogVisible: Boolean,
    val nickname: String,
    val quizCode: String
)
