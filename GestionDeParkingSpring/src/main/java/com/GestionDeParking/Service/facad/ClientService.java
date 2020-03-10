package com.GestionDeParking.Service.facad;

import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Reservation;

public interface ClientService {

    int ajouterReservation(Reservation reservation);

    int save(Client client);

    Client findByNumCIN(String NumCIN);
}
