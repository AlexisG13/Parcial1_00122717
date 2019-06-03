package com.alexg13.partidosdex.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alexg13.partidosdex.R
import kotlinx.android.synthetic.main.activity_new_match.*
import java.text.SimpleDateFormat
import java.util.*

class NewMatchActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        var equipo1 = ed_equipo1.text.toString()
        var equipo2 = ed_equipo2.text.toString()
        var date = SimpleDateFormat("dd-MM-yyyy").format(Date())
        var intent = Intent(this, MainActivityInsert::class.java)
        intent.putExtra("equipo1",equipo1)
        intent.putExtra("equipo2",equipo2)
        intent.putExtra("date",date)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)
        btnEmpezarPartido.setOnClickListener(this)

    }


}