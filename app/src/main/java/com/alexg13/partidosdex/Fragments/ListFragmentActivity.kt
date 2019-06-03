package com.alexg13.partidosdex.Fragments

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexg13.partidosdex.Activities.NewMatchActivity
import com.alexg13.partidosdex.Activities.ViewMatchActivity
import com.alexg13.partidosdex.Adapter.PartidoAdapter
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.R
import com.alexg13.partidosdex.ViewModel.PartidoViewModel

class ListFragmentActivity : Fragment(){

    private lateinit var matchRepoViewModel: PartidoViewModel
    private lateinit var partidoAdapter : PartidoAdapter
    var listenerTool : SearchNewPartidoListener? = null


    companion object {
        fun newInstance(dataset : ArrayList<Partido>): ListFragmentActivity{
            val newFragment = ListFragmentActivity()
            return newFragment
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_fragment,container,false)
        initRecyclerView(resources.configuration.orientation,view)
        return view
    }

    interface SearchNewPartidoListener{
        fun manageLandscapeItemClick(partido: Partido)
    }


    fun initRecyclerView(orientation:Int,container : View){
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            partidoAdapter = PartidoAdapter(requireContext(),{ partido: Partido -> triggerActivity(partido) })
        }
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            partidoAdapter = PartidoAdapter(requireContext(),{ partido: Partido -> listenerTool?.manageLandscapeItemClick(partido)})
        }
        val recyclerView = container.findViewById<RecyclerView>(R.id.movie_list_rv)
        recyclerView.adapter = partidoAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        matchRepoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        matchRepoViewModel.allPartidos.observe(this,androidx.lifecycle.Observer { books->
            books?.let{partidoAdapter.setpartidos(it)}
        })



        val btnPartido = container.findViewById<Button>(R.id.btnAgregar)

        btnPartido.setOnClickListener{var intent = Intent(activity, NewMatchActivity::class.java)
            startActivity(intent)}
    }

    fun triggerActivity(partido: Partido){
        val matchBundle = Bundle()
        matchBundle.putParcelable("partido",partido)
        startActivity(Intent(requireContext(), ViewMatchActivity::class.java).putExtras(matchBundle))
    }

    fun triggerActLand(partido: Partido){

    }



}