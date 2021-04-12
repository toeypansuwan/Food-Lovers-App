package th.ac.su.ict.foodlovers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.ict.foodlovers.data.Menu
import th.ac.su.ict.foodlovers.data.MenuAdapter

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Menu> = ArrayList<Menu>()
    lateinit var arrayAdapter: ArrayAdapter<Menu>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jsonFileString = getJsonDataFromAsset(applicationContext,"restaurant_data.json")

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Menu>>(){}.type
        var menuList : ArrayList<Menu> = gson.fromJson(jsonFileString,listItemType)

        itemList = menuList
        val adapter = MenuAdapter(this@MainActivity,menuList)

        listItem.adapter = adapter

        listItem.setOnItemClickListener {_, _, position,_->
            var intent = Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra("name",itemList[position].menuName)
            intent.putExtra("img",itemList[position].imageFile)
            intent.putExtra("location",itemList[position].restaurantName)
            intent.putExtra("star",itemList[position].stars)
            intent.putExtra("detail",itemList[position].detail)

            startActivity(intent)
        }
    }
}