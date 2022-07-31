package com.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.CheckBox

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        loadSettings()
    }
    override fun onDestroy() {
        saveSettings()
        super.onDestroy()
    }
    private fun saveSettings() {
        val sharedPref: SharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.apply {
            putBoolean("refreshInBackground",
                findViewById<CheckBox>(R.id.cbRefreshInBackground).isChecked)//refreshInBackground)
            apply()
        }
    }
    private fun loadSettings() {
        val sharedPref: SharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        findViewById<CheckBox>(R.id.cbRefreshInBackground).isChecked =
            sharedPref.getBoolean("refreshInBackground", false)
    }
}