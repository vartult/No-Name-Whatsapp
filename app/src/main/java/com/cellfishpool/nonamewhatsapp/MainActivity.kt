package com.cellfishpool.nonamewhatsapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.lamudi.phonefield.PhoneEditText
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.ComponentName
import android.content.Context
import java.net.URISyntaxException
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.text.ClipboardManager
import android.view.inputmethod.InputMethodManager
import android.content.ClipData




class MainActivity : AppCompatActivity() {

    var phoneno: String="123"
    var valid=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var phone=findViewById<PhoneEditText>(R.id.phone)
        var msg=findViewById<EditText>(R.id.msg)
        var chat=findViewById<Button>(R.id.chat)

        phone.setDefaultCountry("IN")
        chat.setOnClickListener{
            validate(phone)
            if(valid==false) {
                preprocess()
                openInWhatsapp()
            }
        }
//
    }



    private fun preprocess() {

        phoneno=phoneno.replace("+", "");
        phoneno=phoneno.replace("^0", "");

    }


    private fun validate(phone: PhoneEditText) {

            if (phone.isValid) {
                phone.setError(null)
                hideKeyboard(phone)
                valid=false
            } else{
                phone.setError("Invalid Phone Number")
                hideKeyboard(phone)
            }


        phoneno = phone.getPhoneNumber()
    }



    private fun openInWhatsapp() {
        try {

            Toast.makeText(applicationContext,"Processing...",Toast.LENGTH_SHORT).show()
            val intent = Intent("android.intent.action.MAIN")
            intent.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
            intent.putExtra("jid", phoneno + "@s.whatsapp.net")
            intent.putExtra("displayname", "+" + phoneno)
            startActivity(Intent.parseUri("https://wa.me/" + phoneno, 0))
            //startActivity(Intent.parseUri("whatsapp://send/?" + phoneno, 0))
        } catch (ignore: URISyntaxException) {
            ignore.printStackTrace()
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(applicationContext, "Whatsapp not installed", Toast.LENGTH_LONG).show()
        }

    }

    @SuppressLint("ServiceCast")
    protected fun hideKeyboard(v: View) {
        val imm = v.context.applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }

}
