package es.usj.androidapps.alu100485.ho

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.telephony.PhoneNumberUtils.formatNumber
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_c.*
import java.util.regex.Pattern

class Activity_c : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        var id = intent.extras?.getString("id")
        tvCompanyData.setText(id)

        etPhone.addTextChangedListener(textWatcher)

        btnCall.setOnClickListener {
            val phoneNumber = etPhone.text.toString()
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")))
        }

        btnSend.setOnClickListener {
            val email = etEmail.text.toString()
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null)))
        }

        btnOpen.setOnClickListener {
            var url = etUrl.text.toString()
            if (!url.startsWith("http://") && !url.startsWith("https://"))
                url = "http://$url"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }

    val textWatcher = object : TextWatcher {
        var unlock3 = false
        var unlock4 = false
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        fun isEmailValid(email: String): Boolean {
            return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            var phonePattern = Regex("d{9}")
            var mailPattern = Regex("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}")
            //Patterns.PHONE.matcher(etPhone.text.toString()).matches()
           if(phonePattern.matches(etPhone.text.toString())){
                btnCall.isEnabled = true
                btnCall.isClickable = true
            }
            else{
                btnCall.isEnabled = true
                btnCall.isClickable = true
            }

            if(isEmailValid(etEmail.text.toString())){
                btnSend.isEnabled = true
                btnSend.isClickable = true
            }
            else{
                btnSend.isEnabled = true
                btnSend.isClickable = true
            }

        }
    }
}