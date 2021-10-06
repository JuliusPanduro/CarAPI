package edu.kea.carapi.exceptions;

/**
 * @author Julius Panduro
 */
public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(long id){
        super("Could not find car with id: " + id);
    }
}
