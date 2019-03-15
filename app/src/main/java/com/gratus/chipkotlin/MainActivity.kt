package com.gratus.chipkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.CompoundButton
import android.widget.Toast


import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)
        var chip: Chip? = null
        val colorCollection = ArrayList<Int>()
        colorCollection.add(R.color.colorPrimary)
        colorCollection.add(R.color.colorPrimaryDark)
        colorCollection.add(R.color.colorAccent)
        var j = 0
        for (i in 0..4) {
            chip = Chip(this@MainActivity)
            chip.text = "Chip No : $i"
            chip.isCheckable = true
            chip.setChipBackgroundColorResource(colorCollection[j])
            if (j == 2) {
                j = 0
            } else {
                j++
            }
            chipGroup.addView(chip)
            chipGroup.isSingleSelection = true
            chip.setOnCheckedChangeListener { compoundButton, b ->
                if (b == true)

                    Toast.makeText(applicationContext, compoundButton.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }
}
