package com.example.studyflow

data class StudyTask(
    val title: String,
    val type: String,
    var isCompleted: Boolean = false
)