package com.example.demo

import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.annotation.MapperScans
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScans(MapperScan("com.example.demo.mapper"))
class SpringDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringDemoApplication>(*args)//　Kotlinはmainとコントローラークラスは別にしないと動かない！！（普通はファイルを分ける？）
}
