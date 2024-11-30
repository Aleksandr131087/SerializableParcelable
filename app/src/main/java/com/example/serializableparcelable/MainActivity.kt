package com.example.serializableparcelable

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var nameET: EditText
    private lateinit var familyET: EditText
    private lateinit var addressET: EditText
    private lateinit var phoneET: EditText
    private lateinit var saveButton: Button
    private lateinit var listView: ListView
    private val personList = mutableListOf<Person>()
    private val displayList = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameET = findViewById(R.id.NameET)
        familyET = findViewById(R.id.FamilyET)
        addressET = findViewById(R.id.AddressET)
        phoneET = findViewById(R.id.PhoneET)
        saveButton = findViewById(R.id.buttonSave)
        listView = findViewById(R.id.listView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, displayList)
        listView.adapter = adapter

        saveButton.setOnClickListener {
            val person = Person(nameET.text.toString(),
                familyET.text.toString(),
                addressET.text.toString(),
                phoneET.text.toString()
            )
            personList.add(person)
            displayList.add("${person.name} ${person.family}")
            adapter.notifyDataSetChanged()
            clearFields()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedPerson = personList[position]
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("person", selectedPerson)
            startActivity(intent)
        }
    }

    private fun clearFields() {
        nameET.text.clear()
        familyET.text.clear()
        addressET.text.clear()
        phoneET.text.clear()
    }
}

