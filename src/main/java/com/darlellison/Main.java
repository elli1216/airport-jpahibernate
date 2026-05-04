package com.darlellison;

//import com.darlellison.airport.Airport;
import com.darlellison.airport.Airport;
import com.darlellison.airport.Passenger;
//import com.darlellison.airport.Ticket;
import com.darlellison.airport.Ticket;
import com.darlellison.airport.TicketKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("darlellison.m03.ex01");
             EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            Airport NAIA = new Airport(1100,"NAIA");

            Passenger passenger1 = new Passenger("Darl Ellison Floresca");
            passenger1.setAirport(NAIA);
            Passenger passenger2 = new Passenger("Paolo Angelo");
            passenger2.setAirport(NAIA);


            TicketKey ticketkey1 = new TicketKey();
            ticketkey1.setSeries("AA");
            ticketkey1.setNumber("12345");

            Ticket ticket1 = new Ticket();

            ticket1.addPassenger(passenger1);
            ticket1.setId(ticketkey1);
            ticket1.setOrigin("Manila");
            ticket1.setDestination("Singapore");

            TicketKey ticketkey2 = new TicketKey();
            ticketkey2.setSeries("BB");
            ticketkey2.setNumber("54321");

            Ticket ticket2 = new Ticket();
            ticket2.addPassenger(passenger2);
            ticket2.setId(ticketkey2);
            ticket2.setOrigin("Manila");
            ticket2.setDestination("Singapore");

            passenger1.addTicket(ticket1);
            passenger1.addTicket(ticket2);
            passenger2.addTicket(ticket1);
            passenger2.addTicket(ticket2);

            em.persist(NAIA);
            em.persist(passenger1);
            em.persist(passenger2);
            em.persist(ticket1);
            em.persist(ticket2);

            em.getTransaction().commit();
        }
    }
}
