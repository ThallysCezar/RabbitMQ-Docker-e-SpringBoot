package com.ms.backend.worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@EnableRabbit
@SpringBootApplication
@Log4j2
public class BackendWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendWorkerApplication.class, args);
		log.info("Microsserviço do Worker iniciado com sucesso.");
	}

}
