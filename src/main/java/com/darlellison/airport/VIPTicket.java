package com.darlellison.airport;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vip_ticket")
@AssociationOverride(name = "passengers", joinColumns = @JoinColumn(name = "passenger_id"))
public class VIPTicket extends Ticket {
    private LocalDate latestVIPDepartureDate;

    public LocalDate getVIPLatestDepartureDate() {
        return latestVIPDepartureDate;
    }

    public void setVIPLatestDepartureDate(LocalDate latestVIPDepartureDate) {
        this.latestVIPDepartureDate = latestVIPDepartureDate;
    }
}
