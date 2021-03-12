package es.usj.androidapps.alu100485.ho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUser.addTextChangedListener(textWatcher)
        etPassword.addTextChangedListener(textWatcher)
        btnLogin.setOnClickListener {
            val intentFromAToB = Intent(this,Activity_b::class.java)
            startActivity(intentFromAToB)
        }
    }
    private val textWatcher = object : TextWatcher {
        var unlock1 = false
        var unlock2 = false
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (etUser.text.toString() !="")
                unlock1 = true
            else
                unlock2 = false

            if (etPassword.text.toString() !="")
                unlock2 = true;
            else
                unlock2 = false

            if(unlock1 && unlock2) {
                btnLogin.isEnabled = true
                btnLogin.isClickable = true
            }else{
                btnLogin.isEnabled = false
                btnLogin.isClickable = false
            }
        }
    }
}