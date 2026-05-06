package com.darlellison;

//import com.darlellison.airport.Airport;
import com.darlellison.airport.*;
//import com.darlellison.airport.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("darlellison.m03.ex01");
             EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            Passenger darl = new Passenger("Darl Floresca");
            Address address = new Address();

            address.setStreet("Switch");
            address.setNumber("26");
            address.setZipCode("3019");
            address.setCity("Marilao");

            TicketKey keyOfOneWay = new TicketKey();
            keyOfOneWay.setNumber("1234");
            keyOfOneWay.setSeries("EERD");

            TicketKey keyOfReturn = new TicketKey();
            keyOfReturn.setNumber("5678");
            keyOfReturn.setSeries("POIU");

            OneWayTicket oneWayTicket = new OneWayTicket();
            oneWayTicket.setId(keyOfOneWay);
            oneWayTicket.setLatestDepartureDate(LocalDate.of(2026, 5, 15));

            ReturnTicket returnTicket = new ReturnTicket();
            returnTicket.setLatestReturnDate(LocalDate.of(2026, 6, 15));
            returnTicket.setId(keyOfReturn);

            darl.setOneWayTicket(oneWayTicket);
            darl.setReturnTicket(returnTicket);

            em.persist(oneWayTicket);
            em.persist(returnTicket);
            em.persist(darl);

            em.getTransaction().commit();
        }
    }
}
