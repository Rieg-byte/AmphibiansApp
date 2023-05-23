package com.example.amphibians

import com.example.amphibians.data.AmphibianRepository
import com.example.amphibians.data.NetworkAmphibianRepository
import com.example.amphibians.network.AmphibianApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Контейнер, который содержит необходимые зависимости для приложения
 */
interface AppContainer {
    val amphibianRepository: AmphibianRepository
}

@OptIn(ExperimentalSerializationApi::class)
class DefaultAppContainer: AppContainer {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }

    override val amphibianRepository: AmphibianRepository by lazy {
        NetworkAmphibianRepository(retrofitService)
    }

}