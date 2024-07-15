package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)

        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }

    }
}

val contacts = listOf(
    Contact(
        "Vanessa",
        "(55) 54 996124881",
        R.drawable.sample1,
    ),
    Contact(
        "Eric",
        "(55) 54 996123245",
        R.drawable.sample2,
    ),
    Contact(
        "Michele",
        "(55) 54 991234567",
        R.drawable.sample3,
    ),
    Contact(
        "Luiza",
        "(55) 54 996554321",
        R.drawable.sample4,
    ),
    Contact(
        "Lizandra",
        "(55) 54 996452136",
        R.drawable.sample5,
    ),
    Contact(
        "Roberta",
        "(55) 54 996678901",
        R.drawable.sample6,
    ),
    Contact(
        "Ni Hun",
        "(55) 54 996321908",
        R.drawable.sample7,
    ),
    Contact(
        "Lucas",
        "(55) 54 996439041",
        R.drawable.sample8,
    ),
    Contact(
        "Juan",
        "(55) 54 996503297",
        R.drawable.sample9,
    ),
    Contact(
        "Vitor",
        "(55) 54 996290531",
        R.drawable.sample10,
    ),
    Contact(
        "Jue Huan",
        "(55) 54 996831901",
        R.drawable.sample11,
    ),
    Contact(
        "Carlos",
        "(55) 54 996580928",
        R.drawable.sample12,
    ),
    Contact(
        "Debora",
        "(55) 54 996432238",
        R.drawable.sample13,
    ),
    Contact(
        "Nilton",
        "(55) 54 996890431",
        R.drawable.sample14,
    ),
    Contact(
        "Roberta",
        "(55) 54 996831580",
        R.drawable.sample15,
    ),
    Contact(
        "Liandra",
        "(55) 54 996313890",
        R.drawable.sample16,
    ),
    Contact(
        "Liandra H.",
        "(55) 54 3211-7171",
        R.drawable.sample16,
    ),
    Contact(
        "Liandra Corp.",
        "(55) 54 991343431",
        R.drawable.sample16,
    ),
)