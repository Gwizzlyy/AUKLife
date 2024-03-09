package com.gwizz.myapplication.models

data class CategoryModel(
    val name : String,
    val coverurl : String,

) {
    constructor() : this("", "")
}
