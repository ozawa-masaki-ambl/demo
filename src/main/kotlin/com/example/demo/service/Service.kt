package com.example.demo.service

import com.example.demo.mapper.CustomerMapper
import com.example.demo.mapper.HistoryMapper
import com.example.demo.mapper.ProductMapper
import com.example.demo.model.Customer
import com.example.demo.model.EditHistory
import com.example.demo.model.History
import com.example.demo.model.HistoryOrigin
import com.example.demo.model.Model
import com.example.demo.model.RegisterHistory
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
    fun editHistory(editHistory: EditHistory, purchaseId: Int) {
        val historyOrigin: HistoryOrigin = historyMapper.findHistoryRow(purchaseId)
        if (historyOrigin == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        } else {
            editHistory.purchaseId = purchaseId
            editHistory.customerId = editHistory.customerId ?: historyOrigin.customerId
            editHistory.productId = editHistory.productId ?: historyOrigin.productId
            editHistory.purchaseDatetime = editHistory.purchaseDatetime ?: historyOrigin.purchaseDatetime
            editHistory.quantity = editHistory.quantity ?: historyOrigin.quantity
            historyMapper.editHistory(editHistory)
        }
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