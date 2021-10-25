package com.ecs.car;


import com.ecs.car.service.BootStrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CarApplication {
	@Autowired
	BootStrap bootstrap;

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void startup()
	{
		bootstrap.insertMake();
		bootstrap.insertModel();
		bootstrap.insertCar();
	}
}
