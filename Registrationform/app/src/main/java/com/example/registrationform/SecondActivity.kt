package com.example.registrationform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val obtinedName: String
        val obtinedGender: String
        val obtinedDept: String
        obtinedName= intent.getStringExtra("Refername").toString()    //Retrieve extended data from the intent.
        obtinedGender=intent.getStringExtra("Refergender").toString()
        obtinedDept=intent.getStringExtra("Referdept").toString()

        WelcomeTextView.text= "Welcome  $obtinedName \nGender: $obtinedGender \nDeportment: $obtinedDept"

    }
}