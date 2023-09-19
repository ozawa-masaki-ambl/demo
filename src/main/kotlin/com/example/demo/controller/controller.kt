package com.example.demo.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(){
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return "Hello, $name !"
    }
    @PostMapping("/hi")
    fun hi(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return "Hi, $name !"}
    @PutMapping("/hao")
    fun hao(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return "Hao, $name !"}
    @DeleteMapping("/hey")
    fun hey(@RequestParam(value = "name", defaultValue = "World") name :String):String{
        return "Hey, $name !"}
}
/**
 * get post put delete
 */