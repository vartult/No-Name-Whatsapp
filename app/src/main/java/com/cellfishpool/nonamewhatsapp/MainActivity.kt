package com.cellfishpool.nonamewhatsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.angmarch.views.NiceSpinner

class MainActivity : AppCompatActivity() {

    var phone: EditText?=null
    var chat: EditText?=null
    var share:Button?=null
    var msg: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phone=findViewById(R.id.phone)
        msg=findViewById(R.id.msg)
        chat=findViewById(R.id.chat)
        share=findViewById(R.id.share)


    }
}
