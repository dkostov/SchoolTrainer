package com.example.ukkos.schooltrainer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent



val EXERCISES_MESSAGE = "com.example.ukkos.schooltrainer.EXERCISES_MESSAGE"

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    /** Called when the user taps the Exercises button  */
    fun sendMessageExercises(view: View) {
        val intent = Intent(this, BrowseExercises::class.java)
        val message = "<<todo: profile>>"
        intent.putExtra(EXERCISES_MESSAGE, message)
        startActivity(intent)
    }
}
