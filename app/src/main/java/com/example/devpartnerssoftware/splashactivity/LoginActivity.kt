package com.example.devpartnerssoftware.splashactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.devpartnerssoftware.splashactivity.util.SessionStore
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        loginButton.onClick{
            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()

            validate(email, password)
        }
    }

    private fun validate(email : String, password: String){
        if(email.isEmpty() && password.isEmpty()){
            alert("Enter email and password", "Error"){
                okButton { return@okButton }
            }.show()
        }else if(email.isEmpty()){
            alert("Enter email", "Error"){
                okButton { return@okButton }
            }.show()
        }else if(password.isEmpty()){
            alert("Enter password", "Error"){
                okButton { return@okButton }
            }.show()
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            alert("Email not valid", "Error"){
                okButton { return@okButton }
            }.show()
        } else if(email.equals("reymondinagat@gmail.com") && password.equals("fuckthis")){
            startActivity<SplashActivity>()
            val store = SessionStore()
            store.saveEmail(email, this)
            finish()
        }else if(!email.equals("reymondinagat@gmail.com")){
            alert("Email not register", "Error"){
                okButton { return@okButton }
            }.show()
        }else{
            alert("Wrong password", "Error"){
                okButton { return@okButton }
            }.show()
        }
    }
}


