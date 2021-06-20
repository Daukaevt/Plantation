package com.wixsite.mupbam1.resume.plantation11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.wixsite.mupbam1.resume.plantation11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.victory,
        R.drawable.malina,
        R.drawable.blueberry,
        R.drawable.klyukva,
        R.drawable.kryejovnik)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init() = with(binding){
        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        rcView.adapter = adapter
        buttonAdd.setOnClickListener(){
            if (index > imageIdList.size-1) index = 0
            val plant = Plant(imageIdList[index], "Plant")
            adapter.addPlant(plant)
            index++
        }
    }
}