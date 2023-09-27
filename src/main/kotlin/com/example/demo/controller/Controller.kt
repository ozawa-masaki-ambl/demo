package com.example.demo.controller

import com.example.demo.model.Model
import com.example.demo.service.Service
import org.springframework.web.bind.annotation.*

@RestController
class Controller(private val service :Service) {


    @GetMapping("/getall")
    fun index(): String  {
        val modelList = service.access()
        return "$modelList"
    }
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHelloService(name)
    }
    @PostMapping("/hi")
    fun hi(@RequestBody Model :Model):String{
        return service.getHiService(Model)}
    @PutMapping("/hao")
    fun hao(@RequestBody Model :Model):String{
        return service.getHaoService(Model)}
    @DeleteMapping("/hey")
    fun hey(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHeyService(name)}
}
/**
 * get post put delete
 */