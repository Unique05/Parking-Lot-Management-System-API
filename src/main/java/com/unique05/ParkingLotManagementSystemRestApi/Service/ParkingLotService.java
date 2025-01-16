package com.unique05.ParkingLotManagementSystemRestApi.Service;

import com.unique05.ParkingLotManagementSystemRestApi.Dto.ParkingSpotDto;
import com.unique05.ParkingLotManagementSystemRestApi.Dto.ParkingSpotDtoMapper;
import com.unique05.ParkingLotManagementSystemRestApi.Entity.ParkingSpots;
import com.unique05.ParkingLotManagementSystemRestApi.Entity.TypeOfCar;
import com.unique05.ParkingLotManagementSystemRestApi.Repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotService {
    @Autowired
    private final ParkingLotRepository repository;
    private final ParkingSpotDtoMapper parkingSpotDtoMapper;

    public ParkingLotService(ParkingLotRepository repository, ParkingSpotDtoMapper parkingSpotDtoMapper) {
        this.repository = repository;
        this.parkingSpotDtoMapper = parkingSpotDtoMapper;
    }

    public ParkingSpots saveSpot(ParkingSpots parkingSpot){
        return repository.save(parkingSpot);
    }

    public List<ParkingSpots> saveSpots(List<ParkingSpots> parkingSpots){
        return repository.saveAll(parkingSpots);
    }

    public List<ParkingSpotDto> displaySpots(){
        return repository.findAll()
                .stream()
                .map(parkingSpotDtoMapper)
                .collect(Collectors.toList());
    }

    public ParkingSpotDto displaySpotById(int parkingSpotId){
        return repository.findById(parkingSpotId)
                .map(parkingSpotDtoMapper)
                .orElse(null);
    }

    public List<ParkingSpots> displaySpotsByType(TypeOfCar TypeOfCar){
        return  repository.findAllByTypeOfCar(TypeOfCar);
    }

    public String deleteSpot( int parkingSpotId){
        repository.deleteById(parkingSpotId);
        return parkingSpotId + " deleted";
    }

    public ParkingSpots updateOccupied(ParkingSpots parkingSpots){
        ParkingSpots existingSpot = repository.findById(parkingSpots.getParkingSpotId()).orElse(null);

        if (existingSpot == null){
            return null;
        }
        existingSpot.setTypeOfCar(parkingSpots.getTypeOfCar());
        existingSpot.setOccupied(parkingSpots.getOccupied());
        return repository.save(existingSpot);
    }

    public ParkingSpots displaySpotByPlateNumber(String carPlateNumber) {
        return repository.findByCarPlateNumber(carPlateNumber);
    }
}
