package com.example.serializableparcelable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

    private lateinit var nameTV: TextView
    private lateinit var familyTV: TextView
    private lateinit var adressTV: TextView
    private lateinit var phoneTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        nameTV = findViewById(R.id.NameTV)
        familyTV = findViewById(R.id.FamilyTV)
        adressTV = findViewById(R.id.AddressTV)
        phoneTV = findViewById(R.id.PhoneTV)

        val person: Person? = intent.getParcelableExtra("person")
        person?.let {
            nameTV.text = "Имя: ${it.name}"
            familyTV.text ="Фамилия: ${it.family}"
            adressTV.text ="Адрес: ${it.address}"
            phoneTV.text = "Телефон: ${it.phone}"
        }


    }
}