package com.dicoding.kophie

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity(){
    private lateinit var imgDrink : ImageView
    private lateinit var tvDrinkName : TextView
    private lateinit var tvDrinkDescription : TextView
    private lateinit var btnIngredients : Button
    private lateinit var btnDesc : Button
    private lateinit var btnShare : Button

    companion object {
        const val KEY_DRINKS = "key_drinks"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imgDrink = findViewById(R.id.img_drink)
        tvDrinkName = findViewById(R.id.tv_drinks_name)
        tvDrinkDescription = findViewById(R.id.tv_drinks_description)
        btnIngredients = findViewById(R.id.btn_ingredients)
        btnDesc = findViewById(R.id.btn_desc)
        btnShare = findViewById(R.id.btn_share)


        val drinks = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_DRINKS, Drinks::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_DRINKS)
        }

        drinks?.image?.let { imgDrink.setImageResource(it) }
        tvDrinkName.text = drinks?.namaMinum
        tvDrinkDescription.text = drinks?.deskripsi

        btnIngredients.setOnClickListener{
            tvDrinkDescription.text = drinks?.ingredients
        }

        btnDesc.setOnClickListener{
            tvDrinkDescription.text = drinks?.deskripsi
        }

        btnShare.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Halo saya baru saja melihat infromasi mengenai ${drinks?.namaMinum}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home-> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.action_about -> {
                val moveIntent = Intent(this@DetailActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}