package com.dzl.registrationform

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dzl.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles: Array<String> = arrayOf("Mr.", "Ms", "Mrs", "Jr")
        val adapter = ArrayAdapter(
            this,
             android.R.layout.simple_list_item_1,
            titles
        )
        binding.autoCompleteTitle.setAdapter(adapter)

    }
}