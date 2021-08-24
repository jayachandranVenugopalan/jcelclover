package com.jcel.jcelclover.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.jcel.jcelclover.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val submit: Button =view.findViewById(R.id.Submit_Btn)
        submit.setOnClickListener {
            val username: EditText =view.findViewById(R.id.username)
            val password: EditText =view.findViewById(R.id.password)
if (username.text.toString()=="jayachandran"&&password.text.toString()=="1234"){
            findNavController().navigate(R.id.action_loginFragment_to_invoiceFragment)}
            else{
    Toast.makeText(activity, "Enter the vaild mailid and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}