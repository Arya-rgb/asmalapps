package com.thorin.apps.asmal.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thorin.apps.asmal.data.local.entity.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class AsmalDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        @Volatile
        private var instance: AsmalDatabase? = null
        fun getInstance(context: Context) : AsmalDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AsmalDatabase::class.java,
                    "asmal.db"
                ).build()
            }
    }

}