package com.example.demo.mapper

import com.example.demo.model.Customer
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface CustomerMapper {
    @Select("SELECT * FROM Customers")
    fun customerAccess(): List<Customer>

}