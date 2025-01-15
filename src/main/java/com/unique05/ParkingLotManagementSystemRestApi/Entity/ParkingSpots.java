package com.unique05.ParkingLotManagementSystemRestApi.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
public class ParkingSpots {

    @Id
    @GeneratedValue
//    (generator = "custom-sequence")
//    @GenericGenerator(
//            name = "custom-sequence",
//            strategy = "com.unique05.ParkingLotManagementSystemRestApi.Config.PrefixedSequenceIdGenerator",
//            parameters = @Parameter(name = "sequence_name", value = "parkingspots_id_sequence")
//    )
    private int parkingSpotId;
    @Enumerated(EnumType.STRING)
    private TypeOfCar typeOfCar;
    private boolean occupied;
    private String carPlateNumber;


    public ParkingSpots(){}

    public ParkingSpots(int parkingSpotId, TypeOfCar typeOfCar, boolean occupied, String carPlateNumber) {
        this.parkingSpotId = parkingSpotId;
        this.typeOfCar = typeOfCar;
        this.occupied = occupied;
        this.carPlateNumber = carPlateNumber;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }
//    public ParkingSpots orElse(Object o) {
//        return null;
//    }
}
