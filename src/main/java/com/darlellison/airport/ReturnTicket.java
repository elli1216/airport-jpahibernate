package com.darlellison.airport;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class ReturnTicket extends Ticket {
    private LocalDate latestReturnDate;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public LocalDate getLatestReturnDate() {
        return latestReturnDate;
    }

    public void setLatestReturnDate(LocalDate latestReturnDate) {
        this.latestReturnDate = latestReturnDate;
    }
}
