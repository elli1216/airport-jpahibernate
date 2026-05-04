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

            Manager Krys = new Manager("Krystler Cataniag");
            Department RBISD = new Department();
            RBISD.setDept_name("Retail Banking and Integrating Systems");

            Krys.setDepartment(RBISD);

            em.persist(Krys);
            em.persist(RBISD);

            em.getTransaction().commit();
        }
    }
}
