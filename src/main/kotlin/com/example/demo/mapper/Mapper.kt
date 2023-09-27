package com.example.demo.mapper

import com.example.demo.model.sModel
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface Mapper {
    @Select("SELECT * FROM Customer")
    fun access(): List<sModel?>
}