package com.example.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tetris.storage.AppPreference

class GameView : AppCompatActivity() {

    var tvHighScore: TextView? = null
    var tvCurrentScore: TextView? = null
    var appPreference: AppPreference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_view)

        appPreference = AppPreference(this)

        val btnRestart = findViewById<Button>(R.id.restart)
        tvHighScore = findViewById(R.id.tv_higth_score)
        tvCurrentScore = findViewById(R.id.tv_curret_score)


        updateCurrentScore()
        updateHighScore()
    }

    fun updateHighScore(){
        tvHighScore?.text = "${appPreference?.getHighScore()}"
    }

    fun updateCurrentScore(){
        tvCurrentScore?.text = "0"
    }
}
