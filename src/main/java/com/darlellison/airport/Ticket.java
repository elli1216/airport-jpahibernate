package com.darlellison.airport;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@MappedSuperclass
public class Ticket {
    @EmbeddedId
    private TicketKey id;

    private String origin;
    private String destination;

    @ManyToMany
    private List<Passenger> passengers = new ArrayList<>();

    public TicketKey getId() {
        return id;
    }

    public void setId(TicketKey id) {
        this.id = id;
    }

    public Ticket() {}

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void setPassenger(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
