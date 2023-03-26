package com.thorin.apps.asmal.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "amal_note")
@Parcelize
data class NotesEntity(
    @field:PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    var title: String? = "",
    var description: String? = "",
    var date: String? = ""
) : Parcelable