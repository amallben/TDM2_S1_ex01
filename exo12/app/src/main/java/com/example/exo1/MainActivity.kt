package com.example.exo1


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import top.defaults.colorpicker.ColorPickerPopup


//import androidx.test.espresso.matcher.ViewMatchers.isChecked


class MainActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_main)
        textView = findViewById<View>(R.id.textview) as TextView
        editText = findViewById<View>(R.id.edittext) as EditText
        applyTextButton = findViewById<View>(R.id.apply_text_button) as Button
        color = findViewById<View>(R.id.color) as Button
        saveButton = findViewById<View>(R.id.save_button) as Button
        switch1 = findViewById<View>(R.id.switch1) as Switch
        applyTextButton!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView!!.text = editText!!.text.toString()

            }
        })
        saveButton!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                saveData()
            }
        })
        color!!.setOnClickListener { ColorPickerPopup.Builder(this)
            .initialColor(Color.RED) // Set initial color
            .enableBrightness(true) // Enable brightness slider or not
            .enableAlpha(true) // Enable alpha slider or not
            .okTitle("Choose")
            .cancelTitle("Cancel")
            .showIndicator(true)
            .showValue(true)
            .build()
            .show( object : ColorPickerPopup.ColorPickerObserver() {
                override fun onColorPicked(color: Int) {
                    textView!!.setBackgroundColor(color)
                    clr=color
                    val someView: View = findViewById(R.id.main)

                    // Find the root view
                    // Find the root view
                    val root = someView.rootView

                    // Set the color
                    // Set the color
                    root.setBackgroundColor(color)
                }

                fun onColor(color: Int, fromUser: Boolean) {}
            })  }

        loadData()
        updateViews()

         //var saveButton = findViewById<View>(R.id.ac) as Button
         ac.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    startActivity(intent)
                }
            })
        val someView: View = findViewById(R.id.main)

        // Find the root view
        // Find the root view
        val root = someView.rootView

        // Set the color
        // Set the color
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        root.setBackgroundColor(sharedPreferences.getInt(COLOR,0))
    }

    fun saveData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(TEXT, textView!!.text.toString())
        editor.putInt(COLOR,clr)
        editor.putBoolean(SWITCH1, switch1!!.isChecked)
        editor.apply()
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        text = sharedPreferences.getString(TEXT, "")
        clr2= sharedPreferences.getInt(COLOR,0)
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false)
    }

    fun updateViews() {
        textView!!.text = text
        textView!!.setBackgroundColor(clr2)
        switch1!!.isChecked = switchOnOff

        //textview.text = text
        //textview.setBackgroundColor(clr2)
    }

    companion object {
        const val SHARED_PREFS = "sharedPrefs"
        const val TEXT = "text"
        const val COLOR = "color"
        const val SWITCH1 = "switch1"
    }
}
