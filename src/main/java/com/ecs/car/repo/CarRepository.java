package com.ecs.car.repo;

import com.ecs.car.entity.Car;
import com.ecs.car.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "car")
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByYear(String year);
    List<Car> findByColor(String color);
}
