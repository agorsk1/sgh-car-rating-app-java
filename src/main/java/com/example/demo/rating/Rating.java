package com.example.demo.rating;

import com.example.demo.car.Car;

import javax.persistence.*;


@Entity
@SequenceGenerator(
        name= "rating_sequence",
        sequenceName = "rating_sequence",
        initialValue = 1,
        allocationSize = 1
)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "email", "car_id" }) })
public class Rating {
    @Id

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_sequence"
    )
    private long id;
    private String email;
    private Integer rating;
    @ManyToOne
    private Car car;

    public Rating() {
    }

    public Rating(Long id, String email, Integer rating, Car car) {
        this.id = id;
        this.email = email;
        this.rating = rating;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

