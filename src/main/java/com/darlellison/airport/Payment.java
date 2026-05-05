package com.darlellison.airport;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue
    private int id;

    @Transient
    private Ticket ticket;

    private double amount;

    public Payment(Ticket ticket, double amount) {
        this.ticket = ticket;
        this.amount = amount;
    }
    public Payment() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
