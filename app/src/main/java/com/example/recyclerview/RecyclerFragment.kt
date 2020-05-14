package com.example.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecyclerFragment : Fragment() {

    private lateinit var myLayoutManager: RecyclerView.LayoutManager
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_recycler, container, false)

        myLayoutManager = LinearLayoutManager(activity)
        myAdapter = MyAdapter()
        myAdapter.data.addAll(listOf<Int>(1, 2, 3, 4))

        myRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = myLayoutManager
            adapter = myAdapter
        }

        view.findViewById<Button>(R.id.add_button).setOnClickListener {
            myAdapter.data.add((0..100).random())
            myAdapter.notifyDataSetChanged()
        }

        view.findViewById<Button>(R.id.clear_button).setOnClickListener {
            myAdapter.data.clear()
            myAdapter.notifyDataSetChanged()
        }
        return view
    }

}
