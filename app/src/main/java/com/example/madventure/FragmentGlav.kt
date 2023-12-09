package com.example.madventure

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent
import android.content.Context
import android.util.Log

import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentGlav.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentGlav : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var answer: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val fragmentLayout=inflater.inflate(R.layout.fragment_glav, container, false)
        val navController=NavHostFragment.findNavController(this)

        val rec:RecyclerView=fragmentLayout.findViewById(R.id.recyclerView)
        rec.layoutManager= GridLayoutManager(requireContext(),3)
        rec.adapter=QuestRecycler(requireContext(),MyObj().list)

        return fragmentLayout


    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fragmentHoror -> {
                findNavController().navigate(R.id.action_fragmentGlav_to_fragmentHoror)
                return true
            }
            R.id.fragmentDetectiv -> {
                findNavController().navigate(R.id.action_fragmentGlav_to_fragmentDetectiv)
                return true
            }
            R.id.fragmentFentezi -> {
                findNavController().navigate(R.id.action_fragmentGlav_to_fragmentFentezi)
                return true
            }
            R.id.fragmentSearch -> {
                findNavController().navigate(R.id.action_fragmentGlav_to_fragmentSearch)
                return true
            }
        }
        return super.onOptionsItemSelected(item)}



}