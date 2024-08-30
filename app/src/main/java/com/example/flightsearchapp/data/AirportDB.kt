package com.example.flightsearchapp.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(airport::class,favorite::class), version = 1)
abstract class AirportDB:RoomDatabase() {
    abstract fun airportDao():AirportDao
    abstract fun favorite():FavoriteDao
    companion object{
        @Volatile
        private var INSTANCE:AirportDB? = null
        fun getDatabase(context: Context):AirportDB{
            Log.d("DatabaseCreator","Database ka abba")
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    AirportDB::class.java,
                    "flight_search.db"
                )
                   .createFromAsset("flight_search.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it }

            }
        }
    }
}