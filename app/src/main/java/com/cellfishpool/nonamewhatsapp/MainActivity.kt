package com.cellfishpool.nonamewhatsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import org.angmarch.views.NiceSpinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var country= findViewById<NiceSpinner>(R.id.country) as NiceSpinner
        val dataset= listOf("One","Two","Three")
        country.attachDataSource(dataset)
        var phone=findViewById<EditText>(R.id.phone)

    }
}
