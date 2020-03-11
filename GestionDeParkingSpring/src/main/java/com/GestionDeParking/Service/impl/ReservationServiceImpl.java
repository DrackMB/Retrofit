package com.GestionDeParking.Service.impl;

import com.GestionDeParking.Repository.ReservationRepository;
import com.GestionDeParking.Service.facad.ReservationService;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

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
         if (reservationREsutl != null && reservationREsutl.getParking().getLiblle().equals(reservation.getParking().getLiblle())) {
            return -1;
        }
         if (reservation.getDateEntre().before(new Date()) || reservation.getDateSortie().before(new Date())) {
            return -2;
        }
         reservationRepository.save(reservation);
         return 1;
    }
    @Override
    public int validateReservation(boolean valide, Client client) {
        Reservation r =findByClientNumCIN(client.getNumCIN());
        if(r==null){
            return -1;
        }
         reservationRepository.validateReservation(valide, client);
         return 1;
    }
//    @Override
//    public int validateReservation(boolean valide, Reservation reservation) {
//        
//        if(findByClientNumCIN(reservation.getClient().getNumCIN())==null){
//            return -1;
//        }
//         reservationRepository.validateReservation(valide, reservation.getClient());
//         return 1;
//    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}


