package com.thorin.apps.asmal.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.thorin.apps.asmal.data.local.entity.NotesEntity

@Dao
interface NotesDao {

    @Query("SELECT * FROM amal_note ORDER BY id ASC")
    fun getNotes(): LiveData<List<NotesEntity>>

    @Insert
    suspend fun insertNotes(user: List<NotesEntity>)

}