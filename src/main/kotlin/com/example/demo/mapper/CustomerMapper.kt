package com.example.demo.mapper

import com.example.demo.model.Customer
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface CustomerMapper {
    @Select("SELECT * FROM Customers")
    fun accessAllCustomer(): List<Customer>
    @Select("""
        SELECT 
            customer_id 
        FROM 
            Customers 
        WHERE 
            customer_id = #{customerId}
    """)
    fun existCheck(customerId: Int): Int?
}