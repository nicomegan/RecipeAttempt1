package com.example.recipeattempt1

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.kotlin.query
import kotlinx.android.synthetic.main.activity_scrolling.*
import java.util.*
import android.util.Half.greater
import io.objectbox.query.QueryBuilder



class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        val testButtonVar: Button = findViewById(R.id.testButton)

        testButtonVar.setOnClickListener{
            val intent:Intent = Intent(this, addRecipeActivity::class.java)
            startActivity(intent)
        }



        ///////////object box ////////////////////////////////////
        val recipeBox = ObjectBox.boxStore.boxFor(Recipe::class.java)

        val newTodo: Recipe = Recipe(description = "SIX", ingredients = "1 tsp sugar", instructions = "this is what you do", dateCreated = Date())
        recipeBox.put(newTodo)

        val query = recipeBox.query {
            order(Recipe_.dateCreated)
        }

        val results = query.find()

        Log.d("DATABASE_COUNT", results.count().toString())
        Log.d("DATABASE_RESULTS", results.toString())

        results.forEach({Log.d("DATABASE_RESULTS", it.toString())})
        ///////////////////////////////////////////////////////////


//        val builder = recipeBox.query()
//        builder.equal(Recipe_.description, "four")
//            .greater(Recipe_.yearOfBirth, 1970)
//            .startsWith(Recipe_.lastName, "O")
//        val youngJoes = builder.build().find()
//
//        youngJoes.forEach(Log.d("DATABASE_TEST", results.count().toString()))




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}


//////////////////object box////////////////////
@Entity
data class Recipe(
    @Id var id:Long = 0,
    var description:String,
    var ingredients:String,
    var instructions:String,
    var dateCreated: Date
)
/////////////object box ////////////////////////
