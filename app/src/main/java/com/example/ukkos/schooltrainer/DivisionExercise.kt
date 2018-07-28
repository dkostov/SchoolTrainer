package com.example.ukkos.schooltrainer

import java.lang.Math.random

/**
 * Created by ukkos on 2/25/2018.
 */
class DivisionQuestion : ExerciseQuestion() {
    public var divident : Int = 0
    public var divisor : Int = 1
}

class DivisionExercise : Exercise {
    override var name : String = "Division"
    override var description : String = "Practice your division of multi-digit numbers. All questions are guaranteed to have an integer result without remainders."
    override var questionsPerSession : Int = 20
    override var errorsToHint : Int = 3
    override var currentQuestion : Int = 0

    public var maxDiv : Int = 999   // the maximum divisor. Governs the complexity of the task

    override fun getQuestion(): ExerciseQuestion {
        var q = DivisionQuestion()

        q.divisor = RandomInt(2, maxDiv)
        q.divident = q.divisor * RandomInt(1, maxDiv)
        q.text = "Calculate: "+ q.divident.toString() + " / " + q.divisor.toString()

        return q
    }
}