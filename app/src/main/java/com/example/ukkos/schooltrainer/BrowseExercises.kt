package com.example.ukkos.schooltrainer

import android.content.Intent
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.activity_browse_exercises.*
import kotlinx.android.synthetic.main.fragment_browse_exercises.view.*

class BrowseExercises : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var mExercisesList : MutableList<Exercise> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Add the known Exercises
        mExercisesList.add(DivisionExercise())
        mExercisesList.add(OorUIExercise())

        setContentView(R.layout.activity_browse_exercises)
        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
         // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

    }

    // Launches the current exercise
    fun onClickStart(view: View?) {
        val intent = Intent(this, ExerciseSession::class.java)
        val message = "<<todo: profile>>"
        intent.putExtra(EXERCISES_MESSAGE, message)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_browse_exercises, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1, mExercisesList[position])
        }

        override fun getCount(): Int {
            return mExercisesList.count()
        }
    }

    /**
     * A fragment containing the descriptions of all available exercises.
     * Swipe to navigate.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_browse_exercises, container, false)
            rootView.section_label.text = arguments.getString(ARG_NAME)
            rootView.txtDescr.text = arguments.getString(ARG_DESCR)
            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_QPS = "exercise_QPS"
            private val ARG_NAME = "exercise_name"
            private val ARG_DESCR = "exercise_description"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int, ex: Exercise): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_QPS, sectionNumber)
                args.putString(ARG_NAME, ex.name)
                args.putString(ARG_DESCR, ex.description)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
