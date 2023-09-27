package com.example.demo.service

import com.example.demo.mapper.Mapper
import com.example.demo.model.Model
import org.springframework.stereotype.Service

@Service
class Service (private val mapper :Mapper){

    fun access() : List<Model> = mapper.access()


    fun getHelloService(name: String):String{
         return "Hello, $name !"
    }
    fun getHiService(name: Model):String{
        return "Hi, ${name.customerName} !"
    }
    fun getHaoService(name: Model):String{
        return "Hao, ${name.customerName} !"
    }
    fun getHeyService(name: String):String{
        return "Hey, $name !"
    }

}