package com.ecs.car.repo;

import com.ecs.car.entity.Car;
import com.ecs.car.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

@RepositoryRestResource(path = "make")
public interface MakeRepository extends JpaRepository<Make, String> {
}
