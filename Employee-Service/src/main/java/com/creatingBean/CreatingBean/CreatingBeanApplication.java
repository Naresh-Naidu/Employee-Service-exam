package com.creatingBean.CreatingBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import com.creatingBean.CreatingBean.module.Demo;

@SpringBootApplication
@ComponentScan(basePackages = "com.creatingBean")
public class CreatingBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatingBeanApplication.class, args);
	}

}
