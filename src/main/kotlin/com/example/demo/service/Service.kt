package com.example.demo.service

import com.example.demo.mapper.Mapper
import com.example.demo.model.Customer
import com.example.demo.model.Model
import org.springframework.stereotype.Service

@Service
class Service (private val mapper :Mapper){

    fun customerAccess() : List<Customer> = mapper.customerAccess()

//    fun  historyAccess():List<History> {
//        var hisList = mapper.historyAccess()
//        hisList.get()
//    }










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