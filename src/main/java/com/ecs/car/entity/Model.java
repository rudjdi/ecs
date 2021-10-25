package com.ecs.car.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class Model {
    @Id
    private String name;
    @OneToMany(mappedBy = "model")
    private List<Car> car_list;

    public Model(String name) {
        this.name = name;
    }
    public Model() {
    }
}
