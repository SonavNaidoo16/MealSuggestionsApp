package vcmsa.sonav.mealsuggestions

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // start code here
        val radioMorning = findViewById<RadioButton>(R.id.RadioMorning)
        val radioMidMorning = findViewById<RadioButton>(R.id.radioMidMorning)
        val radioAfternoon = findViewById<RadioButton>(R.id.radioAfternoon)
        val radioMidAfternoon = findViewById<RadioButton>(R.id.radioMidAfternoon)
        val radioDinner = findViewById<RadioButton>(R.id.radioDinner)
        val suggestBtn = findViewById<Button>(R.id.btnSuggest)
        val resetBtn = findViewById<Button>(R.id.btnReset)
        val answerText = findViewById<TextView>(R.id.tvMealSuggestion)

        // Suggest button
        suggestBtn.setOnClickListener {
            //Ai assisted by chatgpt
            //pasted code and said "add a if statement that checks if none of the radio buttons are selected"
            if (!radioMorning.isChecked && !radioMidMorning.isChecked && !radioAfternoon.isChecked && !radioMidAfternoon.isChecked && !radioDinner.isChecked) {
                //end of prompt
                answerText.text = "Please pick a option!"
            } else {
                answerText.text = when {
                    radioMorning.isChecked -> listOf("Eggs and toast", "Cereal", "Pancakes", "Waffles").random()
                    radioMidMorning.isChecked -> listOf("Chicken sandwich", "Fruit", "Yogurt", "Oatmeal").random()
                    radioAfternoon.isChecked -> listOf("Salad", "Pasta", "Grilled Chicken", "Soup").random()
                    radioMidAfternoon.isChecked -> listOf("Burger", "Pizza", "Nachos", "Tacos").random()
                    radioDinner.isChecked -> listOf("Mutton curry", "Pasta", "Roast", "Sushi").random()
                    else -> "Please pick an option!"
                }
            }
        }
        // Reset button
        resetBtn.setOnClickListener {
            //Ai assisted by chatgpt
            //pasted above code and said "fix this code"
            radioMorning.isChecked = false
            radioMidMorning.isChecked = false
            radioAfternoon.isChecked = false
            radioMidAfternoon.isChecked = false
            radioDinner.isChecked = false
            //end prompt
            answerText.text = "" // Clear the text view
        }
    }
} //end of code





