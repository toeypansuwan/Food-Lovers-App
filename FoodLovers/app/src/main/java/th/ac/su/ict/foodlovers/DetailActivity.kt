package th.ac.su.ict.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_item.view.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")
        val location = intent.getStringExtra("location")
        val stars = intent.getIntExtra("star",0)
        val detail = intent.getStringExtra("detail")
        val img = intent.getStringExtra("img")


        val res = resources
        val drawable:Int = res.getIdentifier(img,"drawable",packageName)
        imgDetail.setImageResource(drawable)
        tvName2.text = name
        tvLocation.text = location
        tvDetail.text = detail

        when (stars) {
            1 -> imgStarDetail1.setImageResource(R.drawable.star)
            2 -> {
                imgStarDetail1.setImageResource(R.drawable.star)
                imgStarDetail2.setImageResource(R.drawable.star)
            }
            3 -> {
                imgStarDetail1.setImageResource(R.drawable.star)
                imgStarDetail2.setImageResource(R.drawable.star)
                imgStarDetail3.setImageResource(R.drawable.star)
            }
            4 -> {
                imgStarDetail1.setImageResource(R.drawable.star)
                imgStarDetail2.setImageResource(R.drawable.star)
                imgStarDetail3.setImageResource(R.drawable.star)
                imgStarDetail4.setImageResource(R.drawable.star)
            }
            5 -> {
                imgStarDetail1.setImageResource(R.drawable.star)
                imgStarDetail2.setImageResource(R.drawable.star)
                imgStarDetail3.setImageResource(R.drawable.star)
                imgStarDetail4.setImageResource(R.drawable.star)
                imgStarDetail5.setImageResource(R.drawable.star)
            }
            else -> { // Note the block

            }
        }
    }
}