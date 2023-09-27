package com.example.demo.mapper

import com.example.demo.model.Model
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select


@Mapper
interface Mapper {
    @Select("SELECT * FROM Customers")
    fun customerAccess(): List<Model>
//    @Select("SELECT * FROM Purchase_History")
//    fun historyAccess(): List<History>
}