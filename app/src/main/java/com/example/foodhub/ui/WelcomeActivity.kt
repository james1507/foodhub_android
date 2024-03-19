package com.example.foodhub.ui

import android.app.Activity
import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.example.foodhub.R
import java.util.Locale

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        chooseLang()
        skipButtonAction()
    }

    private fun chooseLang() {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val languages = resources.getStringArray(R.array.languages_array)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
        spinner.setSelection(0)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedLang = parent?.getItemAtPosition(position).toString()
                if (selectedLang == languages[1]) {
                    setLocale("en")
                    finish()
                    startActivity(intent)
                } else if (selectedLang == languages[2]) {
                    setLocale("vi")
                    finish()
                    startActivity(intent)
                }
            }
        }
    }

    private fun setLocale(language: String?) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(language)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }

    private fun skipButtonAction() {
        val skipAction = findViewById<TextView>(R.id.txtSkip)
        skipAction.setOnClickListener {
            println("show me love")
        }
    }
}