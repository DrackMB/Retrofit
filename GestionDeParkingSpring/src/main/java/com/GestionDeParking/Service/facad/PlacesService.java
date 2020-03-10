package com.GestionDeParking.Service.facad;

import com.GestionDeParking.bean.Parking;

public interface PlacesService {

    int updatePlace(int place, Parking parking);

    int deleteByParkingLiblle(String libelle);
}
