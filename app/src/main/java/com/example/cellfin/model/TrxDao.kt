package com.example.cellfin.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrxDao{
    @Query("SELECT * FROM trx_table")
    fun getAll(): LiveData<List<TrxItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trxItem: TrxItem)

    @Delete
    suspend fun delete(trxItem: TrxItem)

    @Query("DELETE FROM trx_table")
    suspend fun deleteAll()
}