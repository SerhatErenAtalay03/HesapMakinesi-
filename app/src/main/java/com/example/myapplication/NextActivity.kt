package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        loadSharedPage()
        loadIntentData()

    }

    fun setupBinding(){
        binding= ActivityNextBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }


  fun loadIntentData(){
      val intent = getIntent()
      val name = intent.getStringExtra("name")
      val userName = intent.getStringExtra("userName")
      binding.userNameText.text="User Name: "+ userName
      binding.nameSurnameText.text="Name: " + name


  }


    fun loadSharedPage(){
       sharedPreferences = this.getSharedPreferences("com.example.myapplication", MODE_PRIVATE)
      val userName = sharedPreferences.getString("userName","null")
      val name=sharedPreferences.getString("name","null")

       if(name==""){
           binding.nameSurnameText.text="Ad Soyad değeriniz boş"

       }
       else{
           binding.nameSurnameText.text="Ad Soyad:" + name

       }

       if(userName==""){
           binding.userNameText.text="Kullanıcı adı değeriniz boş"
       }
       else{
           binding.userNameText.text="Kullanıcı adınız: " + userName
       }

   }

    fun toplaButtonClick(view: View){
      val ilkSayiText= binding.ilkSayi.text
       val ikinciSayiText=binding.ikinciSayi.text
        if(ilkSayiText.isEmpty() || ikinciSayiText.isEmpty()){
            binding.sonucTextView.text="Değer girişi yapılmadı lütfen tekrar deneyiniz"
        }
      else{
          val result= ilkSayiText.toString().toInt() + ikinciSayiText.toString().toInt()
            binding.sonucTextView.text="İşleminizin Sonucu: ${result}"
        }



    }

    fun cikartButtonClick(view: View){
        val ilkSayiText= binding.ilkSayi.text
        val ikinciSayiText=binding.ikinciSayi.text
        if(ilkSayiText.isEmpty() || ikinciSayiText.isEmpty()){
            binding.sonucTextView.text="Değer girişi yapılmadı lütfen tekrar deneyiniz"
        }
        else{
            val result= ilkSayiText.toString().toInt() - ikinciSayiText.toString().toInt()
            binding.sonucTextView.text="İşleminizin Sonucu: ${result}"
        }




    }

    fun carpButtonClick(view: View){
        val ilkSayiText= binding.ilkSayi.text
        val ikinciSayiText=binding.ikinciSayi.text
        if(ilkSayiText.isEmpty() || ikinciSayiText.isEmpty()){
            binding.sonucTextView.text="Değer girişi yapılmadı lütfen tekrar deneyiniz"
        }
        else{
            val result= ilkSayiText.toString().toInt() * ikinciSayiText.toString().toInt()
            binding.sonucTextView.text="İşleminizin Sonucu: ${result}"
        }


    }

   fun bolButtonClick(view: View){
       val ilkSayiText= binding.ilkSayi.text
       val ikinciSayiText=binding.ikinciSayi.text
       if(ilkSayiText.isEmpty() || ikinciSayiText.isEmpty()){
           binding.sonucTextView.text="Değer girişi yapılmadı lütfen tekrar deneyiniz"
       }
       else{
           val result= ilkSayiText.toString().toDouble() / ikinciSayiText.toString().toDouble()
           binding.sonucTextView.text="İşleminizin Sonucu: ${result}"
       }





   }









}