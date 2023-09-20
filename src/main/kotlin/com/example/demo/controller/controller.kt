package com.example.demo.controller

import com.example.demo.model.Model
import com.example.demo.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(var service :Service) {
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHelloService(name)
    }
    @PostMapping("/hi")
    fun hi(@RequestBody model :Model):String{
        return service.getHiService(model.name)}
    @PutMapping("/hao")
    fun hao(@RequestBody model :Model):String{
        return service.getHaoService(model.name)}
    @DeleteMapping("/hey")
    fun hey(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return service.getHeyService(name)}
}
/**
 * get post put delete
 */