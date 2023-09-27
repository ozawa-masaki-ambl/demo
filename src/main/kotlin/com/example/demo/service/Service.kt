package com.example.demo.service

import com.example.demo.mapper.Mapper
import com.example.demo.model.sModel
import org.springframework.stereotype.Service

@Service
class Service (private val mapper :Mapper){

    fun access() : List<sModel?> = mapper.access()


    fun getHelloService(name: String):String{
         return "Hello, $name !"
    }
    fun getHiService(name: sModel):String{
        return "Hi, ${name.customerName} !"
    }
    fun getHaoService(name: sModel):String{
        return "Hao, ${name.customerName} !"
    }
    fun getHeyService(name: String):String{
        return "Hey, $name !"
    }

}