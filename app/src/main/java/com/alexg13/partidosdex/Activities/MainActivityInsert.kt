package com.alexg13.partidosdex.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.R
import com.alexg13.partidosdex.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.activity_main_insert.*

class MainActivityInsert : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        var mIntent = getIntent()
        var equipo1 = mIntent.getStringExtra("equipo1")
        var equipo2 = mIntent.getStringExtra("equipo2")
        var puntaje1 = ed_puntaje1.text.toString().toInt()
        var puntaje2 = ed_puntaje2.text.toString().toInt()
        var ganador="N/A"
        var date = mIntent.getStringExtra("date")
        if(puntaje1>puntaje2) ganador = equipo1.toString()
        else if(puntaje2>puntaje1) ganador = equipo2.toString()
        else if(puntaje1==puntaje2) ganador = "Empate"
        var insertPartido = Partido(0,equipo1.toString(),equipo2.toString(),puntaje1,puntaje2,date,ganador)
        partidoViewModel.insert(insertPartido)
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        Toast.makeText(this@MainActivityInsert, "Ingresado con exito!!!!", Toast.LENGTH_LONG)
    }

    private lateinit var partidoViewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_insert)

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        btnInsertarPartido.setOnClickListener(this)
    }
}