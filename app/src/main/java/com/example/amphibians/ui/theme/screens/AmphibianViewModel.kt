package com.example.amphibians.ui.theme.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.AmphibianRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AmphibianViewModel(private val amphibianRepository: AmphibianRepository): ViewModel() {
    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibiansInfo()
    }

    /**
     * Получение информации о амфибиях
     */
    fun getAmphibiansInfo() = viewModelScope.launch {
        amphibianUiState = AmphibianUiState.Loading
        amphibianUiState = try {
            AmphibianUiState.Success(amphibianRepository.getAmphibiansInfo())
        } catch (e: IOException) {
            AmphibianUiState.Error
        } catch (e: HttpException) {
            AmphibianUiState.Error
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibianRepository
                AmphibianViewModel(amphibianRepository = amphibiansRepository)
            }
        }
    }
}