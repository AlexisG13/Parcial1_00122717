package com.alexg13.partidosdex.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.alexg13.partidosdex.DAO.PartidosDatabase
import com.alexg13.partidosdex.Entities.Partido
import com.alexg13.partidosdex.Repository.PartidoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(application: Application): AndroidViewModel(application){
    private val repository: PartidoRepository
    val allPartidos : LiveData<List<Partido>>

    init{
        val partidoDao = PartidosDatabase.getDatabase(application,viewModelScope).PartidoDao()
        repository= PartidoRepository(partidoDao)
        allPartidos = repository.getAllPartidos()
    }

    fun insert(partido:Partido)= viewModelScope.launch(Dispatchers.IO){
        repository.insertPartido(partido)
    }


}