package com.example.cellfin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Trx_table")
data class TrxItem(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo("title")var title: String,
    @ColumnInfo("details") var details: String,
    @ColumnInfo("date") var date: String,
    @ColumnInfo("trxid") var trxId: String,
    @ColumnInfo("amount") val amount: String,
    @ColumnInfo("type") val trxType: String    //false -> Cash out, true-> Cash in
){
    fun type() = if(trxType == (true).toString()) true else false
}