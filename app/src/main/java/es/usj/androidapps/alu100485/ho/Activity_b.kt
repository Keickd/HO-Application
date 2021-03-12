package es.usj.androidapps.alu100485.ho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b.*

class Activity_b : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val spinnerData = arrayOf("Country","Spain","USA","UK","JAPAN")
        spCountry.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerData)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if(rbtnCitizen.isChecked){
                etCompanyID.visibility = INVISIBLE
                spCountry.visibility = INVISIBLE
                btnInitOpCompany.visibility = INVISIBLE

            }else {
                rbtnCompany.setOnClickListener {
                    etCompanyID.visibility = VISIBLE
                    spCountry.visibility = VISIBLE
                    btnInitOpCompany.visibility = VISIBLE

                }
            }
        })
    }
}