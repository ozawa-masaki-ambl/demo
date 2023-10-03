package com.example.demo.mapper

import org.apache.ibatis.annotations.Select

interface ProductMapper {
    @Select("""SELECT 
                product_id 
            FROM 
                Products 
            WHERE 
                product_id = #{productId}""")
    fun existCheck(productId: Int): Int?
}