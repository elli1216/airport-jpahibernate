package com.darlellison;

import com.darlellison.airport.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class CountryService {

    @PersistenceContext
    private EntityManager em;

    public static final String[][] COUNTRY_INIT_DATA = {
            {"Australia", "AU"},
            {"France", "FR"},
            {"Germany", "GE"},
            {"Italy", "IT"},
            {"Japan", "JP"},
            {"Romania", "RO"},
            {"Russian Federation", "RU"},
            {"Spain", "ES"},
            {"Switzerland", "CH"},
            {"United Kingdom", "UK"},
            {"United States", "US"},
            {"Philippines", "PH"},
    };

    @Transactional
    public void init() {
        for (int i = 0; i < COUNTRY_INIT_DATA.length; i++) {
            String[] countryInitData = COUNTRY_INIT_DATA[i];
            Country country = new Country(countryInitData[0], countryInitData[1]);
            em.persist(country);
        }
    }

    @Transactional
    public void clear()  {
        em.createQuery("delete from Country c").executeUpdate();
    }

    public List<Country> getAllCountries() {
        return em.createQuery("select c from Country c").getResultList();
    };
}
