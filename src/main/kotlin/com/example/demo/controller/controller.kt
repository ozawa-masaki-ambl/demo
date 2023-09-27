package com.example.demo.controller

import com.example.demo.model.sModel
import com.example.demo.service.Service
import org.springframework.web.bind.annotation.*

@RestController
class Controller(private val service :Service) {


    @GetMapping("/getall")
    fun index(): String  {
        val smodelList = service.access()
        return "$smodelList"
    }
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHelloService(name)
    }
    @PostMapping("/hi")
    fun hi(@RequestBody sModel :sModel):String{
        return service.getHiService(sModel)}
    @PutMapping("/hao")
    fun hao(@RequestBody sModel :sModel):String{
        return service.getHaoService(sModel)}
    @DeleteMapping("/hey")
    fun hey(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHeyService(name)}
}
/**
 * get post put delete
 */