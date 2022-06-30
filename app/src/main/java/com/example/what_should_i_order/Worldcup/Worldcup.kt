package com.example.what_should_i_order.Worldcup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.what_should_i_order.R
import kotlinx.android.synthetic.main.activity_worldcup.*

class Worldcup : AppCompatActivity() {

    var food_1Round: ArrayList<String> = ArrayList()

    var food_2Round: ArrayList<String> = ArrayList()

    var food_3Round: ArrayList<String> = ArrayList()

    var food_Final: ArrayList<String> = ArrayList()

    var count = 0

    var game_count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worldcup)

        world_back.setOnClickListener {
            finish()
        }

        for (i in 0..31) {
            food_1Round.add(i.toString())
        }

        food_1Round.shuffle()



        game_count_text.text = "$game_count/ 16"


        if(game_count <= 16) {

            left_food.text = food_1Round[count]!!
            right_food.text = food_1Round[count + 1]!!


            left_card.setOnClickListener {
                try {
                    count += 2
                    game_count++
                    left_food.text = food_1Round[count]!!
                    right_food.text = food_1Round[count + 1]!!
                    game_count_text.text = "$game_count / 16"
                    food_2Round.add(left_food.text.toString())
                } catch (e: Exception) {
                    Toast.makeText(this@Worldcup, "게임이 끝났습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            right_card.setOnClickListener {
                try {
                    count += 2
                    game_count++
                    left_food.text = food_1Round[count]!!
                    right_food.text = food_1Round[count + 1]!!
                    game_count_text.text = "$game_count / 16"
                } catch (e: Exception) {
                    Toast.makeText(this@Worldcup, "게임이 끝났습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }

}