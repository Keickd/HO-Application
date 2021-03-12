package es.usj.androidapps.alu100485.ho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_d.*

class Activity_d : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        val orange = 15
        val yellow = 17
        val avocado = 21
        var total = 0
        cbOrange.setOnCheckedChangeListener { buttonView, isChecked ->
            if(cbOrange.isChecked)
                total += orange
            else
                total -= orange

            etWeightValue.text = "$total";
        }

        cbYellow.setOnCheckedChangeListener { buttonView, isChecked ->
            if(cbOrange.isChecked)
                total += yellow
            else
                total -= yellow

            etWeightValue.text = "$total";
        }

        cbAguacate.setOnCheckedChangeListener { buttonView, isChecked ->
            if(cbOrange.isChecked)
                total += avocado
            else
                total -= avocado

            etWeightValue.text = "$total";
        }
    }
}