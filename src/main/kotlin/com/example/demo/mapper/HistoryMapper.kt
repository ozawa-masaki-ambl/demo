package com.example.demo.mapper

import com.example.demo.model.History
import com.example.demo.model.RegisterHistory
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
@Mapper
interface HistoryMapper {
    @Select("""SELECT
                pur.purchase_id,
                cus.customer_name,
                pro.product_name,
                pur.purchase_datetime,
                pur.quantity
            FROM
                Purchase_History pur
            JOIN
                Customers cus ON pur.customer_id = cus.customer_id
            JOIN
                Products pro ON pur.product_id = pro.product_id""")
    fun historyAccess(): List<History>

    @Select("""SELECT
                pur.purchase_id,
                cus.customer_name,
                pro.product_name,
                pur.purchase_datetime,
                pur.quantity
            FROM
                Purchase_History pur
            JOIN
                Customers cus ON pur.customer_id = cus.customer_id
            JOIN
                Products pro ON pur.product_id = pro.product_id
            WHERE
                pur.customer_id=#{customerId}""")
    fun historyAccessById(customerId: Int): List<History>

    @Insert("""INSERT INTO Purchase_History (customer_id, product_id, purchase_datetime, quantity)
    VALUES(
        #{customerId},
        #{productId},
        CURRENT_TIMESTAMP,
        #{quantity})""")
    fun registerHistory(registerHistory: RegisterHistory)


}