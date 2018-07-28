package com.example.ukkos.schooltrainer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exercise_question.*

class ExerciseSession : AppCompatActivity() {
    private var mQuestions = mutableListOf<ExerciseQuestion>()
    private lateinit var mExercise: Exercise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_question)

        editAnswer.setText("")

        // TODO: Create exercises based on passed arguments
        mExercise = DivisionExercise()
        mQuestions.add(mExercise.getQuestion())

        txtQuestion.text = mQuestions[0].text
        txtTime.text = mQuestions[0].seconds.toString()
        txtQCount.text = "Question " + (mQuestions.lastIndex + 1).toString() + " of " + mExercise.questionsPerSession.toString()
    }
}
