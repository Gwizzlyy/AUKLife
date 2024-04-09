package com.gwizz.myapplication.models

data class CategoryModel(
    val name : String,
    val coverurl : String,
    val podcasts : List<String>,
    val factalks : List<String>

) {
    constructor() : this("", "", listOf(), listOf())
}
