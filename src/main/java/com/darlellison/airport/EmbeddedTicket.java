package com.darlellison.airport;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmbeddedTicket {
    private String number;

    public EmbeddedTicket(String number) { this.number = number; }

    public EmbeddedTicket() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
