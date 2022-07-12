package com.example.what_should_i_order.Kalori

import com.google.gson.annotations.SerializedName

class Food_Class(
    val currentCount:Int,

    val data:List<data>,

    var matchCount: String,

    var page: String,

    var perPage: String,

    var totalCount: String,
) {
    override fun toString(): String {
        return "Consult_class(currentCount=$currentCount, " +
                "data=$data, matchCount='$matchCount'," +
                " page='$page', perPage='$perPage', " +
                "totalCount='$totalCount')"
    }
}
data class data (
    @SerializedName("음식명") val Food_name:String,
    @SerializedName("1인분칼로리(kcal)") val  Food_kalori :String,
    @SerializedName("나트륨(g)") val Food_salt :String,
    @SerializedName("단백질(g)") val Food_protein :String,
) {
    override fun toString(): String {
        return "data(Food_name='$Food_name', " +
                "Food_kalori='$Food_kalori'," +
                " Food_salt='$Food_salt'," +
                " Food_protein='$Food_protein')"
    }
}