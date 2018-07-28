package com.example.ukkos.schooltrainer

/**
 * Created by ukkos on 2/26/2018.
 */
class OorUIExercise : Exercise {
    override var name : String = "О или У"
    override var description : String = "В българския език няма строго правило за писане на О или У, за това думите трябва редовно да се упражняват."
    override var questionsPerSession : Int = 20
    override var errorsToHint : Int = 3
    override var currentQuestion : Int = 0
}