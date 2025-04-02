package vcmsa.sonav.mealsuggestions

import android.os.Bundle
import android.util.Log
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
        //code starts here
        //Declaration of values:

        val radioMorning = findViewById<RadioButton>(R.id.RadioMorning)
        val radioMidMorning = findViewById<RadioButton>(R.id.radioMidMorning)
        val radioAfternoon = findViewById<RadioButton>(R.id.radioAfternoon)
        val radioMidAfternoon = findViewById<RadioButton>(R.id.radioMidAfternoon)
        val radioDinner = findViewById<RadioButton>(R.id.radioDinner)
        val radioAfterDinner = findViewById<RadioButton>(R.id.radioAfterDinner)
        val suggestBtn = findViewById<Button>(R.id.btnSuggest)
        val resetBtn = findViewById<Button>(R.id.btnReset)
        val answerText = findViewById<TextView>(R.id.tvMealSuggestion)

        // Suggest button
        suggestBtn.setOnClickListener {
            Log.d("MainActivity", "Suggest button clicked")

            if (!radioMorning.isChecked && !radioMidMorning.isChecked && !radioAfternoon.isChecked &&
                !radioMidAfternoon.isChecked && !radioDinner.isChecked && !radioAfterDinner.isChecked
            ) {
                answerText.text = "Please pick an option!"
                Log.d("MainActivity", "No option selected")
            } else {
                val selectedMeal = when {
                    radioMorning.isChecked -> listOf("Eggs and toast", "Cereal", "Pancakes", "Waffles").random()
                    radioMidMorning.isChecked -> listOf("Rice cake", "Fruit", "Yogurt", "Oatmeal").random()
                    radioAfternoon.isChecked -> listOf("Salad", "Pasta", "Chicken sandwich", "Soup").random()
                    radioMidAfternoon.isChecked -> listOf("Burger", "Pizza", "Nachos", "Tacos").random()
                    radioDinner.isChecked -> listOf("Mutton curry", "Pasta", "Roast", "Sushi").random()
                    radioAfterDinner.isChecked -> listOf("Ice cream", "Chocolate", "Cake", "Donut").random()
                    else -> "Please pick an option!"
                }
                answerText.text = selectedMeal

                // Log  meal suggestion
                Log.d("MainActivity", "Suggested meal: $selectedMeal")
            }
        }
        // Reset button
        resetBtn.setOnClickListener {
            Log.d("MainActivity", "Reset button clicked")
            //Ai assisted by chatGpt
            // Prompt pasted the above code and said "Please fix my code above and reset radio button"
            // Reset all radio buttons
            radioMorning.isChecked = false
            radioMidMorning.isChecked = false
            radioAfternoon.isChecked = false
            radioMidAfternoon.isChecked = false
            radioDinner.isChecked = false
            radioAfterDinner.isChecked = false
            //end of prompt
            answerText.text = "" // Clear the text view
            Log.d("MainActivity", "Selections cleared")
        }
    }
}


