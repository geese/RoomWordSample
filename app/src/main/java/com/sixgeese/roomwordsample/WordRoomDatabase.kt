package com.sixgeese.roomwordsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */

/**
 * We annotate the class to be a Room database with @Database
 * and declare the entities that belong in the database and
 * set the version number. Listing the entities creates tables in the database.
 */
@Database(entities = arrayOf(Word::class), version = 1)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao() :WordDao

    companion object {

        // marking the instance as volatile to ensure atomic access to the variable
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}