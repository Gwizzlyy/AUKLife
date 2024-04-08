package com.gwizz.myapplication.models

data class PodcastModel(
    val id : String,
    val title : String,
    val subtitle : String,
    val url : String,
    val coverurl : String
)
{constructor() : this("", "", "", "", "")}