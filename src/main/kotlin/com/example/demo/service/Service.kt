package com.example.demo.service

import com.example.demo.mapper.CustomerMapper
import com.example.demo.mapper.HistoryMapper
import com.example.demo.model.Customer
import com.example.demo.model.History
import com.example.demo.model.Model
import org.springframework.stereotype.Service

@Service
class Service (private val customerMapper :CustomerMapper,private val historyMapper: HistoryMapper){
    fun customerAccess() : List<Customer> = customerMapper.customerAccess()
    fun historyAccess() : List<History> = historyMapper.historyAccess()











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