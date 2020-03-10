package com.GestionDeParking.Service.impl;

import com.GestionDeParking.Repository.ParkingRepository;
import com.GestionDeParking.Service.facad.ParkingService;
import com.GestionDeParking.Service.facad.PlacesService;
import com.GestionDeParking.bean.Parking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl
        implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private PlacesService placesService;

    @Override
    public int save(Parking parking) {
         if (findByLiblle(parking.getLiblle()) == null) {
            return -1;
        }
         this.parkingRepository.save(parking);
        return 1;
    }

    @Override
    public int deleteByLiblle(String liblle) {
        this.placesService.deleteByParkingLiblle(liblle);
        return this.parkingRepository.deleteByLiblle(liblle);
    }

    @Override
    public List<Parking> findAll() {
        return this.parkingRepository.findAll();
    }

    @Override
    public Parking findByLiblle(String liblle) {
        return this.parkingRepository.findByLiblle(liblle);
    }
}


