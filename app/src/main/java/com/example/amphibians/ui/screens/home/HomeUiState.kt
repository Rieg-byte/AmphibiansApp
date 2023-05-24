package com.example.amphibians.ui.screens.home

import com.example.amphibians.model.Amphibian

/**
 * Состояние пользовательского интерфейса для главного экрана
 */
sealed interface HomeUiState {
    data class Success(val amphibians: List<Amphibian>): HomeUiState
    object Loading: HomeUiState
    object Error: HomeUiState
}