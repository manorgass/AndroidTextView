package com.tistory.manorgass.android.textview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val watcher = object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textView.text = p0.toString()
                textView1.text = p0.toString()
                textView2.text = p0.toString()
                textView3.text = p0.toString()
                textView4.text = p0.toString()
                textViewSize.text = "size = ${textView.textSize}"
            }
        }
        editText.addTextChangedListener(watcher)
        editText.inputType = 0

        textView1.isSelected = true

        btnNext.setOnClickListener { startActivity(Intent(this, ListActivity::class.java)) }
    }
}