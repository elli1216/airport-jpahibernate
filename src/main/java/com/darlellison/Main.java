package com.darlellison;

//import com.darlellison.airport.Airport;
import com.darlellison.airport.Passenger;
//import com.darlellison.airport.Ticket;
import com.darlellison.airport.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("darlellison.m03.ex01");
             EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            Ticket ticket1 = new Ticket();
            ticket1.setSeries("AA");
            ticket1.setNumber("1234");
            ticket1.setOrigin("Manila");
            ticket1.setDestination("Singapore");
            em.persist(ticket1);

            em.getTransaction().commit();
        }
    }
}
