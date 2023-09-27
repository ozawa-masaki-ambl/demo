package com.example.demo.controller

import com.example.demo.model.Model
import com.example.demo.service.Service
import org.springframework.web.bind.annotation.*

@RestController
class Controller(private val service :Service) {


    @GetMapping("/getall")
    fun index(): String  {
        val modelList = service.customerAccess()
        return "$modelList"
    }
//    @GetMapping("/gethistory")
//    fun history(): String  {
//        val historyList = service.historyAccess()
//            return "$historyList"
//    }























    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHelloService(name)
    }
    @PostMapping("/hi")
    fun hi(@RequestBody model :Model):String{
        return service.getHiService(model)}
    @PutMapping("/hao")
    fun hao(@RequestBody model :Model):String{
        return service.getHaoService(model)}
    @DeleteMapping("/hey")
    fun hey(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHeyService(name)}
}
/**
 * get post put delete
 */