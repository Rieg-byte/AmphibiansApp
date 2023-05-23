package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApiService

/**
 * Репозиторий, который извлекает список амфибий
 */
interface AmphibianRepository {
    suspend fun getAmphibiansInfo(): List<Amphibian>
}

/**
 * Сетевая реализация репозитория, который извлекает список амфибий
 */
class NetworkAmphibianRepository(
    private val amphibianApiService: AmphibianApiService
): AmphibianRepository {
    override suspend fun getAmphibiansInfo(): List<Amphibian> {
        return amphibianApiService.getInfo()
    }
}