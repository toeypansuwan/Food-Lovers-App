package th.ac.su.ict.foodlovers.data

data class Menu(
    val imageFile:String,
    val menuName:String,
    val restaurantName:String,
    val price:Int,
    val stars:Int,
    val detail:String
)