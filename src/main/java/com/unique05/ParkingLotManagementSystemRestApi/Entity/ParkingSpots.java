package com.unique05.ParkingLotManagementSystemRestApi.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table
@Data
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
    private Boolean occupied;
    private String carPlateNumber;
}
