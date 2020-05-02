package com.example.exo1


import android.content.Context
import android.content.Intent
import android.graphics.Color

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.exo1.MainActivity.Companion.COLOR
import com.example.exo1.MainActivity.Companion.SHARED_PREFS
import com.example.exo1.MainActivity.Companion.TEXT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.ac
import kotlinx.android.synthetic.main.activity_second.*
import top.defaults.colorpicker.ColorPickerPopup

//import androidx.test.espresso.matcher.ViewMatchers.isChecked


class SecondActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var editText: EditText? = null
    private var applyTextButton: Button? = null
    private var saveButton: Button? = null
    private var color: Button? = null
    private var switch1: Switch? = null
    private var text: String? = null
    private var switchOnOff = false
    private var clr :Int = 0
    private var clr2 :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textView = findViewById<View>(R.id.textview) as TextView
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        textView!!.text = sharedPreferences.getString(TEXT, "")
        textView!!.setBackgroundColor(sharedPreferences.getInt(COLOR,0))
        val someView: View = findViewById(R.id.second)

        // Find the root view
        // Find the root view
        val root = someView.rootView

        // Set the color
        // Set the color
        root.setBackgroundColor(sharedPreferences.getInt(COLOR,0))
        ac.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {

                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        })
    }





}
