package com.dicoding.kophie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvDrinks : RecyclerView
    private val list = ArrayList<Drinks>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDrinks = findViewById(R.id.rv_drinks)
        rvDrinks.setHasFixedSize(true)

        list.addAll(getListDrinks())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListDrinks(): ArrayList<Drinks> {
        val dataName = resources.getStringArray(R.array.data_drinks)
        val dataDescription = resources.getStringArray(R.array.data_description_drinks)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_drinks)
        val dataIngredients = resources.getStringArray(R.array.data_ingredients_drinks)
        val listDrink = ArrayList<Drinks>()
        for (i in dataName.indices) {
            val drink = Drinks(dataName[i], dataDescription[i], dataIngredients[i], dataPhoto.getResourceId(i, -1))
            listDrink.add(drink)
        }
        return listDrink
    }

    private fun showRecyclerList() {
        rvDrinks.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListDrinkAdapter(list)
        rvDrinks.adapter = listHeroAdapter
    }
}