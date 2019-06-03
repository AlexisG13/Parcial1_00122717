package com.alexg13.partidosdex.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.R
import kotlinx.android.synthetic.main.main_content_fragment.view.*

class MainContentFragment : Fragment(){

    lateinit var partido: Partido

    companion object{
        fun newInstance(partido: Partido):MainContentFragment{
            val newFragment = MainContentFragment()
            newFragment.partido = partido
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.main_content_fragment,container,false)
        bindData(view)
        return view
    }

    fun bindData(view: View){
        view.tv_winner2.text = partido.ganador
        view.tv_date2.text= partido.fecha
        view.tv_score12.text = partido.punt1.toString()
        view.tv_score22.text = partido.punt2.toString()
        view.tv_team12.text = partido.equipo1
        view.tv_team22.text = partido.equipo2
    }
}