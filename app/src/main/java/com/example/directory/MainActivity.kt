package com.example.directory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.directory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        val myContactList = mutableListOf<ContactList>()
        myContactList.add(ContactList(R.drawable.baseline_account_box_24,"future","010-1234-5678",true))
        myContactList.add(ContactList(R.drawable.baseline_account_box_24,"rocky","010-1234-5678",false))
        myContactList.add(ContactList(R.drawable.baseline_account_box_24,"roddy rich","010-1234-5678",false))
        myContactList.add(ContactList(R.drawable.baseline_account_box_24,"uzi vert","010-1234-5678",false))
        myContactList.add(ContactList(R.drawable.baseline_account_box_24,"gunna","010-1234-5678",false))
        myContactList.add(ContactList(R.drawable.baseline_account_box_24,"drake","010-1234-5678",false))
        myContactList.add(ContactList(R.drawable.baseline_account_box_24,"thug","010-1234-5678",true))






        val myAdapter = MyRecyclerViewAdapter(myContactList)

        viewBinding.mainPageRecyclervIew.adapter = myAdapter
        viewBinding.mainPageRecyclervIew.layoutManager = LinearLayoutManager(this)

    }
}