package com.GestionDeParking.Repository;

import com.GestionDeParking.bean.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    int deleteByNumCIN(String paramString);

    Agent findByNumCIN(String paramString);
}
