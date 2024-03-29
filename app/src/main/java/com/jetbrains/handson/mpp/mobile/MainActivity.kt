package com.jetbrains.handson.mpp.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()

        button_call_api.setOnClickListener {
            val weatherApi = WeatherApi()
            val repo = WeatherRepositoryImpl(weatherApi)
            repo.sendTracking("data") {
                println("result $it")
            }
        }
    }
}
