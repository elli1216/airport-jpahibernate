package com.darlellison;

//import com.darlellison.airport.Airport;
import com.darlellison.airport.*;
//import com.darlellison.airport.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
            darl.setAddress(address);

            em.persist(darl);

            em.getTransaction().commit();
        }
    }
}
