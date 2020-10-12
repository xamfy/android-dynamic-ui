package com.example.dynamicui

import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sets the light theme to true
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val linearLayout: LinearLayout = findViewById(R.id.linearLayout)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        params.setMargins(40, 20, 40, 20)

        for (i in 1..3) {
//            val editText = EditText(this)
            val textInputLayout = TextInputLayout(
                this,
                null,
                R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox
            )
            textInputLayout.layoutParams = params

            textInputLayout.hint = "Enter your email address"
            textInputLayout.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
            textInputLayout.setBoxCornerRadii(5F,
                5F, 5F, 5F)

            val textInputEditText = TextInputEditText(textInputLayout.context)
            textInputEditText.layoutParams = params

            textInputLayout.addView(textInputEditText)

            textInputLayout.layoutParams = params
            linearLayout.addView(textInputLayout)
        }

    }
}