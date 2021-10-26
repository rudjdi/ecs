package com.ecs.car.entity;

import com.ecs.car.custom.validation.NumericOnly;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.Year;

@Entity
@Setter
@Getter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "make should not be empty")
    @ManyToOne

    @JoinColumn(name = "make", referencedColumnName = "name")
    private Make make;

    @NotNull(message = "Model should not be empty")
    @ManyToOne
    @JoinColumn(name = "model", referencedColumnName = "name")
    private Model model;

    @Column
    @NotEmpty(message = "Color should not be empty")
    private String color;

    @Column
    @NumericOnly(message = "Year should be numeric only")
    private String year;

    public Car(Make make, Model model, String color, String year) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
    }
    public Car() {
    }
}
