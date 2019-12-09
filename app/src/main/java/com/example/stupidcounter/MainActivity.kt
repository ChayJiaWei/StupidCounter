package com.example.stupidcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declaer an instance of ViewModel
    private lateinit var counterViewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","OnCreate")

        //Initialize the ViewModel
        counterViewModel = ViewModelProviders.of(this)
            .get(CounterViewModel::class.java)

        //Add an observer to ViewModel
        counterViewModel.counter.observe(
            this,
            Observer {
                if (counterViewModel.counter.value == 10){
                    goodJob()
                }
            }
        )

    buttonIncrease.setOnClickListener{
        counterViewModel.increment()
        textViewCounter.text = counterViewModel.counter.toString()
    }

        buttonDecrease.setOnClickListener {
            counterViewModel.decrement()
            textViewCounter.text = counterViewModel.counter.toString()
        }
}

    private fun goodJob() {
        Toast.makeText(applicationContext,"Congratulation!!!",
            Toast.LENGTH_LONG).show()

    }

    override fun onDestroy() {
        Log.d("mainActivity","onDestroy")
        super.onDestroy()
    }


}


