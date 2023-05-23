package com.example.amphibians.ui.theme.screens

import com.example.amphibians.model.Amphibian

/**
 * Состояние пользовательского интерфейса для главного экрана
 */
sealed interface AmphibianUiState {
    data class Success(val amphibians: List<Amphibian>): AmphibianUiState
    object Loading: AmphibianUiState
    object Error: AmphibianUiState
}