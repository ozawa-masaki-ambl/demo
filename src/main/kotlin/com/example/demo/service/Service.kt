package com.example.demo.service

import com.example.demo.mapper.CustomerMapper
import com.example.demo.mapper.HistoryMapper
import com.example.demo.mapper.ProductMapper
import com.example.demo.model.*
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class Service (private val customerMapper: CustomerMapper, private val historyMapper: HistoryMapper, private val productMapper: ProductMapper) {
    fun customerAccess() : List<Customer> = customerMapper.customerAccess()
    fun historyAccess() : List<History> = historyMapper.historyAccess()
    fun historyAccessById(customerId: Int) : List<History> = historyMapper.historyAccessById(customerId)

    @Transactional(rollbackFor = [Exception::class])
    fun registerHistory(registerHistory: RegisterHistory) {
       if (customerMapper.existCheck(registerHistory.customerId!!) != null && productMapper.existCheck(registerHistory.productId!!) != null) {
        historyMapper.registerHistory(registerHistory)
       } else {
           throw ResponseStatusException(HttpStatus.NOT_FOUND)
       }
    }
    @Transactional(rollbackFor = [Exception::class])
    fun editHistory(editHistory: EditHistory) {
        val editHistoryNotNull: EditHistory = historyMapper.accessHistory(editHistory.purchaseId!!)
        editHistory.customerId = editHistory.customerId ?: editHistoryNotNull.customerId
        editHistory.productId = editHistory.productId ?: editHistoryNotNull.productId
        editHistory.purchaseDatetime = editHistory.purchaseDatetime ?: editHistoryNotNull.purchaseDatetime
        editHistory.quantity = editHistory.quantity ?: editHistoryNotNull.quantity
        historyMapper.editHistory(editHistory)
    }











    fun getHelloService(name: String):String{
         return "Hello, $name !"
    }
    fun getHiService(name: Model):String{
        return "Hi, ${name.model} !"
    }
    fun getHaoService(name: Model):String{
        return "Hao, ${name.model} !"
    }
    fun getHeyService(name: String):String{
        return "Hey, $name !"
    }

}