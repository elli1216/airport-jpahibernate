package com.darlellison.airport;

import jakarta.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

//    @Column(name = "NUMBER")

    private String series;
    private String number;
    private String origin;
    private String destination;

//    @ManyToOne
//    @JoinColumn(name = "PASSENGER_ID")
//    private Passenger passenger;

    public Ticket(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public Ticket() {}

//    public Passenger getPassenger() {
//        return passenger;
//    }

//    public void setPassenger(Passenger passenger) {
//        this.passenger = passenger;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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
