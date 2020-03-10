package com.GestionDeParking.Service.impl;

import com.GestionDeParking.Repository.ReservationRepository;
import com.GestionDeParking.Service.facad.ReservationService;
import com.GestionDeParking.bean.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl
        implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation findByClientNumCIN(String numCIN) {
        return reservationRepository.findByClientNumCIN(numCIN);
    }

    @Override
    public int deleteByClientNumCIN(String numCIN) {
         return reservationRepository.deleteByClientNumCIN(numCIN);
    }

    @Override
    public int save(Reservation reservation) {
         Reservation reservationREsutl = findByClientNumCIN(reservation.getClient().getNumCIN());
         if (reservationREsutl != null
                && reservationREsutl.getParking().getLiblle().equals(reservation.getParking().getLiblle())) {
            return -1;
        }

         if (reservation.getDateEntre().before(new Date()) || reservation.getDateSortie().before(new Date())) {
            return -1;
        }
         reservationRepository.save(reservation);
         return 1;
    }

    @Override
    public int validateReservation(boolean validat, Reservation reservation) {
         return reservationRepository.validateReservation(validat, reservation.getClient());
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}


