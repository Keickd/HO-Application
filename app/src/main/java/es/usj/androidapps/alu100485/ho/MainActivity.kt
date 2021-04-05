package es.usj.androidapps.alu100485.ho

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var userOk = false
    var userPass = false
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAnalytics = Firebase.analytics
        mFirebaseAnalytics.setUserProperty("user_type", "standard")

        etUser.addTextChangedListener(CustomTextWatcher({
            if (!etUser.text.isNullOrBlank()) userOk = true
            else userOk = false

            checkUserAndPass()
        }))

        etPassword.addTextChangedListener(CustomTextWatcher({
            if (!etPassword.text.isNullOrBlank()) userPass = true
            else userPass = false

            checkUserAndPass()
        }))

        btnLogin.setOnClickListener {
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, null)
            val intentFromAToB = Intent(this, Activity_b::class.java)
            startActivity(intentFromAToB)
        }
    }

    private fun checkUserAndPass(){
        if(userOk && userPass){
            btnLogin.isEnabled = true
            btnLogin.isClickable = true
        }else{
            btnLogin.isEnabled = false
            btnLogin.isClickable = false
        }
    }

    /*override fun onDestroy(){
        super.onDestroy()
        mFirebaseAnalytics.resetAnalyticsData()
    }*/
}

class CustomTextWatcher(private val callback: () -> Unit) : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
    override fun afterTextChanged(s: Editable?) { }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        this.callback()
    }
}
