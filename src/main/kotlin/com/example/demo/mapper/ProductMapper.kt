package com.example.demo.mapper

import org.apache.ibatis.annotations.Select

interface ProductMapper {
    @Select("""SELECT EXISTS (SELECT * FROM Products WHERE product_id=#{productId})""")
    fun  existCheck(productId:Int?): Boolean
}