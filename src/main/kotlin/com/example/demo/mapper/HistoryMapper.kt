package com.example.demo.mapper

import com.example.demo.model.History
import com.example.demo.model.HistoryOrigin
import com.example.demo.model.RegisterHistory
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface HistoryMapper {
    @Select("""
        SELECT
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
    """)
    fun historyAccess(): List<History>

    @Select("""
        SELECT
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
            pur.customer_id=#{customerId}
    """)
    fun historyAccessById(customerId: Int): List<History>

    @Insert("""
        INSERT INTO 
            Purchase_History (customer_id, product_id, purchase_datetime, quantity)
        VALUES(
            #{customerId},
            #{productId},
            CURRENT_TIMESTAMP,
            #{quantity})
    """)
    fun registerHistory(registerHistory: RegisterHistory)

    @Update("""
        UPDATE 
            Purchase_History 
        SET 
            customer_id = #{customerId}, 
            product_id = #{productId}, 
            quantity = #{quantity} 
        WHERE 
            purchase_id = #{purchaseId}
    """)
    fun editHistory(historyOrigin: HistoryOrigin)

    @Select("""
        SELECT
            purchase_id, 
            customer_id, 
            product_id, 
            purchase_datetime, 
            quantity
        FROM 
            Purchase_History
        WHERE 
            purchase_id = #{purchaseId}
    """)
    fun findHistoryRow(purchaseId: Int): HistoryOrigin?

}