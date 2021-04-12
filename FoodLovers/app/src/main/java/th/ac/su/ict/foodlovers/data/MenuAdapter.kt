package th.ac.su.ict.foodlovers.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item.view.*
import th.ac.su.ict.foodlovers.R
import java.util.zip.Inflater
import javax.sql.CommonDataSource

class MenuAdapter(private val context: Context,
                  private val dataSource: ArrayList<Menu>) : BaseAdapter(){

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item,null)
        rowView.tvName.text = dataSource[position].menuName
        rowView.tvLocation.text = dataSource[position].restaurantName
        rowView.tvPrice.text = dataSource[position].price.toString()+" Baht"

        val res = context.resources
        val drawable:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.imgName.setImageResource(drawable)
        val star:Int = dataSource[position].stars
        Log.i("asd",star.toString())
        when (star) {
            1 -> rowView.imgStar1.setImageResource(R.drawable.star)
            2 -> {rowView.imgStar1.setImageResource(R.drawable.star)
                rowView.imgStar2.setImageResource(R.drawable.star)
            }
            3 -> {
                rowView.imgStar3.setImageResource(R.drawable.star)
                rowView.imgStar2.setImageResource(R.drawable.star)
                rowView.imgStar1.setImageResource(R.drawable.star)
            }
            4 -> {
                rowView.imgStar4.setImageResource(R.drawable.star)
                rowView.imgStar3.setImageResource(R.drawable.star)
                rowView.imgStar2.setImageResource(R.drawable.star)
                rowView.imgStar1.setImageResource(R.drawable.star)
            }
            5 -> {
                rowView.imgStar5.setImageResource(R.drawable.star)
                rowView.imgStar4.setImageResource(R.drawable.star)
                rowView.imgStar3.setImageResource(R.drawable.star)
                rowView.imgStar2.setImageResource(R.drawable.star)
                rowView.imgStar1.setImageResource(R.drawable.star)
            }
            else -> { // Note the block

            }
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return  dataSource.size
    }

}