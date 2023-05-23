package com.example.amphibians.network

import com.example.amphibians.model.Amphibian
import retrofit2.http.GET


/**
 * Интерфейс определяет как Retrofit взаимодействует с веб-сервером
 * с помощью HTTP-запросов
 */
interface AmphibianApiService {
    /**
     * @GET запрос
     * Возвращает [List] с информацией о амфибиях
     */
    @GET("amphibians")
    suspend fun getInfo(): List<Amphibian>
}