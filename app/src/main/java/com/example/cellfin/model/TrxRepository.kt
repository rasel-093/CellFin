package com.example.cellfin.model

import androidx.lifecycle.LiveData

class TrxRepository (val trxDao: TrxDao){
    val allTrx: LiveData<List<TrxItem>> = trxDao.getAll()
    suspend fun insertTrx(trxItem: TrxItem){
        trxDao.insert(trxItem)
    }

    suspend fun deleteTrx(trxItem: TrxItem){
        trxDao.delete(trxItem)
    }
    suspend fun deleteAllTrx(){
        trxDao.deleteAll()
    }
}