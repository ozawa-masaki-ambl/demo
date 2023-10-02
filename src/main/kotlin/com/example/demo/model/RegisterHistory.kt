package com.example.demo.model

import jakarta.validation.constraints.NotNull


data class RegisterHistory(
                           @field: NotNull
                           val customerId: Int?,
                           @field: NotNull
                           val productId: Int?,
                           @field: NotNull
                           val quantity: Int?)
