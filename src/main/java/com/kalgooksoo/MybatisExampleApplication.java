package com.kalgooksoo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kalgooksoo.mapper")
public class MybatisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisExampleApplication.class, args);
	}

}
