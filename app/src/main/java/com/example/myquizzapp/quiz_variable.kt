package com.example.myquizzapp

data class Question(
    val id: Int,
    val question: String,
    val  optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val Button: String,
    val correctOption: Int
)

