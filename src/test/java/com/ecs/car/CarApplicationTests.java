package com.ecs.car;

import com.ecs.car.entity.Car;
import com.ecs.car.entity.Make;
import com.ecs.car.entity.Model;
import com.ecs.car.model.RestResponse;
import com.ecs.car.repo.CarRepository;
import com.ecs.car.repo.MakeRepository;
import com.ecs.car.repo.ModelRepository;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import java.net.URISyntaxException;
import java.time.Year;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarApplicationTests {
private Logger logger= LoggerFactory.getLogger(CarApplicationTests.class);
	@Autowired
	MakeRepository makeRepository;
	@Autowired
	ModelRepository modelRepository;
	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void removeFirstIfExist() throws URISyntaxException {
		logger.info("-------------RUNNING BEFORE-------------------------------");
		Optional<Make> make=makeRepository.findById("testmake");
		make.ifPresent(make1 -> makeRepository.delete(make1));

		Optional<Model> model=modelRepository.findById("testmodel");
		model.ifPresent(model1 -> modelRepository.delete(model1));
	}

	@Test
	void test_C_insertMake() throws URISyntaxException {
		logger.info("-------------RUNNING test_C_insertMake-------------------------------");
		Make make=new Make("testmake");
		ResponseEntity<String> response=testRestTemplate.postForEntity("/make",make, String.class);
		Assert.assertThat(response.getBody(), CoreMatchers.containsString("testmake"));
	}

	@Test
	void test_D_insertModel() throws URISyntaxException {
		logger.info("-------------RUNNING test_D_insertModel-------------------------------");
		Model model=new Model("testmodel");
		ResponseEntity<String> response=testRestTemplate.postForEntity("/model",model, String.class);
		Assert.assertThat(response.getBody(), CoreMatchers.containsString("testmodel"));
	}

	@AfterEach
	void remoFromDb() throws URISyntaxException {
		logger.info("-------------RUNNING AFTER-------------------------------");
		Optional<Make> make=makeRepository.findById("testmake");
		make.ifPresent(make1 -> makeRepository.delete(make1));

		Optional<Model> model=modelRepository.findById("testmodel");
		model.ifPresent(model1 -> modelRepository.delete(model1));
	}
}
