package com.example.sharelock.ui.Friends

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sharelock.R
import com.example.sharelock.utils.Utils

class FriendsFragment : Fragment() {

    private lateinit var friendsViewModel: FriendsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        friendsViewModel =
                ViewModelProviders.of(this).get(FriendsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_friends, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        val button: Button = root.findViewById(R.id.select_friend)
        val addButton: Button = root.findViewById(R.id.add_friend)
        friendsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        addButton.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            //set title for alert dialog
            builder.setTitle("Search username")
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


        button.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            //set title for alert dialog
            builder.setTitle("Remove access")
            //set message for alert dialog

            builder.setIcon(R.drawable.friend_img)

            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->
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

    return root
    }
}