package com.alexg13.partidosdex.Entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partido_table")
data class Partido(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
                   @ColumnInfo(name = "equipo1") val equipo1: String,
                   @ColumnInfo(name = "equipo2") val equipo2: String,
                   @ColumnInfo(name = "punt1") val punt1: Int,
                   @ColumnInfo(name = "punt2") val punt2:Int,
                   @ColumnInfo(name = "fecha") val fecha: String,
                   @ColumnInfo(name = "ganador") val ganador:String
): Parcelable {
    constructor(parcel : Parcel): this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(equipo1)
        parcel.writeString(equipo2)
        parcel.writeInt(punt1)
        parcel.writeInt(punt2)
        parcel.writeString(fecha)
        parcel.writeString(ganador)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Partido> {
        override fun createFromParcel(parcel: Parcel): Partido {
            return Partido(parcel)
        }

        override fun newArray(size: Int): Array<Partido?> {
            return arrayOfNulls(size)
        }
    }
}