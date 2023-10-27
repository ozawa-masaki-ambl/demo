package com.example.demo.service

import com.example.demo.mapper.CustomerMapper
import com.example.demo.mapper.HistoryMapper
import com.example.demo.mapper.ProductMapper
import com.example.demo.model.Customer
import com.example.demo.model.EditHistory
import com.example.demo.model.History
import com.example.demo.model.Model
import com.example.demo.model.RegisterHistory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class Service(private val customerMapper: CustomerMapper, private val historyMapper: HistoryMapper, private val productMapper: ProductMapper) {
    fun accessAllCustomer(): List<Customer> = customerMapper.accessAllCustomer()

    fun accessAllHistory(): List<History> = historyMapper.accessAllHistory()

    @Transactional(rollbackFor = [Exception::class])
    fun historyAccessById(customerId: Int): List<History> {
        customerMapper.existCheck(customerId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return historyMapper.accessHistoryById(customerId)
    }

    @Transactional(rollbackFor = [Exception::class])
    fun registerHistory(registerHistory: RegisterHistory) {
        customerMapper.existCheck(registerHistory.customerId!!) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        productMapper.existCheck(registerHistory.productId!!) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        historyMapper.registerHistory(registerHistory)
    }

    @Transactional(rollbackFor = [Exception::class])
    fun editHistory(editHistory: EditHistory, purchaseId: Int) {
        val historyOrigin = historyMapper.findHistoryRow(purchaseId) ?: run {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        historyOrigin.purchaseId = purchaseId

        if (editHistory.customerId != null) {
            customerMapper.existCheck(editHistory.customerId) ?: run {
                throw ResponseStatusException(HttpStatus.NOT_FOUND)
            }
            historyOrigin.customerId = editHistory.customerId
        }
        if (editHistory.productId != null) {
            productMapper.existCheck(editHistory.productId) ?: run {
                throw ResponseStatusException(HttpStatus.NOT_FOUND)
            }
            historyOrigin.productId = editHistory.productId
        }
        historyOrigin.quantity = editHistory.quantity ?: historyOrigin.quantity
        historyMapper.editHistory(historyOrigin)

        //let学習
//        historyOrigin.customerId = editHistory.customerId?.let { requestCustomerId ->
//            customerMapper.existCheck(editHistory.customerId) ?: run {
//                throw ResponseStatusException(HttpStatus.NOT_FOUND)
//            }
//            requestCustomerId
//        }?:historyOrigin.customerId

//        historyOrigin.productId = editHistory.productId?.let {
//            customerMapper.existCheck(editHistory.productId)
//                ?: run {
//                    throw ResponseStatusException(HttpStatus.NOT_FOUND)
//                }
//            it
//        } ?: historyOrigin.productId

    }

        @Transactional(rollbackFor = [Exception::class])
        fun deleteHistory(purchaseId: Int) {
            historyMapper.findHistoryRow(purchaseId) ?: run {
                throw ResponseStatusException(HttpStatus.NOT_FOUND)
            }
            historyMapper.deleteHistoryRow(purchaseId)
        }




        fun getHelloService(name: String): String {
            return "Hello, $name !"
        }

        fun getHiService(name: Model): String {
            return "Hi, ${name.model} !"
        }

        fun getHaoService(name: Model): String {
            return "Hao, ${name.model} !"
        }

        fun getHeyService(name: String): String {
            return "Hey, $name !"
        }

    }