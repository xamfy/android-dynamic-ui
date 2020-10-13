package com.example.dynamicui

import Json4Kotlin_Base
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.NestedScrollView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sets the light theme to true
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val nestedScrollView: NestedScrollView = findViewById(R.id.nestedScrollView)
//        val linearLayout: LinearLayout = findViewById(R.id.linearLayout)

        val linearLayout: LinearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL;

//        val linearLayoutParams: ViewGroup.MarginLayoutParams =
//            linearLayout.layoutParams as ViewGroup.MarginLayoutParams
//        linearLayoutParams.topMargin = 50

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

        val json = getJSON()
        val gson = GsonBuilder().create()
        val response = gson.fromJson(json, Json4Kotlin_Base::class.java)

        /*
        * Schema
        *
        * id -> view id or key associated with that particular field
        * ViewType -> type of the view like TextView, EditText, CheckBox etc
        * text -> text associate with the view, different ViewTypes can interpret this differently
        * hintText -> hint text associate witht the view, different ViewTypes can interpret this differently
        *
        * */

        for (field in response.form.fields) {
            when (field.viewType) {
                "TextView" -> {
                    val view = getTextView(params, field.text)
                    linearLayout.addView(view)
                }
                "TextInputLayout" -> {
                    val view = getTextInputLayout(params, field.hintText)
                    linearLayout.addView(view)
                }
                "Button" -> {
                    val view = getButton(buttonParams, field.text)
                    linearLayout.addView(view)
                }
                else -> {
                    // ViewType not recognized
                }
            }
        }

        nestedScrollView.addView(linearLayout)

    }
//
//    class Response(json: String) : JSONObject(json) {
//        var form = this.optString("form")
//        var fields = this.optJSONArray("fields")
//            ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) }} // returns an array of JSONObject
//            ?.map { Fields(it.toString())} // // transforms each JSONObject of the array into Fields
//    }

    private fun getJSON(): String {
        val stringJson = """
            {
               "form":{
                  "fields":[
                     {
                        "id":"0",
                        "ViewType":"TextView",
                        "text":"Email address",
                        "hintText":""
                     },
                     {
                        "id":"1",
                        "ViewType":"TextInputLayout",
                        "text":"",
                        "hintText":"Please enter your email address"
                     },
                     {
                        "id":"3",
                        "ViewType":"Button",
                        "text":"Submit",
                        "hintText":""
                     },
                     {
                        "id":"4",
                        "ViewType":"TextView",
                        "text":"Email address",
                        "hintText":""
                     },
                     {
                        "id":"5",
                        "ViewType":"TextInputLayout",
                        "text":"",
                        "hintText":"Please enter your email address"
                     },
                     {
                        "id":"6",
                        "ViewType":"Button",
                        "text":"Submit",
                        "hintText":""
                     },
                     {
                        "id":"7",
                        "ViewType":"TextView",
                        "text":"Email address",
                        "hintText":""
                     },
                     {
                        "id":"8",
                        "ViewType":"TextInputLayout",
                        "text":"",
                        "hintText":"Please enter your email address"
                     },
                     {
                        "id":"9",
                        "ViewType":"Button",
                        "text":"Submit",
                        "hintText":""
                     },
                     {
                        "id":"10",
                        "ViewType":"TextView",
                        "text":"Password",
                        "hintText":""
                     },
                     {
                        "id":"11",
                        "ViewType":"TextView",
                        "text":"Email address",
                        "hintText":""
                     },
                     {
                        "id":"12",
                        "ViewType":"TextInputLayout",
                        "text":"",
                        "hintText":"Please enter your email address"
                     },
                     {
                        "id":"13",
                        "ViewType":"Button",
                        "text":"Submit",
                        "hintText":""
                     },
                     {
                        "id":"14",
                        "ViewType":"TextView",
                        "text":"Email address",
                        "hintText":""
                     },
                     {
                        "id":"15",
                        "ViewType":"TextInputLayout",
                        "text":"",
                        "hintText":"Please enter your email address"
                     },
                     {
                        "id":"16",
                        "ViewType":"Button",
                        "text":"Submit",
                        "hintText":""
                     },
                     {
                        "id":"17",
                        "ViewType":"TextView",
                        "text":"Email address",
                        "hintText":""
                     },
                     {
                        "id":"18",
                        "ViewType":"TextInputLayout",
                        "text":"",
                        "hintText":"Please enter your email address"
                     },
                     {
                        "id":"19",
                        "ViewType":"Button",
                        "text":"Submit",
                        "hintText":""
                     },
                     {
                        "id":"20",
                        "ViewType":"TextView",
                        "text":"Password",
                        "hintText":""
                     }
                  ]
               }
            }
        """.trimIndent()

//        val obj = JSONObject(stringJson)
//        Log.i(TAG, obj.toString())
        return stringJson
    }

    private fun getTextInputLayout(
        params: LinearLayout.LayoutParams,
        hintText: String
    ): TextInputLayout {
        val textInputLayout = TextInputLayout(
            this,
            null,
            R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox
        )
        textInputLayout.layoutParams = params

//        textInputLayout.hint = "Enter your email address"
        textInputLayout.hint = hintText
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

    private fun getButton(params: LinearLayout.LayoutParams, text: String): MaterialButton {
        val button: MaterialButton = MaterialButton(this)
        button.layoutParams = params
        button.text = text
        return button
    }

    private fun getTextView(params: LinearLayout.LayoutParams, text: String): TextView {
        val textView: TextView = TextView(this)
        textView.text = text
        textView.textSize = 22F
        textView.layoutParams = params
        return textView
    }
}