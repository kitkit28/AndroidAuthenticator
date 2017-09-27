package com.example.devpartnerssoftware.splashactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.devpartnerssoftware.splashactivity.util.SessionStore
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        logoutButton.onClick{
            logout()
        }
    }

    private fun logout() {

        SessionStore().clearEmail(this)

        startActivity<SplashActivity>()
    }
}
