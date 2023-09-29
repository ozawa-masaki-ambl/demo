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
    @GetMapping("/customers")
    fun Customers(): List<Customer> = service.customerAccess()

    /**
     * 購入履歴を購入者名と商品名がわかるように取得
     */
    @GetMapping("/histories")
    fun Histories(): List<History> = service.historyAccess()

    /**
     * 顧客IDを引数に顧客が購入した商品の一覧
     */
    @GetMapping("/histories/customers/{id}")
    fun HistoryById(@PathVariable("id") customerId: Int): List<History> = service.historyAccessById(customerId)
























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