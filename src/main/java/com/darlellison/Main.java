package com.darlellison;

//import com.darlellison.airport.Airport;
import com.darlellison.airport.*;
//import com.darlellison.airport.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.sql.results.graph.collection.internal.ArrayInitializerProducer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("darlellison.m03.ex01");
             EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            Airport NAIA = new Airport();
            NAIA.setName("Ninoy Aquino International Airport");

            Passenger darl = new Passenger("Darl Floresca");
            darl.setAirport(NAIA);
            Address address = new Address();

            address.setStreet("Switch");
            address.setNumber("26");
            address.setZipCode("3019");
            address.setCity("Marilao");

            TicketKey keyOfVIP = new TicketKey();
            keyOfVIP.setNumber("1111");
            keyOfVIP.setSeries("VIPS");

            VIPTicket vipTicket = new VIPTicket();
            vipTicket.setVIPLatestDepartureDate(LocalDate.of(2026, 5, 12));
            vipTicket.setId(keyOfVIP);

            vipTicket.addPassenger(darl);

            em.persist(NAIA);
            em.persist(vipTicket);
            em.persist(darl);

            em.getTransaction().commit();
        }
    }
}
