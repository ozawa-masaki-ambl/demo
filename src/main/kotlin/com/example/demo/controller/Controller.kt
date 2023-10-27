package com.example.demo.controller

import com.example.demo.model.Customer
import com.example.demo.model.EditHistory
import com.example.demo.model.History
import com.example.demo.model.Model
import com.example.demo.model.RegisterHistory
import com.example.demo.service.Service
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class Controller(private val service: Service) {

    /**
     * 顧客情報を取得
     */
    @GetMapping("/customers")
    fun getCustomers(): List<Customer> = service.accessAllCustomer()

    /**
     * 購入履歴を購入者名と商品名がわかるように取得
     */
    @GetMapping("/histories")
    fun getHistories(): List<History> = service.accessAllHistory()

    /**
     * 顧客IDを引数に顧客が購入した商品の一覧
     */
    @GetMapping("/histories/customers/{id}")
    fun getHistoryById(@PathVariable("id") customerId: Int): List<History> = service.historyAccessById(customerId)

    /**
     * 商品の購入情報を登録する
     */
    @PostMapping("/histories/registration")
    fun registerHistory(@Validated @RequestBody registerHistory: RegisterHistory, result: BindingResult) {
        if (result.hasErrors()) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        } else {
            service.registerHistory(registerHistory)
        }
    }

    /**
     * 商品の購入情報を編集する
     */
    @PutMapping("/histories/{id}")
    fun editHistory(@PathVariable("id") purchaseId: Int, @RequestBody editHistory: EditHistory) {
        service.editHistory(editHistory, purchaseId)
    }

    /**
     * 商品の購入情報を削除する
     */
    @DeleteMapping("/histories/{id}")
    fun deleteHistory(@PathVariable("id") purchaseId: Int) {
        service.deleteHistory(purchaseId)
    }







    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return service.getHelloService(name)
    }

    @PostMapping("/hi")
    fun hi(@RequestBody model: Model): String {
        return service.getHiService(model)
    }

    @PutMapping("/hao")
    fun hao(@RequestBody model: Model): String {
        return service.getHaoService(model)
    }

    @DeleteMapping("/hey")
    fun hey(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return service.getHeyService(name)
    }
}
/**
 * get post put delete
 */