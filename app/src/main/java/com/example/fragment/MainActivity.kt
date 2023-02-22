package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Default flag open
        loadFrag(BFragment(), 0)
        val btnFragA = findViewById<Button>(R.id.fragA).setOnClickListener {
            loadFrag(
                AFragment(),
                1
            )
        }
        val btnFragB = findViewById<Button>(R.id.fragB).setOnClickListener {
            loadFrag(
                BFragment(),
                1
            )
        }
        val btnFragC = findViewById<Button>(R.id.fragC).setOnClickListener {
            loadFrag(
                CFragment(),
                1
            )
        }
    }

    private fun loadFrag(frag: Fragment?, flag: Int) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        if (flag == 0) {
            ft.add(R.id.container, frag!!)
        } else {
            ft.replace(R.id.container, frag!!)
        }
        ft.commit()
    }
}