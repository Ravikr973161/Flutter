package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            //val toast= Toast.makeText(this,"Dice Rolled",Toast.LENGTH_SHORT)
            //toast.show()

            //val resultTextView : TextView = findViewById(R.id.textView)
            //resultTextView.text="6"

            rollDice()

        }
         // Do a dice roll when the app starts
        rollDice()

    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val resultDice1 = dice.roll()
      //  val resultTextView1: TextView = findViewById(R.id.textView)
       // resultTextView1.text = resultDice1.toString()

        // Find the imageView in the layout
        val resultImageView: ImageView = findViewById(R.id.imageView)
        when(resultDice1) {
         1 ->   resultImageView.setImageResource(R.drawable.dice_1)
         2 ->   resultImageView.setImageResource(R.drawable.dice_2)
         3 ->   resultImageView.setImageResource(R.drawable.dice_3)
         4 ->   resultImageView.setImageResource(R.drawable.dice_4)
         5 ->   resultImageView.setImageResource(R.drawable.dice_5)
         6 ->    resultImageView.setImageResource(R.drawable.dice_6)
        }
        // Update the content description
        resultImageView.contentDescription=resultDice1.toString()

    }

}  // main Activity


class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}


