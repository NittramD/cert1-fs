package com.example.cert1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication {
    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
        System.out.println("Microservicio Tareas iniciado en puerto 8080");
        System.out.println("URL: http://localhost:8080/api/v1/tareas");
		System.out.println("\nMartin Diaz Gutierrez");
    }
}