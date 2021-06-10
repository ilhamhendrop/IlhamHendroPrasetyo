package com.greensoft.jsonmanipulation

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import com.greensoft.jsonmanipulation.Service.Adapter.Iventory
import com.greensoft.jsonmanipulation.Service.Adapter.respone.IventoryRespone
import com.greensoft.jsonmanipulation.Service.Api.Service
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cvElectonic.setOnClickListener(this)
        cvFurniture.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val electronic :String
        val furniture :String

        when(v.id){
            R.id.cvElectonic -> ElectronicDevices("electronic")
            R.id.cvFurniture -> Furniture("furniture")
        }
    }

    private fun Furniture(furniture: String) {
        Service().getService().getElectronic(furniture).enqueue(object : Callback<IventoryRespone> {
            override fun onResponse(
                call: Call<IventoryRespone>,
                response: Response<IventoryRespone>
            ) {
                val Intent = Intent(applicationContext, Furniture::class.java)
                startActivity(Intent)
            }

            override fun onFailure(call: Call<IventoryRespone>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })
    }

    private fun ElectronicDevices(electronic: String) {
        Service().getService().getElectronic(electronic).enqueue(object : Callback<IventoryRespone> {
            override fun onResponse(
                call: Call<IventoryRespone>,
                response: Response<IventoryRespone>
            ) {
                val Intent = Intent(applicationContext, Electoronic::class.java)
                startActivity(Intent)
            }

            override fun onFailure(call: Call<IventoryRespone>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuSearch ->{
                val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
                val searchView = item.actionView as SearchView

                searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
                searchView.queryHint = StringBuilder("Search")
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(meeting: String): Boolean {
                        Service().getService().getMeeting(meeting).enqueue(object : Callback<IventoryRespone> {
                            override fun onResponse(
                                call: Call<IventoryRespone>,
                                response: Response<IventoryRespone>
                            ) {
                                if (response.isSuccessful){
                                    val meeting = response.body()?.iventory as List<Iventory>

                                    for (i in 0 until meeting.size){
                                        for (a in 0 until  meeting.get(i).Placement.size){
                                            for (b in 0 until meeting.get(i).tags.size) {

                                            }
                                        }
                                    }
                                }

                            }

                            override fun onFailure(call: Call<IventoryRespone>, t: Throwable) {
                                Log.d("error", t.message.toString())
                            }

                        })

                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        return false
                    }

                })
            }
        }
        return super.onOptionsItemSelected(item)
    }
}