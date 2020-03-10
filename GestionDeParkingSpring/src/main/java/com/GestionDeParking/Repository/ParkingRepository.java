package com.GestionDeParking.Repository;

import com.GestionDeParking.bean.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

    int deleteByLiblle(String paramString);

    Parking findByLiblle(String paramString);
}
