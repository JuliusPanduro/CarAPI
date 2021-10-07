package edu.kea.carapi.models;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "Name of the car and model")
    private String carModel;

    @Column
    @ApiModelProperty(notes = "Number of the car miles per gallon")
    private double carMpg;

    @Column
    @ApiModelProperty(notes = "Number of the amount of cylinders the car has")
    private int carCylinders;

    @Column
    @ApiModelProperty(notes = "Number of the car displacement")
    private double carDisplacement;

    @Column
    @ApiModelProperty(notes = "Number of the amount of horsepower's the car has")
    private double carHorsepower;

    @Column
    @ApiModelProperty(notes = "Number of the weight of the car")
    private double carWeight;

    @Column
    @ApiModelProperty(notes = "Number of the acceleration of the car")
    private double carAcceleration;

    @Column
    @ApiModelProperty(notes = "Year of when the car was build")
    private int carYear;

    @Column
    @ApiModelProperty(notes = "Name on the origin of the car")
    private String carOrigin;
}
