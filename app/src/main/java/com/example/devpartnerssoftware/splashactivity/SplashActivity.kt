package com.example.devpartnerssoftware.splashactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.devpartnerssoftware.splashactivity.util.SessionStore
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        Handler().postDelayed({

            val email = SessionStore().restoreEmail(this)
            if(email.isEmpty()){
                startActivity<LoginActivity>()
            }else{
                startActivity<HomeActivity>()
            }
            finish()
        }, 1000)
    }
}
