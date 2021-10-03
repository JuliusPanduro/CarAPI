package edu.kea.carapi.repositories;

import edu.kea.carapi.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Julius Panduro
 */
public interface CarRepository extends JpaRepository<Car,Long> {

}
