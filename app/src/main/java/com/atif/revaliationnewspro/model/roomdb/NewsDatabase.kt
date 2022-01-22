package com.atif.revaliationnewspro.model.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.atif.revaliationnewspro.model.api.Article
import com.atif.revaliationnewspro.model.api.Convertors

@Database(entities = [Article::class], version = 1)
@TypeConverters(Convertors::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun newsdao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getDBInstance(context: Context): NewsDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "quotedatabase"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}