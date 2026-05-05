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

            EmbeddedTicket ticket1 = new EmbeddedTicket("1234");
            EmbeddedTicket ticket2 = new EmbeddedTicket("5678");

            darl.setAddress(address);
            darl.addEmbeddedTicket(ticket1);
            darl.addEmbeddedTicket(ticket2);

            darl.addAttribute("VIP", "Yes");
            darl.addAttribute("FirstClass", "Yes");

            em.persist(darl);

            em.getTransaction().commit();
        }
    }
}
