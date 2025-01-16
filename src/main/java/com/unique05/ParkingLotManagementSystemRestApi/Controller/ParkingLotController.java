package com.unique05.ParkingLotManagementSystemRestApi.Controller;

import com.unique05.ParkingLotManagementSystemRestApi.Dto.ParkingSpotDto;
import com.unique05.ParkingLotManagementSystemRestApi.Entity.ParkingSpots;
import com.unique05.ParkingLotManagementSystemRestApi.Entity.TypeOfCar;
import com.unique05.ParkingLotManagementSystemRestApi.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parkingLot")
public class ParkingLotController {
     @Autowired
    private ParkingLotService service;

     @PostMapping("/addSpot")
     public ParkingSpots addSpot(@RequestBody ParkingSpots parkingSpot){
         System.out.println("Received: " + parkingSpot);
         return service.saveSpot(parkingSpot);
     }

     @PostMapping("/addSpots")
     public List<ParkingSpots> addSpots(@RequestBody List<ParkingSpots> parkingSpots){
        return service.saveSpots(parkingSpots);
     }

     @GetMapping("/displaySpots")
    public List<ParkingSpotDto> findAllSpots(){
         return service.displaySpots();
     }

    @GetMapping("/displaySpotById/{parkingSpotId}")
    public ParkingSpotDto findById(@PathVariable int parkingSpotId) {
         return service.displaySpotById(parkingSpotId);}

    @GetMapping("/displaySpotByPlateNumber/{carPlateNumber}")
    public ParkingSpots findByPlateNumber(@PathVariable String carPlateNumber) {
        return service.displaySpotByPlateNumber(carPlateNumber);}

    @GetMapping("/displaySpotsByType/{typeOfCar}")
    public List<ParkingSpots> findAllByType(@PathVariable TypeOfCar typeOfCar){
         return service.displaySpotsByType(typeOfCar);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteSpotsId(@PathVariable int parkingSpotId){
         return service.deleteSpot(parkingSpotId);
    }

    @PutMapping("/updating")
    public ParkingSpots update(@RequestBody ParkingSpots parkingSpots){
        return service.updateOccupied(parkingSpots);
    }



}
