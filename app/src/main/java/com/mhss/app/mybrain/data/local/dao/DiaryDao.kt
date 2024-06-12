package com.mhss.app.mybrain.data.local.dao

import androidx.room.*
import com.mhss.app.mybrain.data.local.entity.DiaryEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {

    @Query("SELECT * FROM diary")
    fun getAllEntries(): Flow<List<DiaryEntryEntity>>

    @Query("SELECT * FROM diary WHERE id = :id")
    suspend fun getEntry(id: Int): DiaryEntryEntity

    @Query("SELECT * FROM diary WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%'")
    suspend fun getEntriesByTitle(query: String): List<DiaryEntryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(diary: DiaryEntryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntries(diary: List<DiaryEntryEntity>)

    @Update
    suspend fun updateEntry(diary: DiaryEntryEntity)

    @Delete
    suspend fun deleteEntry(diary: DiaryEntryEntity)

}