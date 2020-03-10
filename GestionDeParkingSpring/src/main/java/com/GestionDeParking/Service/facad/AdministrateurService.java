package com.GestionDeParking.Service.facad;

import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Parking;

public interface AdministrateurService {

    int Login(String user, String mdp);

    int suprimerParking(String libelle);

    int saveParking(Parking parking);

    int AjouterAgent(Agent agent, Parking parking);

    int suprimerAgent(String numCIN);
}
