package com.sixgeese.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_table")
data class Word(@PrimaryKey @ColumnInfo(name="word") val word: String)