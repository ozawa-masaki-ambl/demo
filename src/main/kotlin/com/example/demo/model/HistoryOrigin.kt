package com.example.demo.model

import java.sql.Timestamp

data class HistoryOrigin(val purchaseId: Int,
                         val customerId: Int,
                         val productId: Int,
                         val purchaseDatetime: Timestamp,
                         val quantity: Int)
