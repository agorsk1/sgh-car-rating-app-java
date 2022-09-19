package com.example.demo.car;

import com.example.demo.car.dtos.CarListDTO;
import com.example.demo.car.errors.IncorrectMakeNameException;
import com.example.demo.car.errors.IncorrectModelNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> conflict(DataIntegrityViolationException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        return new ResponseEntity<Object>(
                message, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IncorrectModelNameException.class)
    public ResponseEntity<Object> conflict(IncorrectModelNameException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        return new ResponseEntity<Object>(
                message, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectMakeNameException.class)
    public ResponseEntity<Object> conflict(IncorrectMakeNameException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        return new ResponseEntity<Object>(
                message, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<CarListDTO> getCars() {
        return carService.getCars();
    }

    @GetMapping(path = "/top")
    public List<CarListDTO> getTopRatedCars() {
            return carService.getTopRatedCars();
       }

    @PostMapping
    public void registerNewCar(@RequestBody  Car car){
        carService.addNewCar(car);
    }
}
