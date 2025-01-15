package com.unique05.ParkingLotManagementSystemRestApi.Repository;

import com.unique05.ParkingLotManagementSystemRestApi.Entity.ParkingSpots;
import com.unique05.ParkingLotManagementSystemRestApi.Entity.TypeOfCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingSpots, Integer> {
    List<ParkingSpots> findAllByTypeOfCar(TypeOfCar typeOfCar);

    ParkingSpots findByCarPlateNumber(String carPlateNumber);

//    ParkingSpots deleteByParkingSpotId(String parkingSpotId);
//    ParkingSpots findByParkingSpotId(String parkingSpotId);
}
