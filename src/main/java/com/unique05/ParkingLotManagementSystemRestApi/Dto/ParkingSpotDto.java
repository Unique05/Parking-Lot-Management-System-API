package com.unique05.ParkingLotManagementSystemRestApi.Dto;

import com.unique05.ParkingLotManagementSystemRestApi.Entity.TypeOfCar;

public record ParkingSpotDto(
        TypeOfCar typeOfCar,
        boolean occupied)
{ // a DTO should be simple as possible with no logic

}
