package com.GestionDeParking.Service.facad;

import com.GestionDeParking.bean.Reservation;
import java.util.List;

public interface ReservationService {

    Reservation findByClientNumCIN(String numCIN);

    int deleteByClientNumCIN(String numCIN);

    int save(Reservation reservation);

    int validateReservation(boolean validat, Reservation reservation);

    List<Reservation> findAll();
}
