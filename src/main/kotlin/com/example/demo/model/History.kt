package com.example.demo.model

import java.sql.Timestamp

data class History(val purchaseId:Int,
                   val customerName:String,
                   val productName:String,
                   val purchaseDatetime:Timestamp,
                   val quantity:Int)
