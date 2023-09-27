package com.example.demo.mapper

import com.example.demo.model.Model
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface Mapper {
    @Select("SELECT * FROM Customers")
    fun access(): List<Model?>
}