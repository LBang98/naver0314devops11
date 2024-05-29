package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controller.*","*.member","data.*","tiles.config","com.example.demo","naver.cloud"})
@MapperScan("data.mapper")
public class BootMybatisTitlesV3Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisTitlesV3Application.class, args);
	}

	//순서 : xml->mapper->service->controller
}
