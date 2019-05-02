package com.example.recipeattempt1

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.recipeattempt1.Fragments.inputRecipeFragment
import kotlinx.android.synthetic.main.activity_add_recipe.*

class addRecipeActivity : AppCompatActivity(), inputRecipeFragment.OnFragmentInteractionListener {

    lateinit var inputRecipeFragment: Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }



        inputRecipeFragment = inputRecipeFragment()
        openFragment(inputRecipeFragment)



    }


    private fun openFragment(fragment: Fragment) {

        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

//        transaction!!.replace(R.id.container, moodGraphFragment)

//        transaction.add(R.id.root_layout, moodGraphFragment)
//        transaction.add(R.id.container, moodGraphFragment)
        transaction.replace(R.id.addRecipeContainer, fragment)
        transaction!!.addToBackStack(inputRecipeFragment.toString()) //TODO: Make sure this is correct
//        transaction.setTransition(FragmentTransaction)
        transaction!!.show(fragment)
        transaction!!.commit()

    }

    override fun onFragmentInteraction(uri: Uri) {
        Log.d("Fragment Interaction", "$$&Fragment Interaction")
    }

}
