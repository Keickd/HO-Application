package es.usj.androidapps.alu100485.ho

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_c.*

class Activity_c : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        var id = intent.extras?.getString("id")
        tvCompanyData.setText(id)

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
}