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
public class Make {
    @Id
    private String name;
    @OneToMany(mappedBy = "make")
    private List<Car> car_list;

    public Make(String name) {
        this.name = name;
    }
    public Make() {
    }
}
