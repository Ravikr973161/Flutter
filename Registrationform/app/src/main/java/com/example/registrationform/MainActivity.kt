package com.example.registrationform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name=" "
        var gender=" "
        var dept=""
        name=nameTextBox.text.toString()  // input text name

        var deptList: ArrayList<String> = arrayListOf("Computer Science","Electrical Engineering","Others")

        DeptSpinnerId.adapter=ArrayAdapter(              // we need adapter for spinner which fill the spinner with item list
            this,
            android.R.layout.simple_spinner_item, //The resource ID for a layout file containing a TextView to use when instantiating views
            deptList
        )

        DeptSpinnerId.onItemSelectedListener=
            object : AdapterView.OnItemSelectedListener{ //Interface definition for a callback to be invoked when an item in this view has been selected
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    dept=deptList[p2]
                }
            }


        mySendButton.setOnClickListener {
            name=nameTextBox.text.toString()
            Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
            var genderId=GenderRadioGroup.checkedRadioButtonId // returns selected gender view id if not returns -1
            if(genderId!=-1){                         
                var gender_selected:RadioButton=findViewById(genderId)
                 gender=gender_selected.text.toString()
            }

            var intent=Intent(this,SecondActivity::class.java).apply {
                putExtra("Refername",name)   //Add extended data to the intent.
                putExtra("Refergender",gender)
                putExtra("Referdept",dept)
            }
            startActivity(intent)
        }

    }
}