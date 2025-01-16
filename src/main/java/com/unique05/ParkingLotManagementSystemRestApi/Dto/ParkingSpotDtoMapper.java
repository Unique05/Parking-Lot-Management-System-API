package com.unique05.ParkingLotManagementSystemRestApi.Dto;

import com.unique05.ParkingLotManagementSystemRestApi.Entity.ParkingSpots;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ParkingSpotDtoMapper implements Function<ParkingSpots, ParkingSpotDto> {
    @Override
    public ParkingSpotDto apply(ParkingSpots parkingSpots){
        return new ParkingSpotDto(
                parkingSpots.getTypeOfCar(),
                parkingSpots.getOccupied());
    }
}
