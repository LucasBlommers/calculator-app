package eu.tutorials.software.calculaterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatViewInflater

class MainActivity : AppCompatActivity() {

    var lastNumeric = false
    var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        //Toast.makeText(this, "You pressed a button", Toast.LENGTH_SHORT).show()
        var tvInput = findViewById<TextView>(R.id.tvInput)
        tvInput.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View){
        var tvInput = findViewById<TextView>(R.id.tvInput)
        tvInput.setText("")
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View){
        var tvInput = findViewById<TextView>(R.id.tvInput)
        if(lastNumeric && !lastDot){
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View){
        var tvInput = findViewById<TextView>(R.id.tvInput)

        if(lastNumeric && !isOperatorAdded(tvInput.text.toString())){
            var tvInputValue = tvInput.text
            tvInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }
    private fun isOperatorAdded(value: String) : Boolean{
        return if (value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*") ||
                    value.contains("+") || value.contains("-")
        }
    }

}