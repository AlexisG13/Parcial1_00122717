package com.alexg13.partidosdex.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.R
import kotlinx.android.synthetic.main.activity_view_match.*

class ViewMatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_match)
        val MatchBundle : Partido = intent.extras.getParcelable("partido")

        tv_winner.text = MatchBundle.ganador
        tv_date.text=MatchBundle.fecha
        tv_team1.text=MatchBundle.equipo1
        tv_team2.text=MatchBundle.equipo2
        tv_score1.text=MatchBundle.punt1.toString()
        tv_score2.text=MatchBundle.punt2.toString()
    }
}