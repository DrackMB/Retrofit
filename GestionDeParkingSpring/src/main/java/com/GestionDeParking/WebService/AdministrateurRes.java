package com.GestionDeParking.WebService;

import com.GestionDeParking.Service.facad.AdministrateurService;
import com.GestionDeParking.bean.Agent;
import com.GestionDeParking.bean.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/GestionDeParking/Admin/"})
public class AdministrateurRes {

    @Autowired
    AdministrateurService administrateurService;

    @GetMapping({"/user/{user}/mdp/{mdp}"})
    public int Login(@PathVariable String user, @PathVariable String mdp) {
        return administrateurService.Login(user, mdp);
    }

    @DeleteMapping({"/liblle/{liblle}"})
    public int suprimerParking(@PathVariable String liblle) {
        return administrateurService.suprimerParking(liblle);
    }

    @PostMapping({"/Save/"})
    public int saveParking(@RequestBody Parking parking) {
        return administrateurService.saveParking(parking);
    }

    @PostMapping({"/"})
    public int AjouterAgent(Agent agent, Parking parking) {
        return administrateurService.AjouterAgent(agent, parking);
    }

    @DeleteMapping({"/agent/numCIN/{numCIN}"})
    public int suprimerAgent(String numCIN) {
        return administrateurService.suprimerAgent(numCIN);
    }
}
