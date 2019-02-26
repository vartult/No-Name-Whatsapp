package com.cellfishpool.nonamewhatsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import net.rimoto.intlphoneinput.IntlPhoneInput
import org.angmarch.views.NiceSpinner

class MainActivity : AppCompatActivity() {

    var phoneno: String="123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var phone=findViewById<IntlPhoneInput>(R.id.phone)
        var msg=findViewById<EditText>(R.id.msg)
        var chat=findViewById<Button>(R.id.chat)
        var share=findViewById<Button>(R.id.share)
        var phoneno: String?=null

        chat.setOnClickListener{
            validate(phone)
        }
        share.setOnClickListener{
            validate(phone)
        }



    }

    private fun validate(phone: IntlPhoneInput?) {
        if(phone.isValid)
        {
            phoneno= phone.phoneNumber.toString()
        }
    }


}
