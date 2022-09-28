package com.example.myapplication

import android.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel(
    private val stateSavedStateHandle: SavedStateHandle
) : ViewModel() {

    val color = stateSavedStateHandle.getStateFlow(COLOR_KEY, Color.WHITE)

    fun generateNewColor() {
        val rnd = Random
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

        stateSavedStateHandle[COLOR_KEY] = color
    }

    companion object {
        const val COLOR_KEY = "color"
    }
}