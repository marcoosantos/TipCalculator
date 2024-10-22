package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtbill = findViewById<TextInputEditText>(R.id.bill)
        val edttip = findViewById<TextInputEditText>(R.id.tip)
        val edtsplit = findViewById<TextInputEditText>(R.id.people)

        val btncalcular = findViewById<Button>(R.id.calculate)

        btncalcular.setOnClickListener {

            val billStr: String = edtbill.text.toString()
            val tipStr: String = edttip.text.toString()
            val splitStr: String = edtsplit.text.toString()

            if (billStr == "" || tipStr == "" || splitStr == "") {

                Snackbar
                    .make(
                        edttip,
                        "fill in all the fields",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val bill = billStr.toFloat()
                val tip = tipStr.toFloat()
                val split = splitStr.toFloat()

                val totaltip = tip / 100
                val totaltipQ2 = bill * totaltip
                val totalbill = totaltipQ2 + bill
                val totalperson = totalbill / split

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(TOTAL_TIP, totaltipQ2)
                intent.putExtra(TOTAL_BILL, totalbill)
                intent.putExtra(TOTAL_PERSON, totalperson)
                startActivity(intent)

            }
        }
    }
}
