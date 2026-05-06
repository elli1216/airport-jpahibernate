package com.darlellison.airport;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "AIRPORTS")
@Access(AccessType.FIELD)
public class Airport {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "airport")
    private List<Passenger> passengers = new ArrayList<>();

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Airport() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}
