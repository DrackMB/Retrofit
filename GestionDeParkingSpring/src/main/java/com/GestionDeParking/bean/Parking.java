package com.GestionDeParking.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String liblle;
    private String Adress;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "parking")
    private List<Agent> agents;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "parking")
    private List<Places> places;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "parking")
    private List<Reservation> reservations;

    public String getLiblle() {
         return this.liblle;
    }

    public void setLiblle(String liblle) {
         this.liblle = liblle;
    }

    public String getAdress() {
         return this.Adress;
    }

    public void setAdress(String Adress) {
         this.Adress = Adress;
    }

    public List<Agent> getAgents() {
         return this.agents;
    }

    public void setAgents(List<Agent> agents) {
         this.agents = agents;
    }

    public List<Places> getPlaces() {
         return this.places;
    }

    public void setPlaces(List<Places> places) {
         this.places = places;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public int hashCode() {
         int hash = 0;
         hash += (this.id != null) ? this.id.hashCode() : 0;
         return hash;
    }

    public boolean equals(Object object) {
         if (!(object instanceof Parking)) {
            return false;
        }
         Parking other = (Parking) object;
         if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
          return false;
        }
         return true;
    }

    @Override
    public String toString() {
        return "com.GestionDeParking.bean.Parking[ id=" + this.id + " ]";
    }
}


