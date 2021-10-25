package com.ecs.car.service;

import com.ecs.car.entity.Car;
import com.ecs.car.entity.Make;
import com.ecs.car.entity.Model;
import com.ecs.car.repo.CarRepository;
import com.ecs.car.repo.MakeRepository;
import com.ecs.car.repo.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.Year;
import java.util.List;
import java.util.Optional;
@Slf4j
@Controller
public class BootStrap {
    @Autowired
    CarRepository carRepository;
    @Autowired
    MakeRepository makeRepository;
    @Autowired
    ModelRepository modelRepository;

    public void insertMake()
    {
        makeRepository.save(new Make("bmw"));
        makeRepository.save(new Make("mercedes"));
        makeRepository.save(new Make("toyota"));
        makeRepository.save(new Make("mazda"));
        makeRepository.save(new Make("audi"));
    }
    public void insertModel()
    {
        modelRepository.save(new Model("suv"));
        modelRepository.save(new Model("hatchback"));
        modelRepository.save(new Model("sports"));
        modelRepository.save(new Model("estate"));
    }

    public void insertCar()
    {
        String size=null;
        List<Car> list= carRepository.findAll();
        if(list.size()>0) {
            size = String.valueOf(list.size());
        }
        Optional.ofNullable(size).ifPresentOrElse(car -> log.info("CAR EXIST IN DB : "+list.size()),() -> {
            carRepository.save(new Car(new Make("bmw"),new Model("suv"),"Green",Year.now().toString()));
            carRepository.save(new Car(new Make("bmw"),new Model("suv"),"Red",Year.now().toString()));
            carRepository.save(new Car(new Make("audi"),new Model("suv"),"Blue",Year.now().toString()));
            carRepository.save(new Car(new Make("toyota"),new Model("estate"),"Black",Year.now().minusYears(4).toString()));
            carRepository.save(new Car(new Make("toyota"),new Model("suv"),"Yellow",Year.now().toString()));
        });
    }
}
