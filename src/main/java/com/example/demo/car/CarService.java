package com.example.demo.car;

import com.example.demo.car.dtos.CarListDTO;
import com.example.demo.car.errors.IncorrectMakeNameException;
import com.example.demo.car.errors.IncorrectModelNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final RestTemplate template;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        template = new RestTemplate();
    }

    public void addNewCar(Car car) {
        Boolean isModelValid = false;
        String url = "https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMake/" + car.getMake().toLowerCase() + "?format=json";
        VPCResponse vpcResponse  = template.getForObject(url, VPCResponse.class);
        List<CarVPC> cars = vpcResponse.getResult();
        if (cars.isEmpty()) {
            throw new IncorrectMakeNameException("Incorrect car make : " + car.getMake());
        }
        for (int i = 0; i < cars.size(); i++){
            CarVPC carVPC = cars.get(i);
            if (car.getModel().equalsIgnoreCase(carVPC.getModel())){
                String make = carVPC.getMake().toLowerCase();
                String model = carVPC.getModel().toLowerCase();
                Car fetched_car = carRepository.getCarByMakeAndModel(make, model);
                if (fetched_car == null) {
                    carRepository.save(new Car(make, model));
                }
                isModelValid = true;
                break;
            }
        }
        if (!isModelValid) {
            throw new IncorrectModelNameException("Incorrect car model : " + car.getModel());
        }
    }
    public List<CarListDTO> getCars() {return carRepository.getCarListWithAvgRatings(); }

    public List<CarListDTO> getTopRatedCars() {return carRepository.getCarTopAvgRatings(PageRequest.of(0, 5)).getContent();}
}
