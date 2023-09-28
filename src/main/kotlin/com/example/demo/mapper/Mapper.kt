package com.example.demo.mapper

import com.example.demo.model.Customer
import com.example.demo.model.History
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface Mapper {
    @Select("SELECT * FROM Customers")
    fun customerAccess(): List<Customer>
    @Select("SELECT Purchase_History.purchase_id, Customers.customer_name, Products.product_name, Purchase_History.purchase_datetime, Purchase_History.quantity FROM Purchase_History JOIN Customers ON Purchase_History.customer_id = Customers.customer_id JOIN Products ON Purchase_History.product_id = Products.product_id;")
    fun historyAccess(): List<History>
}