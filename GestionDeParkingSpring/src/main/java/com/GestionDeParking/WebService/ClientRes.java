package com.GestionDeParking.WebService;

import com.GestionDeParking.Service.facad.ClientService;
import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GestionDeParking/Client")
public class ClientRes {

    @Autowired
    private ClientService clientService;
    @PostMapping("/ajouterR/")
    public int ajouterReservation(@RequestBody Reservation reservation) {
        return clientService.ajouterReservation(reservation);
    }
    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }
    @GetMapping("/NumCIN/{NumCIN}")
    public Client findByNumCIN(String numCIN) {
        return clientService.findByNumCIN(numCIN);
    }
}
