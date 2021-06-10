package com.greensoft.todo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.greensoft.todo.R
import com.greensoft.todo.fragment.AddFragment
import com.greensoft.todo.fragment.DashboardFragment
import com.greensoft.todo.fragment.SettingFragment
import com.greensoft.todo.fragment.TaskFragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bottom_task -> {
                    val task = TaskFragment()
                    addFragment(task)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottom_add -> {
                    val add = AddFragment()
                    addFragment(add)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottom_setting -> {
                    val setting = SettingFragment()
                    addFragment(setting)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        val dashboard = DashboardFragment.getIntance()
        addFragment(dashboard)
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}