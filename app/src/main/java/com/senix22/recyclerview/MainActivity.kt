package com.senix22.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private val TAG = "My_LOG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = RelativesAdapter(initFamily() as List<Person>)


    }
}

fun initFamily(): List<Person?> {
    val momGrandmom = Person("Lesya", 87, null, null)
    val momMom = Person("Olha", 64, momGrandmom, null)
    val momDad = Person("Stanislav", 67, null, null)
    val mom = Person("Veronika", 45, momMom, momDad)
    val dadGranddad = Person("Muroslav", 95, null, null)
    val dadGrandMom = Person("Lydmula", 89, null, null)
    val dadDad = Person("Leonid", 65, dadGrandMom, dadGranddad)
    val dadMom = Person("Alla", 64, null, null)
    val dad = Person("Sergey", 43, dadMom, dadDad)
    val me = Person("Oleh", 20, mom, dad)
    return getListOfRelatives(me)
}