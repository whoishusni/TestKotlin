package id.husni.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainRv : RecyclerView = findViewById(R.id.mainRview)
        mainRv.setHasFixedSize(true)
        list.addAll(getListHeroes())
        mainRv.layoutManager = LinearLayoutManager(this)
        val adapter = HeroAdapter(list)
        mainRv.adapter = adapter

    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()
        for (position in dataName.indices){
            val hero = Hero(
                dataName[position],
                dataDesc[position],
                dataPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }
}
