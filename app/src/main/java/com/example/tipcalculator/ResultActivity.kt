package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

const val TOTAL_TIP = "ResultActivity.TIP_TC"
const val TOTAL_BILL = "ResultActivity.BILL_TC"
const val TOTAL_PERSON = "ResultActivity.PERSON_TC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val totaltip = intent.getFloatExtra(TOTAL_TIP,0f)
        val totalbill = intent.getFloatExtra(TOTAL_BILL,0f)
        val totalperson = intent.getFloatExtra(TOTAL_PERSON,0f)

        val tvtip = findViewById<TextView>(R.id.tipresult)
        val tvbill = findViewById<TextView>(R.id.paidresult)
        val tvperson = findViewById<TextView>(R.id.personresult)
        val Return = findViewById<Button>(R.id.Return)

        val formatter = DecimalFormat("#.##")
        tvtip.text = formatter.format(totaltip)
        tvbill.text = formatter.format(totalbill)
        tvperson.text = formatter.format(totalperson)

        Return.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        }
    }
