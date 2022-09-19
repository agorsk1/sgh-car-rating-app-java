package com.example.demo.car;

import com.example.demo.car.dtos.CarListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT new com.example.demo.car.dtos.CarListDTO(c.id, c.make, c.model, avg(coalesce(r.rating, 0))) FROM Car c LEFT JOIN Rating r ON c.id = r.car.id GROUP BY c.id, c.make, c.model")
    List<CarListDTO> getCarListWithAvgRatings();

    @Query(value = "SELECT new com.example.demo.car.dtos.CarListDTO(c.id, c.make, c.model, avg(coalesce(r.rating, 0))) FROM Car c LEFT JOIN Rating r ON c.id = r.car.id GROUP BY c.id, c.make, c.model ORDER BY avg(coalesce(r.rating, 0)) DESC")
    Page<CarListDTO> getCarTopAvgRatings(Pageable pageable);

    Car getCarByMakeAndModel(String make, String model);
}
