package com.example.mydinnerdecider

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private val availableFoods = mutableListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese", "African")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val btnAddFood : Button = findViewById(R.id.btn_addFood)
        val btnDecide : Button = findViewById(R.id.btn_decideFood)
        val edtFood : EditText = findViewById(R.id.update_food)
        val txtDisplay : TextView = findViewById(R.id.selectedFood)

        btnDecide.setOnClickListener {
            txtDisplay.text = selectFood(availableFoods);
        }

        btnAddFood.setOnClickListener{
            addFood(edtFood.text.toString())
            edtFood.text.clear()
//            edtFood.clearFocus()
//            hideKeyboard()
        }
    }

    private fun selectFood (foods : List<String>): String{
        val selectedIndex = Random.nextInt(0, foods.size)
        return availableFoods[selectedIndex];
    }

    private fun addFood (foodItem : String){
        availableFoods.add(foodItem);
    }

//    private fun hideKeyboard() {
//        val inputMethodManager = ContextCompat.getSystemService(this, InputMethodManager::class.java)
//        inputMethodManager?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
//    }
}