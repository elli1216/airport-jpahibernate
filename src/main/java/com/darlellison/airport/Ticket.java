package com.darlellison.airport;

import jakarta.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Ticket {
    @EmbeddedId
    private TicketKey id;

    private String origin;
    private String destination;

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    public TicketKey getId() {
        return id;
    }

    public void setId(TicketKey id) {
        this.id = id;
    }

    public Ticket() {}

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
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
