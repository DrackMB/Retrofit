package com.GestionDeParking.Service.impl;

import com.GestionDeParking.Repository.AgentRepository;
import com.GestionDeParking.Service.facad.AgentService;
import com.GestionDeParking.Service.facad.PlacesService;
import com.GestionDeParking.Service.facad.ReservationService;
import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PlacesService placesService;

    @Override
    public int ajouterReservation(Reservation reservation) {
         return this.reservationService.save(reservation);
    }

    @Override
    public int validerReservation(boolean validate, Reservation reservation) {
        return this.reservationService.validateReservation(validate, reservation);
    }

    @Override
    public Reservation afficherReservation(Client client) {
        return this.reservationService.findByClientNumCIN(client.getNumCIN());
    }

    @Override
    public int ajouterPlace(int nbPlace, Parking parking) {
        return this.placesService.updatePlace(nbPlace, parking);
    }

    @Override
    public int deleteByNumCIN(String numCIN) {
        return this.agentRepository.deleteByNumCIN(numCIN);
    }

    @Override
    public int save(Agent agent, Parking parking) {
        Agent agentResult = findByNumCIN(agent.getNumCIN());
        if (agentResult == null) {
            return -1;
        }
        if (agentResult.getParking().getLiblle().equals(parking.getLiblle())) {
            return -2;
        }
        this.agentRepository.save(agent);
        return 1;
    }

    @Override
    public Agent findByNumCIN(String numCIN) {
        return this.agentRepository.findByNumCIN(numCIN);
    }
}
