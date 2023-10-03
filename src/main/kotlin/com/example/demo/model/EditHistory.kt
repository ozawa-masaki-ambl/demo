package com.example.demo.model

import jakarta.validation.constraints.NotNull
import java.sql.Timestamp

data class EditHistory(@field: NotNull
                       var purchaseId: Int?,
                       var customerId: Int?,
                       var productId: Int?,
                       var purchaseDatetime: Timestamp?,
                       var quantity: Int?)
