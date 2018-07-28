package com.example.ukkos.schooltrainer

import java.util.*

/**
 * Created by ukkos on 2/25/2018.
 */

// The interface the UI will use to render questions,
// collect results and gather telemetry
open class ExerciseQuestion {
    public var text : String = ""
    public val response : String = ""
    public val attempts : Int = 0
    public val seconds : Int = 0
}

// The interface the UI will use to list available exercises and
// manage exercise sessions
interface Exercise {
    var name : String
    var description : String
    var questionsPerSession : Int
    var errorsToHint : Int

    var currentQuestion : Int

    fun getQuestion() : ExerciseQuestion {
        assert(false)   // never use the basic implementation directly. Override this method!
        return ExerciseQuestion()   // basic implementation always returns empty question
    }
    fun writeStatistics(lQ : List<ExerciseQuestion>){
        assert(false)   // never use the basic implementation directly. Override this method!
        // TODO: persist stats
    }

    fun RandomInt(f : Int, t : Int) : Int {
        val random = Random()
        return random.nextInt(t - f) + f
    }
}

