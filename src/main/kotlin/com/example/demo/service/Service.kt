package com.example.demo.service

import org.springframework.stereotype.Service

@Service
class Service {
    fun getHelloService(name: String):String{
         return "Hello, $name !"
    }
    fun getHiService(name: String):String{
        return "Hi, $name !"
    }
    fun getHaoService(name: String):String{
        return "Hao, $name !"
    }
    fun getHeyService(name: String):String{
        return "Hey, $name !"
    }

}