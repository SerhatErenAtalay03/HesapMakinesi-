package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }
  fun setupBinding(){
      binding= ActivityMainBinding.inflate(layoutInflater)
      val view=binding.root
      setContentView(view)

   }




  fun loginAction(view: View){
    //Burada shared a kayıt yapacağız
      sharedPreferences=this.getSharedPreferences("com.example.myapplication", MODE_PRIVATE)
      val userName=binding.userNameTextViewer.text.toString()
      var name=binding.nameTextViewer.text.toString()

      sharedPreferences.edit().putString("userName",userName).apply()
      sharedPreferences.edit().putString("name",name).apply()


      val intent=Intent(applicationContext, NextActivity::class.java)
      intent.putExtra("userName",binding.userNameTextViewer.text.toString())
      intent.putExtra("name",binding.nameTextViewer.text.toString())
      startActivity(intent)

  }




}