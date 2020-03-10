package com.GestionDeParking.Repository;

import com.GestionDeParking.bean.Client;
import com.GestionDeParking.bean.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByClientNumCIN(String paramString);

    int deleteByClientNumCIN(String paramString);

    @Query("update Reservation r set r.valide=:validat where r.client=:client")
    int validateReservation(@Param("validat") boolean paramBoolean, @Param("client") Client paramClient);
}
