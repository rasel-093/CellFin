package com.example.cellfin.model

data class TrxItem(
    val id: Int,
    var title: String,
    var details: String,
    var date: String,
    var trxId: String,
    val amount: String,
    val trxType: Boolean    //false -> Cash out, true-> Cash in
)