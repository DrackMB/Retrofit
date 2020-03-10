package com.GestionDeParking.Service.facad;

import com.GestionDeParking.bean.Parking;
import java.util.List;

public interface ParkingService {

    int save(Parking parking);

    int deleteByLiblle(String libelle);

    List<Parking> findAll();

    Parking findByLiblle(String libelle);
}
