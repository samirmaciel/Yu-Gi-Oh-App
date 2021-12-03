package com.samirmaciel.yugiohapp.shared.data.dataInternal.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.samirmaciel.yugiohapp.shared.domain.model.Card

@Database( entities = [Card::class], version = 1)
abstract class DatabaseRoom : RoomDatabase() {

    abstract fun cardDao() : CardDao

    companion object {
        @Volatile
        private var INSTANCE : DatabaseRoom? = null

        fun getDatabase(context: Context) : DatabaseRoom{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseRoom::class.java,
                        "bd_yugioh"
                        ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}