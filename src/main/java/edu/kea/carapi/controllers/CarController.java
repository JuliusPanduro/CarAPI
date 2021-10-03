package edu.kea.carapi.controllers;

import edu.kea.carapi.exceptions.CarNotFoundException;
import edu.kea.carapi.models.Car;
import edu.kea.carapi.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Julius Panduro
 */
@RestController
public class CarController {
    @Autowired
    CarRepository repository;

    @GetMapping("/cars")
    List<Car> all() {
        return repository.findAll();
    }

    @GetMapping("/cars/{id}")
    Car getCarbyId(@PathVariable long id) {
        return repository.findById(id).orElseThrow(()-> new CarNotFoundException(id));
    }

    @PostMapping("/cars")
    Car addNewCar(@RequestBody Car newCar) {
        return repository.save(newCar);
    }

    @PutMapping("/cars/{id}")
    Car updateCarById(@PathVariable long id, @RequestBody Car newCar) {
        return repository.findById(id).map(car -> {
            car.setCarModel(newCar.getCarModel());
            car.setCarMpg(newCar.getCarMpg());
            car.setCarCylinders(newCar.getCarCylinders());
            car.setCarDisplacement(newCar.getCarDisplacement());
            car.setCarHorsepower(newCar.getCarHorsepower());
            car.setCarWeight(newCar.getCarWeight());
            car.setCarAcceleration(newCar.getCarAcceleration());
            car.setCarYear(newCar.getCarYear());
            car.setCarOrigin(newCar.getCarOrigin());
            return repository.save(car);
        }).orElseGet(() -> {
            newCar.setCarId(id);
            return repository.save(newCar);
        });
    }

    @DeleteMapping("/cars/{id}")
    void deleteCarById(@PathVariable long id) {
        repository.deleteById(id);
    }
}
