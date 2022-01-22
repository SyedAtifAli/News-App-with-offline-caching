package com.atif.revaliationnewspro.model.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.atif.revaliationnewspro.model.api.Article

@Dao
interface NewsDao {

    @Insert
    suspend fun insert(newsEntity: List<Article>)

    @Query("select * from newstable order by id desc")
    suspend fun getNewsfromRoom(): List<Article>
}