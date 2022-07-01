package com.example.what_should_i_order.Worldcup

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.setPadding
import com.example.what_should_i_order.R
import kotlinx.android.synthetic.main.activity_worldcup.*
import kotlin.math.sign

class Worldcup : AppCompatActivity() {

    var food_1Round: ArrayList<String> = ArrayList()

    var food_2Round: ArrayList<String> = ArrayList()

    var food_3Round: ArrayList<String> = ArrayList()

    var food_4Round: ArrayList<String> = ArrayList()

    var food_Final: ArrayList<String> = ArrayList()

    var count = 0

    var count_2Round = 0

    var count_3Round = 0

    var count_4Round = 0


    var game_count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worldcup)

        world_back.setOnClickListener {
            finish()
        }

        /*for (i in 0..31) {
            food_1Round.add(i.toString())
        }*/

        food_1Round.add("곱창")
        food_1Round.add("보쌈")
        food_1Round.add("짜장면")
        food_1Round.add("짬뽕")
        food_1Round.add("엽떡")

        for (i in 0..26) {
         food_1Round.add(i.toString())
     }

        food_1Round.shuffle()

        left_food.text = food_1Round[count]!!
        right_food.text = food_1Round[count + 1]!!


        if(game_count == 0) {
            left_card.setOnClickListener {
                food_2Round.add(left_food.text.toString())
                game_count++
            }
            right_card.setOnClickListener {
                food_2Round.add(right_food.text.toString())
                game_count++
            }
        }

        food_2Round.add(left_food.text.toString())

        game_count_text.text = "$game_count / 16"


        left_card.setOnClickListener {
            count += 2
            game_count++
            if (game_count <= 16) {

                left_food.text = food_1Round[count]!!
                right_food.text = food_1Round[count + 1]!!

                game_count_text.text = "$game_count / 16"

                food_2Round.add(left_food.text.toString())

                food_2Round.shuffle()
            } else if(game_count <= 24) {

                count_2Round += 2

                left_food.text = food_2Round[count_2Round - 2]
                right_food.text = food_2Round[count_2Round - 1]

                game_count_text.text =
                    (game_count - 16.toInt()).toString() + " / 8\n" + food_2Round.toString() + food_2Round.size + "\n" + "3라운드 추가된거 " + food_3Round.toString() + food_3Round.size +    game_count.toString()

                round.text = "16강"

                food_3Round.add(left_food.text.toString())


                food_3Round.shuffle()

            } else if(game_count <= 28) {

                count_3Round += 2

                left_food.text = food_3Round[count_3Round - 2]
                right_food.text = food_3Round[count_3Round - 1]

                game_count_text.text = (game_count - 24.toInt()).toString() + " / 4" + food_3Round.toString() + food_3Round.size + "\n" + "4강에 추가된거" + food_4Round.toString() + food_4Round.size + "게임 카운트 " + game_count.toString()
                round.text = "8강"

                food_4Round.add(left_food.text.toString())

                food_4Round.shuffle()

            } else if(game_count <= 30) {

                count_4Round += 2

                left_food.text = food_4Round[count_4Round - 2]
                right_food.text = food_4Round[count_4Round - 1]

                game_count_text.text = (game_count - 28.toInt()).toString() + " / 4" + food_4Round.toString() + food_4Round.size + "\n" + "결승에 추가된거" + food_Final.toString() + food_Final.size + "게임 카운트 " + game_count.toString()
                round.text = "4강"

                food_Final.add(left_food.text.toString())

                food_Final.shuffle()
            } else if(game_count <= 31) {
                round.text = "결승전 \n"

                game_count_text.text = (game_count - 28.toInt()).toString() + " / 4" + food_Final.toString() + food_Final.size

                left_food.text = food_Final[0]
                right_food.text = food_Final[1]
            } else {
                Toast.makeText(this@Worldcup , left_food.text.toString() + "우승입니다!", Toast.LENGTH_SHORT).show()
            }


        }

        right_card.setOnClickListener {
            count += 2
            game_count++
            if (game_count <= 16) {

                left_food.text = food_1Round[count]!!
                right_food.text = food_1Round[count + 1]!!

                game_count_text.text = "$game_count / 16"

                food_2Round.add(right_food.text.toString())

                food_2Round.shuffle()
            } else if(game_count <= 24) {

                count_2Round += 2

                left_food.text = food_2Round[count_2Round - 2]
                right_food.text = food_2Round[count_2Round - 1]

                game_count_text.text =
                    (game_count - 16.toInt()).toString() + " / 8\n" + food_2Round.toString() + food_2Round.size + "\n" + "3라운드 추가된거 " + food_3Round.toString() + food_3Round.size +    game_count.toString()

                round.text = "16강"

                food_3Round.add(right_food.text.toString())


                food_3Round.shuffle()

            } else if(game_count <= 28) {

                count_3Round += 2

                left_food.text = food_3Round[count_3Round - 2]
                right_food.text = food_3Round[count_3Round - 1]

                game_count_text.text = (game_count - 24.toInt()).toString() + " / 4" + food_3Round.toString() + food_3Round.size + "\n" + "4강에 추가된거" + food_4Round.toString() + food_4Round.size + "게임 카운트 " + game_count.toString()
                round.text = "8강"

                food_4Round.add(right_food.text.toString())

                food_4Round.shuffle()

            } else if(game_count <= 30) {

                count_4Round += 2

                left_food.text = food_4Round[count_4Round - 2]
                right_food.text = food_4Round[count_4Round - 1]

                game_count_text.text = (game_count - 28.toInt()).toString() + " / 4" + food_4Round.toString() + food_4Round.size + "\n" + "결승에 추가된거" + food_Final.toString() + food_Final.size + "게임 카운트 " + game_count.toString()
                round.text = "4강"

                food_Final.add(right_food.text.toString())

                food_Final.shuffle()
            } else if(game_count <= 31) {
                round.text = "결승전 \n"

                game_count_text.text = (game_count - 28.toInt()).toString() + " / 4" + food_Final.toString() + food_Final.size

                left_food.text = food_Final[0]
                right_food.text = food_Final[1]
            } else {
                Toast.makeText(this@Worldcup , right_food.text.toString() + "우승입니다!", Toast.LENGTH_SHORT).show()
            }

        }

    }

}


