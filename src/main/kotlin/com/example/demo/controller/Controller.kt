package com.example.demo.controller

import com.example.demo.model.Customer
import com.example.demo.model.History
import com.example.demo.model.Model
import com.example.demo.service.Service
import org.springframework.web.bind.annotation.*

@RestController
class Controller(private val service :Service) {

    /**
     * 顧客情報を取得
     */
    @GetMapping("/get/customers")
    fun getCustomers(): List<Customer> = service.customerAccess()

    /**
     * 購入履歴を購入者名と商品名がわかるように取得
     */
    @GetMapping("/get/histories")
    fun getHistories(): List<History> = service.historyAccess()
























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