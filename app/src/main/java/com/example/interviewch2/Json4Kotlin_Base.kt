package com.example.interviewch2

import android.provider.MediaStore

data class Json4Kotlin_Base (

    val Id : Int,
    val Name : String,
    val Desc : String,
    val ShortDesc : String,
    val Type : String,
    val Owner : Owner,
    val Episode : String,
    val AgvotCode : String,
    val AgvotDisclaimer : String,
    val QfrCode : String,
    val AiringOrder : String,
    val BroadcastDate : String,
    val BroadcastTime : String,
    val BroadcastDateTime : String,
    val LastModifiedDateTime : String,
    val GameId : String,
    val Album : String,
    val Genres : List<String>,
    val Keywords : List<String>,
    val Tags : List<String>,
    val Images : List<Images>,
    val Authentication : Authentication,
    val NextAuthentication : String,
    val RatingWarnings : List<String>,
    val People : List<String>,
    val Funding : String,
    val MusicLabels : List<String>,
    val BroadcastNetworks : List<String>
)

