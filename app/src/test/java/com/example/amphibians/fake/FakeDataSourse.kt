package com.example.amphibians.fake

import com.example.amphibians.model.Amphibian

object FakeDataSourse {
    val fakeListOfAphibians: List<Amphibian> = listOf(
        Amphibian(
            name = "Обыкновенный тритон",
            type = "Тритон",
            description = "Наиболее распространённый вид тритонов из рода малых тритонов (Lissotriton) отряда хвостатых земноводных. Вид впервые был описан в 1758 году шведским натуралистом Карлом Линнеем.",
            imgSrc = "url.1"
        ),
        Amphibian(
            name = "Обыкновенная чесночница",
            type = "Чесночница",
            description = "Вид бесхвостых земноводных семейства чесночниц. Ранее в этот вид включали также чесночницу Палласа, рассматривая её как восточную форму обыкновенной.",
            imgSrc = "url.2"
        )
    )
}