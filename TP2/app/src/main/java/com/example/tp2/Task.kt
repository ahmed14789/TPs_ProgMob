package com.example.tp2

data class Task(
    val title: String,
    val duration: Int,
    val description: String,
    val category: Categorie,
    val code_icon: Int
) {

    enum class Categorie {
        Other, Work, Sport, Chores, Reading, Children, Shopping
    }
}