package edu.kea.carapi.controllers;

import edu.kea.carapi.exceptions.CarNotFoundException;
import edu.kea.carapi.models.Car;
import edu.kea.carapi.repositories.CarRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Api(value = "Cars Controller",description = "REST endpoints for cars")
@RestController
public class Cars {
    @Autowired
    CarRepository cars;

    @GetMapping("/cars")
    List<Car> all() {
        return cars.findAll();
    }

    @GetMapping("/cars/{id}")
    Car getCarbyId(@PathVariable long id) {
        return cars.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    @PostMapping("/cars")
    Car addNewCar(@RequestBody Car newCar) {
        return cars.save(newCar);
    }

    @PutMapping("/cars/{id}")
    Car updateCarById(@PathVariable long id, @RequestBody Car carToUpdateWith) {
        if (cars.existsById(id)) {
            carToUpdateWith.setCarId(id);
            return cars.save(carToUpdateWith);
        } else
            throw new CarNotFoundException(id);
    }

    @PatchMapping("/cars/{id}")
    Car patchCarById(@PathVariable long id, @RequestBody Car patchedCar) {
        return cars.findById(id).map(foundCar -> {
            if (patchedCar.getCarModel() != null) {
                foundCar.setCarModel(patchedCar.getCarModel());
            }
            if (patchedCar.getCarMpg() != 0) {
                foundCar.setCarMpg(patchedCar.getCarMpg());
            }
            if (patchedCar.getCarCylinders() != 0) {
                foundCar.setCarCylinders(patchedCar.getCarCylinders());
            }
            if (patchedCar.getCarDisplacement() != 0) {
                foundCar.setCarDisplacement(patchedCar.getCarDisplacement());
            }
            if (patchedCar.getCarHorsepower() != 0) {
                foundCar.setCarHorsepower(patchedCar.getCarHorsepower());
            }
            if (patchedCar.getCarWeight() != 0) {
                foundCar.setCarWeight(patchedCar.getCarWeight());
            }
            if (patchedCar.getCarAcceleration() != 0) {
                foundCar.setCarAcceleration(patchedCar.getCarAcceleration());
            }
            if (patchedCar.getCarYear() != 0) {
                foundCar.setCarYear(patchedCar.getCarYear());
            }
            if (patchedCar.getCarOrigin() != null) {
                foundCar.setCarOrigin(patchedCar.getCarOrigin());
            }
            return cars.save(foundCar);
        }).orElseThrow(() -> new CarNotFoundException(id));
    }

    @DeleteMapping("/cars/{id}")
    void deleteCarById(@PathVariable long id) {
        cars.deleteById(id);
    }
}
