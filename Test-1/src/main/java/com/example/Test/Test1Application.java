package com.example.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Test1Application {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(Test1Application.class, args);
//		System.out.println("FFFFFFFFFFFFFFF"+run.getBeanDefinitionCount());
	}
}
