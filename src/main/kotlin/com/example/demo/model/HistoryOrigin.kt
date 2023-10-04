package com.example.demo.model

import java.sql.Timestamp

data class HistoryOrigin(var purchaseId: Int,
                         var customerId: Int,
                         var productId: Int,
                         var purchaseDatetime: Timestamp,
                         var quantity: Int)
