package com.alexg13.partidosdex.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.alexg13.partidosdex.Entities.Partido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Partido::class], version = 3,exportSchema = false)
abstract class PartidosDatabase : RoomDatabase() {

    abstract fun PartidoDao(): PartidoDao

    companion object {
        @Volatile
        private var INSTANCE: PartidosDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PartidosDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PartidosDatabase::class.java,
                    "Book_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(BookDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class BookDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.PartidoDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(partidoDao: PartidoDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            partidoDao.deleteAll()
            var partido= Partido(0,"Alianza","Aguila",1,2, "02/01/2019","Alianza")
            partidoDao.insert(partido)
            partido = Partido(0,"Liverpool","Barcelona",1,2, "02/01/2018","Liverpool")
            partidoDao.insert(partido)

        }

    }

}