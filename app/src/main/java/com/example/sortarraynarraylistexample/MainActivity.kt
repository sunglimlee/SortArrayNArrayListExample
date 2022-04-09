package com.example.sortarraynarraylistexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.DOMException
import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var mExampleList : ArrayList<ExampleItem>
    private lateinit var mRecyclerViewAdapter : ExampleAdapter //mExampleList 즉 ArrayList용 Adapter
    private val mArrayNames = arrayOf("Lee", "Robert","Darryl", "Kim",  "Steve" , "Eugune", "Tim") //Array는 사이즈가 fixed
    private lateinit var mListViewAdapter : ArrayAdapter<String> //mArrayNames 즉 Array용 Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createExampleList()
        buildRecyclerView()
        buildListView()

        val buttonSort : Button = findViewById(R.id.button_sort)
        buttonSort.setOnClickListener {
            sortArray()
            sortArrayList()
        }
    }

    private fun sortArrayList() {
        Collections.sort(mExampleList, Comparator<ExampleItem> {
            o1, o2 -> o1.getText2().compareTo(o2.getText2())
        })
        mRecyclerViewAdapter.notifyDataSetChanged()
    }


    private fun sortArray() {
        Arrays.sort(mArrayNames) //이걸 그냥 바로 sort를 하는거구나..
        mListViewAdapter.notifyDataSetChanged()
    }

    private fun buildListView() {
        val listView : ListView = findViewById(R.id.listview)
        mListViewAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArrayNames)
        listView.adapter = mListViewAdapter
    }

    private fun buildRecyclerView() {
        val recyclerView : RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerViewAdapter = ExampleAdapter(mExampleList)
        recyclerView.adapter =mRecyclerViewAdapter

    }

    private fun createExampleList() {
        mExampleList = ArrayList<ExampleItem>()
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Daryl", "Dixon"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Rick", "Grimes"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Abrham", "Ford"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Eugune", "Porter"))
        mExampleList.add(ExampleItem(R.drawable.ic_sun, "Lee", "Kim"))
    }
}