package edu.kea.carapi.models;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Julius Panduro
 */
@Data
@Table(name = "cars")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long carId;

    @Column
    private String carModel;

    @Column
    private double carMpg;

    @Column
    private int carCylinders;

    @Column
    private double carDisplacement;

    @Column
    private double carHorsepower;

    @Column
    private double carWeight;

    @Column
    private double carAcceleration;

    @Column
    private int carYear;

    @Column
    private String carOrigin;

}
