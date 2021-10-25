package com.ecs.car.repo;

import com.ecs.car.entity.Make;
import com.ecs.car.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "model")
public interface ModelRepository extends JpaRepository<Model, String> {
}
