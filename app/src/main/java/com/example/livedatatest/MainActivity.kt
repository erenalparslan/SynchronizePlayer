package com.example.livedatatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editTw : EditText=findViewById(R.id.editTextText)
        var tw : TextView=findViewById(R.id.textView)


        val _text = MutableLiveData("deneme")
        val text1: LiveData<String> =_text
        editTw.addTextChangedListener { a->
            _text.value="$a"
        }

        text1.observe(this,Observer { user ->
                tw.text=user
        })
    }
}