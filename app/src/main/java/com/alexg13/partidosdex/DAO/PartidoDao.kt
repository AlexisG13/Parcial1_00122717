package com.alexg13.partidosdex.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexg13.partidosdex.Entities.Partido

@Dao
interface PartidoDao {

    @Query("SELECT * from partido_table ORDER BY id ASC")
    fun getAllPartidos(): LiveData<List<Partido>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido: Partido)

    @Query("DELETE FROM partido_table")
    fun deleteAll()
}