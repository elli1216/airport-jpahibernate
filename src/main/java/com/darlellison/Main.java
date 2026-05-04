package com.darlellison;

//import com.darlellison.airport.Airport;
import com.darlellison.airport.Passenger;
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

            Passenger df = new Passenger(1100, "Darl Ellison Floresca");
            Passenger pa = new Passenger(1200, "Paolo Angelo");
            Passenger ml = new Passenger(1300, "Marc Lamont");

            df.setNumber("26");
            df.setStreet("Switch");
            df.setCity("Marilao");
            df.setZipCode("3019");

            pa.setNumber("33");
            pa.setStreet("Maunlad");
            pa.setCity("Malolos");
            pa.setZipCode("3000");

            df.setAreaCode("+63");
            df.setPrefix("92384");
            df.setLineNumber("31839");

            pa.setAreaCode("+63");
            pa.setPrefix("76456");
            pa.setLineNumber("09653");

            em.persist(df);
            em.persist(pa);
            em.persist(ml);

            em.getTransaction().commit();
        }
    }
}
