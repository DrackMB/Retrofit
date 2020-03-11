package com.GestionDeParking.WebService;

import com.GestionDeParking.Service.facad.ParkingService;
import com.GestionDeParking.bean.Parking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GestionDeParking/Parking")
public class ParkingRes {

    @Autowired
    private ParkingService parkingService;
    @PostMapping("/")
    public int save(@RequestBody Parking parking) {
        return parkingService.save(parking);
    }
    @Transactional
    @DeleteMapping("/liblle/{liblle}")
    public int deleteByLiblle(@PathVariable String liblle) {
        return parkingService.deleteByLiblle(liblle);
    }
    @GetMapping("/")
    public List<Parking> findAll() {
        return parkingService.findAll();
    }
    @GetMapping("/liblle/{liblle}")
    public Parking findByLiblle(@PathVariable String liblle) {
        return parkingService.findByLiblle(liblle);
    }
}
