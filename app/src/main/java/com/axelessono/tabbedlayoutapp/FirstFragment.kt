package com.axelessono.tabbedlayoutapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class FirstFragment : Fragment() {

    private lateinit var editFirstName: EditText
    private lateinit var editName: EditText
    private lateinit var editAge: EditText
    private lateinit var buttonPassData: Button
    private lateinit var passDataListener: PassDataListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)

        editFirstName = rootView.findViewById(R.id.editFirstName)
        editName = rootView.findViewById(R.id.editName)
        editAge = rootView.findViewById(R.id.editAge)
        buttonPassData = rootView.findViewById(R.id.buttonPassData)

        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.passDataListener = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passDataListener = activity as PassDataListener

        buttonPassData.setOnClickListener {

            if (
                editFirstName.text.toString().trim().isNotEmpty() ||
                editName.text.toString().trim().isNotEmpty() ||
                editAge.text.toString().trim().isNotEmpty()
            ) {
                passDataListener.onPassDataListener(
                    editFirstName.text.toString().trim(),
                    editName.text.toString().trim(),
                    editAge.text.toString().trim().toInt()
                )
            }
        }
    }
}