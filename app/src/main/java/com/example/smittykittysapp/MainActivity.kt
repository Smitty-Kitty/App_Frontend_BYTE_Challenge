package com.example.smittykittysapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.showevents.models.Event
import com.example.showevents.network.Api
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val data = arrayOf<String>("one", "two", "three", "four", "five")

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var NavController = findNavController(R.id.fragmentContainerView)
        var bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomnav.setupWithNavController(NavController)

        manager = LinearLayoutManager(this)

        getAllData()
    }

    fun getAllData(){
        Api.retrofitService.getAllData().enqueue(object: Callback<List<Event>> {
            override fun onResponse(
                call: Call<List<Event>>,
                response: Response<List<Event>>
            ) {
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
                        myAdapter = MyAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = myAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}