package com.alexg13.partidosdex.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.alexg13.partidosdex.DAO.PartidoDao
import com.alexg13.partidosdex.Entities.Partido

class PartidoRepository(private val Partido : PartidoDao) {


    fun getAllPartidos(): LiveData<List<Partido>> = Partido.getAllPartidos()

    @WorkerThread
    suspend fun insertPartido(partido : Partido) = Partido.insert(partido)

    fun deletePartidoAll() = Partido.deleteAll()

}