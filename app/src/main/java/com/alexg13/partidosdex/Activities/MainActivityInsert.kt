package com.alexg13.partidosdex.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.Entities.ScoreData
import com.alexg13.partidosdex.R
import com.alexg13.partidosdex.ViewModel.PartidoViewModel
import com.alexg13.partidosdex.Entities.ScoreViewModel
import kotlinx.android.synthetic.main.insert_activity.*

class MainActivityInsert : AppCompatActivity(), View.OnClickListener {


    override fun onClick(v: View?) {
        var mIntent = getIntent()
        var equipo1 = mIntent.getStringExtra("equipo1")
        var equipo2 = mIntent.getStringExtra("equipo2")
        var puntaje1 = ed_puntaje1.text.toString().toInt()
        var puntaje2 = ed_puntaje2.text.toString().toInt()
        var ganador="N/A"
        var date = mIntent.getStringExtra("date")
        if(puntaje1>puntaje2) ganador = "Ganador:  "+equipo1.toString()
        else if(puntaje2>puntaje1) ganador = "Ganador:  "+equipo2.toString()
        else if(puntaje1==puntaje2) ganador = "Empate"
        var insertPartido = Partido(0,equipo1.toString(),equipo2.toString(),puntaje1,puntaje2,date,ganador)
        partidoViewModel.insert(insertPartido)
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private lateinit var partidoViewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insert_activity)
        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        btnInsertarPartido.setOnClickListener(this)
        var mIntent = getIntent()
        tv_equipo1.text=mIntent.getStringExtra("equipo1")
        tv_equipo2.text=mIntent.getStringExtra("equipo2")
    }

    fun addOneTeamA(v: View) {
        var n= ed_puntaje1.text.toString().toInt()
        n+=1
        var str = n.toString()
        ed_puntaje1.setText(str)
    }

    fun addOneTeamB(v: View) {
        var n= ed_puntaje2.text.toString().toInt()
        n+=1
        var str = n.toString()
        ed_puntaje2.setText(str)
    }

    fun addTwoTeamA(v: View) {
        var n = ed_puntaje1.text.toString().toInt()
        n += 2
        var str = n.toString()
        ed_puntaje1.setText(str)
    }


        fun addTwoTeamB(v: View) {
            var n = ed_puntaje2.text.toString().toInt()
            n += 2
            var str = n.toString()
            ed_puntaje2.setText(str)
        }

        fun addThreeTeamA(v: View) {
            var n = ed_puntaje1.text.toString().toInt()
            n += 3
            var str = n.toString()
            ed_puntaje1.setText(str)
        }

        fun addThreeTeamB(v: View) {
            var n = ed_puntaje2.text.toString().toInt()
            n += 3
            var str = n.toString()
            ed_puntaje2.setText(str)
        }


}