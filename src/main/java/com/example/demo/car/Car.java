package com.example.demo.car;

import com.example.demo.rating.Rating;

import javax.persistence.*;

import java.util.Set;

@Entity
@SequenceGenerator(
        name= "car_sequence",
        sequenceName = "car_sequence",
        initialValue = 1,
        allocationSize = 1
)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "make", "model" }) })
public class Car {
    @Id
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE, generator = "car_sequence"
    )
    private long id;
    private String make;
    private String model;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    public Car() {
    }
    public Car(String make, String model) {
        this.make = make.toLowerCase();
        this.model = model.toLowerCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
