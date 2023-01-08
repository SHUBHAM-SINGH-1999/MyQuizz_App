package com.example.myquizzapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import androidx.core.content.ContextCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.newFixedThreadPoolContext

import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var flag: Int = 0

    var musername: String? = null
    var correctchoice: Int = 0

    var questiontv: TextView? = null
    var optionone: TextView? = null
    var optionTwo: TextView? = null
    var optionThree: TextView? = null
    var optionFour: TextView? = null
    var submit_btn: Button? = null

    var mquestionList: ArrayList<Question>? = null

    var currectQuestion: Int =1
    var clickedoption: Int = 0
    var arr2: IntArray? = null

    var totalquestion = 20                    // Total Question

    var numberofquestion: Int = 5               // Question Ask
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musername = intent.getStringExtra(Constants.USER_NAME)
        questiontv = findViewById(R.id.question_tv)
        optionone = findViewById(R.id.option_1)
        optionTwo = findViewById(R.id.option_2)
        optionThree = findViewById(R.id.opion_3)
        optionFour = findViewById(R.id.option_4)

        submit_btn = findViewById(R.id.button)
        mquestionList = Constants.getQuestion()

        optionone?.setOnClickListener(this)
        shuffle()
        setquestion()
    }


    fun setquestion(){
        if(counter<numberofquestion)
        {
            currectQuestion=arr2!![counter]

            counter++
        }

        val question = mquestionList!![currectQuestion-1]
        defauloptiontview()    // for reset the selected option for next question
        flag=0
        questiontv?.text = question.question
        optionone?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
        submit_btn?.text = question.Button

        optionone?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        submit_btn?.setOnClickListener(this)

    }
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {


        when(view?.id){

                optionone?.id ->{
                    if(flag==0){
                    defauloptiontview()
                    clickedoption = 1
                    optionone?.background = ContextCompat.getDrawable(this, R.drawable.ouline)}
                }
                optionTwo?.id ->{
                    if(flag==0){
                    defauloptiontview()
                    clickedoption = 2
                    optionTwo?.background = ContextCompat.getDrawable(this, R.drawable.ouline)}
                }
                optionThree?.id ->{
                    if(flag==0){
                    defauloptiontview()
                    clickedoption = 3
                    optionThree?.background = ContextCompat.getDrawable(this, R.drawable.ouline)}
                }
                optionFour?.id ->{
                    if(flag==0){
                    defauloptiontview()
                    clickedoption = 4
                    optionFour?.background = ContextCompat.getDrawable(this, R.drawable.ouline)}
                }


            submit_btn?.id ->{
                flag=1
                if(clickedoption ==0){
                    currectQuestion++
                    when{
//                        currectQuestion<=mquestionList!!.size->{setquestion()}
                        counter<numberofquestion->{setquestion()}
                        else->{
                            val intent = Intent(this,result::class.java)
                            intent.putExtra(Constants.USER_NAME,musername)
                            intent.putExtra(Constants.CORRECT_ANSWER,correctchoice)
                            intent.putExtra(Constants.TOTAL_QUESTION,numberofquestion)     // numberofquestion == mquestionList!!.size
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    if(clickedoption != mquestionList!![currectQuestion-1].correctOption){
                        answerview(clickedoption,R.drawable.wrong)
                    }else{
                        correctchoice++}
                    answerview(mquestionList!![currectQuestion-1].correctOption,R.drawable.correct)

                    if(currectQuestion == mquestionList!!.size){
                        submit_btn?.text = "FINISH"
                    }else{
                        submit_btn?.text = "GO NEXT"
                    }
                    clickedoption =0
                }


            }
        }
    }

    fun defauloptiontview(){
        optionone?.background = ContextCompat.getDrawable(this,R.drawable.defaultview)
        optionTwo?.background = ContextCompat.getDrawable(this,R.drawable.defaultview)
        optionThree?.background = ContextCompat.getDrawable(this,R.drawable.defaultview)
        optionFour?.background = ContextCompat.getDrawable(this,R.drawable.defaultview)
    }

    fun answerview(click: Int, drawable: Int){
        when(click){
            1 -> {optionone?.background = ContextCompat.getDrawable(this,drawable)}
            2 -> {optionTwo?.background = ContextCompat.getDrawable(this,drawable)}
            3 -> {optionThree?.background = ContextCompat.getDrawable(this,drawable)}
            4 -> {optionFour?.background = ContextCompat.getDrawable(this,drawable)}
        }
    }


    fun shuffle(){
        val arr = IntArray(totalquestion)
        var c = 1
        for(i in 1..totalquestion){
            arr[i-1]=c
            c++
        }
        arr.shuffle()
        arr2= IntArray(numberofquestion)
        for(i in 1..numberofquestion){
            arr2!![i-1]=arr[i]
        }
    }


}