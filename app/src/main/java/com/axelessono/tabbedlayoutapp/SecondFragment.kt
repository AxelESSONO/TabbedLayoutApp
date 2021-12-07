package com.axelessono.tabbedlayoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView


class SecondFragment : Fragment() {

    private lateinit var textFirstName : TextView
    private lateinit var textName : TextView
    private lateinit var textAge : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)

        textFirstName = rootView.findViewById(R.id.textFirstName)
        textName = rootView.findViewById(R.id.textName)
        textAge = rootView.findViewById(R.id.textAge)

        return rootView
    }

    fun getSentData(firsName: String?, lastName: String?, age: Int?) {

        textFirstName.text = firsName
        textName.text = lastName
        textAge.text = "$age"
    }

}