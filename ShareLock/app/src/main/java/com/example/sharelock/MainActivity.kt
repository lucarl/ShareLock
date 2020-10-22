package com.example.sharelock

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sharelock.utils.Utils
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val drawerView: NavigationView = findViewById(R.id.navView)


        val navController = findNavController(R.id.nav_host_fragment)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val drawer_button: Button = findViewById(R.id.drawer_button)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_lock, R.id.navigation_map, R.id.navigation_friends), drawerLayout)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        navView.setupWithNavController(navController)
        drawerView.setupWithNavController(navController)

        NavigationUI.setupWithNavController(navView, navController)

        drawer_button.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            //set title for alert dialog
            builder.setTitle("Search lock id")
            //set message for alert dialog

            builder.setIcon(R.drawable.ic_baseline_search_24)

            //performing positive action
            builder.setPositiveButton("Add"){dialogInterface, which ->
            }
            //performing cancel action
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }


}