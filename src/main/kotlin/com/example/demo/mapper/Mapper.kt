package com.example.demo.mapper

import com.example.demo.model.Customer
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface Mapper {
    @Select("SELECT * FROM Customers")
    fun customerAccess(): List<Customer>
//    @Select("SELECT * FROM Purchase_History")
//    fun historyAccess(): List<History>
}