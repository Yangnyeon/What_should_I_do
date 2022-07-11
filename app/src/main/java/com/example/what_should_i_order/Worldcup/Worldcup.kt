package com.example.what_should_i_order.Worldcup

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    var food_1Round: ArrayList<Food_Data> = ArrayList()

    var food_2Round: ArrayList<Food_Data> = ArrayList()

    var food_3Round: ArrayList<Food_Data> = ArrayList()

    var food_4Round: ArrayList<Food_Data> = ArrayList()

    var food_Final: ArrayList<Food_Data> = ArrayList()

    var count = -2

    var count_2Round = 0

    var count_3Round = 0

    var count_4Round = 0

    var game_count = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worldcup)

        world_back.setOnClickListener {
            finish()
        }

        /*for (i in 0..31) {
            food_1Round.add(i.toString())
        }*/

        /*
        food_1Round.add("곱창")
        food_1Round.add("보쌈")
        food_1Round.add("짜장면")
        food_1Round.add("짬뽕")
        food_1Round.add("엽떡")

        for (i in 0..26) {
         food_1Round.add(i.toString())
        }*/

        food_1Round.apply {
            add(Food_Data(Food_Image = R.drawable.tteokbokki1,Food_text = "떡볶이"))
            add(Food_Data(Food_Image = R.drawable.ramen1,Food_text = "라면"))
            add(Food_Data(Food_Image = R.drawable.zzimchicken,Food_text = "찜닭"))
            add(Food_Data(Food_Image = R.drawable.chickenboggum,Food_text = "닭볶음탕"))
            add(Food_Data(Food_Image = R.drawable.watermeet,Food_text = "수육"))
            add(Food_Data(Food_Image = R.drawable.gopchang,Food_text = "곱창"))
            add(Food_Data(Food_Image = R.drawable.armystew,Food_text = "부대찌개"))
            add(Food_Data(Food_Image = R.drawable.chicken,Food_text = "치킨"))
            add(Food_Data(Food_Image = R.drawable.curry,Food_text = "카레"))
            add(Food_Data(Food_Image = R.drawable.sundaegguk,Food_text = "순댓국"))
            add(Food_Data(Food_Image = R.drawable.pasta,Food_text = "파스타"))
            add(Food_Data(Food_Image = R.drawable.sphagetti,Food_text = "스파게티"))
            add(Food_Data(Food_Image = R.drawable.icemen,Food_text = "냉면"))
            add(Food_Data(Food_Image = R.drawable.crab,Food_text = "간장 게장"))
            add(Food_Data(Food_Image = R.drawable.congguksu,Food_text = "콩국수"))
            add(Food_Data(Food_Image = R.drawable.sushi,Food_text = "초밥"))
            add(Food_Data(Food_Image = R.drawable.zzazang,Food_text = "짜장면"))
            add(Food_Data(Food_Image = R.drawable.meetshshi,Food_text = "육회"))
            add(Food_Data(Food_Image = R.drawable.hanburger,Food_text = "햄버거"))
            add(Food_Data(Food_Image = R.drawable.pizza,Food_text = "피자"))
            add(Food_Data(Food_Image = R.drawable.toast,Food_text = "토스트"))
            add(Food_Data(Food_Image = R.drawable.staek,Food_text = "스테이크"))
            add(Food_Data(Food_Image = R.drawable.hotdog,Food_text = "핫도그"))
            add(Food_Data(Food_Image = R.drawable.mandu,Food_text = "만두"))
            add(Food_Data(Food_Image = R.drawable.donggas,Food_text = "돈까스"))
            add(Food_Data(Food_Image = R.drawable.zzambbong,Food_text = "짬뽕"))
            add(Food_Data(Food_Image = R.drawable.zokbal1,Food_text = "족발"))
            add(Food_Data(Food_Image = R.drawable.samgaetang,Food_text = "삼계탕"))
            add(Food_Data(Food_Image = R.drawable.chickenfoog,Food_text = "닭발"))
            add(Food_Data(Food_Image = R.drawable.sam,Food_text = "삼겹살"))
            add(Food_Data(Food_Image = R.drawable.hotchicken,Food_text = "양념치킨"))
            add(Food_Data(Food_Image = R.drawable.tang,Food_text = "탕수육"))
        }

        food_1Round.shuffle()




        game_count_text.text = "$game_count / 16\n" + food_2Round.size

        left_food.text = "배달 이상형"

        right_food.text = "월드컵 시작"

        left_card.setOnClickListener {
            count += 2
            game_count++
            game.visibility = View.INVISIBLE
            start.visibility = View.INVISIBLE
            left_food.visibility = View.VISIBLE
            right_food.visibility = View.VISIBLE
            if (game_count <= 16 && game_count >= 1) {

                left_food.text = food_1Round[count].Food_text.toString()!!
                right_food.text = food_1Round[count + 1].Food_text.toString()!!

                left_iamge.setImageResource(food_1Round[count].Food_Image)
                right_iamge.setImageResource(food_1Round[count + 1].Food_Image)

                game_count_text.text = "$game_count / 16"

                food_2Round.apply {
                    add(Food_Data(Food_Image = food_1Round[count].Food_Image, Food_text = food_1Round[count].Food_text.toString()!!))
                }

                food_2Round.shuffle()
            } else if (game_count <= 24 && game_count >= 2) {

                count_2Round += 2

                left_food.text = food_2Round[count_2Round - 2].Food_text.toString()!!
                right_food.text = food_2Round[count_2Round - 1].Food_text.toString()!!

                left_iamge.setImageResource(food_2Round[count_2Round - 2].Food_Image)
                right_iamge.setImageResource(food_2Round[count_2Round - 1].Food_Image)

                game_count_text.text =
                    (game_count - 16.toInt()).toString() + " / 8\n"

                round.text = "16강"

                food_3Round.apply {
                    add(
                        Food_Data(
                            Food_Image = food_2Round[count_2Round - 2].Food_Image,
                            Food_text = food_2Round[count_2Round - 2].Food_text.toString()!!
                        )
                    )
                }


                food_3Round.shuffle()

            } else if (game_count <= 28 && game_count >= 2) {

                count_3Round += 2

                left_food.text = food_3Round[count_3Round - 2].Food_text.toString()!!
                right_food.text = food_3Round[count_3Round - 1].Food_text.toString()!!

                left_iamge.setImageResource(food_3Round[count_3Round - 2].Food_Image)
                right_iamge.setImageResource(food_3Round[count_3Round - 1].Food_Image)


                game_count_text.text = (game_count - 24.toInt()).toString() + " / 4"
                round.text = "8강"

                food_4Round.apply {
                    add(
                        Food_Data(
                            Food_Image = food_3Round[count_3Round - 2].Food_Image,
                            Food_text = food_3Round[count_3Round - 2].Food_text.toString()!!
                        )
                    )
                }

                food_4Round.shuffle()

            } else if (game_count <= 30 && game_count >= 2) {

                count_4Round += 2

                //
                left_food.text = food_4Round[count_4Round - 2].Food_text.toString()!!
                right_food.text = food_4Round[count_4Round - 1].Food_text.toString()!!

                left_iamge.setImageResource(food_4Round[count_4Round - 2].Food_Image)
                right_iamge.setImageResource(food_4Round[count_4Round - 1].Food_Image)

                //


                game_count_text.text = (game_count - 28.toInt()).toString() + " / 2"
                round.text = "4강"

                food_Final.apply {
                    add(
                        Food_Data(
                            Food_Image = food_4Round[count_4Round - 2].Food_Image,
                            Food_text = food_4Round[count_4Round - 2].Food_text.toString()!!
                        )
                    )
                }

                food_Final.shuffle()
            } else if (game_count <= 31 && game_count >= 1) {
                round.text = "결승전 \n"
                game_count_text.text = ""

                left_food.text = food_Final[0].Food_text.toString()!!
                right_food.text = food_Final[1].Food_text.toString()!!

                left_iamge.setImageResource(food_Final[0].Food_Image)
                right_iamge.setImageResource(food_Final[1].Food_Image)

            } else {
                Toast.makeText(
                    this@Worldcup,
                    left_food.text.toString() + "우승입니다!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }



        right_card.setOnClickListener {
            count += 2
            game_count++
            game.visibility = View.INVISIBLE
            start.visibility = View.INVISIBLE
            left_food.visibility = View.VISIBLE
            right_food.visibility = View.VISIBLE
            if (game_count <= 16 && game_count >= 1) {

                left_food.text = food_1Round[count].Food_text.toString()!!
                right_food.text = food_1Round[count + 1].Food_text.toString()!!

                left_iamge.setImageResource(food_1Round[count].Food_Image)
                right_iamge.setImageResource(food_1Round[count + 1].Food_Image)

                game_count_text.text = "$game_count / 16"

                food_2Round.apply {
                    add(Food_Data(Food_Image = food_1Round[count + 1].Food_Image, Food_text = food_1Round[count + 1].Food_text.toString()!!))
                }

                food_2Round.shuffle()
            } else if (game_count <= 24 && game_count >= 2) {

                count_2Round += 2

                left_food.text = food_2Round[count_2Round - 2].Food_text.toString()!!
                right_food.text = food_2Round[count_2Round - 1].Food_text.toString()!!

                left_iamge.setImageResource(food_2Round[count_2Round - 2].Food_Image)
                right_iamge.setImageResource(food_2Round[count_2Round - 1].Food_Image)

                game_count_text.text =
                    (game_count - 16.toInt()).toString() + " / 8\n"

                round.text = "16강"

                food_3Round.apply {
                    add(
                        Food_Data(
                            Food_Image = food_2Round[count_2Round - 1].Food_Image,
                            Food_text = food_2Round[count_2Round - 1].Food_text.toString()!!
                        )
                    )
                }


                food_3Round.shuffle()

            } else if (game_count <= 28 && game_count >= 2) {

                count_3Round += 2

                left_food.text = food_3Round[count_3Round - 2].Food_text.toString()!!
                right_food.text = food_3Round[count_3Round - 1].Food_text.toString()!!

                left_iamge.setImageResource(food_3Round[count_3Round - 2].Food_Image)
                right_iamge.setImageResource(food_3Round[count_3Round - 1].Food_Image)


                game_count_text.text = (game_count - 24.toInt()).toString() + " / 4"
                round.text = "8강"

                food_4Round.apply {
                    add(
                        Food_Data(
                            Food_Image = food_3Round[count_3Round - 1].Food_Image,
                            Food_text = food_3Round[count_3Round - 1].Food_text.toString()!!
                        )
                    )
                }

                food_4Round.shuffle()

            } else if (game_count <= 30 && game_count >= 2) {

                count_4Round += 2

                //
                left_food.text = food_4Round[count_4Round - 2].Food_text.toString()!!
                right_food.text = food_4Round[count_4Round - 1].Food_text.toString()!!

                left_iamge.setImageResource(food_4Round[count_4Round - 2].Food_Image)
                right_iamge.setImageResource(food_4Round[count_4Round - 1].Food_Image)

                //


                game_count_text.text = (game_count - 28.toInt()).toString() + " / 2"
                round.text = "4강"

                food_Final.apply {
                    add(
                        Food_Data(
                            Food_Image = food_4Round[count_4Round - 1].Food_Image,
                            Food_text = food_4Round[count_4Round - 1].Food_text.toString()!!
                        )
                    )
                }

                food_Final.shuffle()
            } else if (game_count <= 31 && game_count >= 1) {
                round.text = "결승전 \n"

                game_count_text.text = ""



                left_food.text = food_Final[0].Food_text.toString()!!
                right_food.text = food_Final[1].Food_text.toString()!!

                left_iamge.setImageResource(food_Final[0].Food_Image)
                right_iamge.setImageResource(food_Final[1].Food_Image)

            } else {
                Toast.makeText(
                    this@Worldcup,
                    right_food.text.toString() + "우승입니다!",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }

}


