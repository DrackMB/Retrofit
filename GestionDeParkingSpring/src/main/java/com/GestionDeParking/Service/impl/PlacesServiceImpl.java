package com.GestionDeParking.Service.impl;

import com.GestionDeParking.Repository.PlacesRepository;
import com.GestionDeParking.Service.facad.ParkingService;
import com.GestionDeParking.Service.facad.PlacesService;
import com.GestionDeParking.bean.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacesServiceImpl
        implements PlacesService {

    @Autowired
    private PlacesRepository placesRepository;
    @Autowired
    private ParkingService parkingService;

    @Override
    public int updatePlace(int place, Parking parking) {
         Parking parkingResult = parkingService.findByLiblle(parking.getLiblle());
         if (parkingResult == null) {
             return -1;
        }
         placesRepository.updatePlace(place, parking);
        return 1;
    }

    @Override
    public int deleteByParkingLiblle(String liblle) {
        return this.placesRepository.deleteByParkingLiblle(liblle);
    }
}



