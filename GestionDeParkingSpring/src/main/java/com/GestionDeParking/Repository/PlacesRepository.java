package com.GestionDeParking.Repository;

import com.GestionDeParking.bean.Parking;
import com.GestionDeParking.bean.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends JpaRepository<Places, Long> {

    @Query("update Places p set p.nbrPlaces=:place where p.parking=:parking")
    int updatePlace(@Param("place") int paramInt, @Param("parking") Parking paramParking);

    int deleteByParkingLiblle(String paramString);
}
