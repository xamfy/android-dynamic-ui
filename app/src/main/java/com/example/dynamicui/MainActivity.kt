package com.example.dynamicui

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sets the light theme to true
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val linearLayout: LinearLayout = findViewById(R.id.linearLayout)
        val linearLayoutParams: ViewGroup.MarginLayoutParams =
            linearLayout.layoutParams as ViewGroup.MarginLayoutParams
        linearLayoutParams.topMargin = 50

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val buttonParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        buttonParams.gravity = Gravity.CENTER

        params.setMargins(40, 20, 40, 20)

        for (i in 1..4) {
//            val editText = EditText(this)

            if (i % 2 == 1) {
                val textField = getTextField(params)
                linearLayout.addView(textField)
            } else {
                val button = getButton(buttonParams)
                linearLayout.addView(button)
            }

//            linearLayout.addView(textInputLayout)
        }

    }

    private fun getTextField(params: LinearLayout.LayoutParams): TextInputLayout {
        val textInputLayout = TextInputLayout(
            this,
            null,
            R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox
        )
        textInputLayout.layoutParams = params

        textInputLayout.hint = "Enter your email address"
        textInputLayout.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        textInputLayout.setBoxCornerRadii(
            5F,
            5F, 5F, 5F
        )

        val textInputEditText = TextInputEditText(textInputLayout.context)
        textInputEditText.layoutParams = params

        textInputLayout.addView(textInputEditText)

        textInputLayout.layoutParams = params

        return textInputLayout
    }

    private fun getButton(params: LinearLayout.LayoutParams): MaterialButton {
        val button: MaterialButton = MaterialButton(this)
        button.layoutParams = params
        button.text = "Button"
        return button
    }
}