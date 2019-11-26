package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tetris.storage.AppPreference
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

//    val highScore = findViewById<TextView>(R.id.high_score_text)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val buttonNewGame = findViewById<Button>(R.id.new_game_button)
        val buttonSeting = findViewById<Button>(R.id.setting_button)
        val buttonExit = findViewById<Button>(R.id.exit_button)


        val resetHighScore = findViewById<Button>(R.id.reset_high_score)

        buttonNewGame.setOnClickListener(this::onButtonNewGame)
        buttonSeting.setOnClickListener(this::onButtonSetting)
        buttonExit.setOnClickListener(this::onButtonExit)
    }

    fun onButtonNewGame(view:View){
        val intent = Intent(this, GameView::class.java)
        startActivity(intent)
    }

    fun onButtonSetting(view:View){
        val intent = Intent(this, SettingView::class.java)
        startActivity(intent)
    }

    fun onButtonExit(view:View){
        System.exit(0)
    }

    fun onButtonResetScore(view:View){
        val highScore = findViewById<TextView>(R.id.high_score_text)
        val preference = AppPreference(this)
        preference.resetScore()
        Snackbar.make(view, "score successfuly reset", Snackbar.LENGTH_SHORT).show()
        highScore?.text = "High Score:0"
    }

}
