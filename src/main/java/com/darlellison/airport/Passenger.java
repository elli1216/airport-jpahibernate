package com.darlellison.airport;

import com.mysql.cj.xdevapi.AddResult;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "PASSENGERS")
//@SecondaryTable(name = "ADDRESSES",
//        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
@SecondaryTables({
    @SecondaryTable(name = "ADDRESSES",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID")),
    @SecondaryTable(name = "PHONES",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID")
    )
})
public class Passenger {
    @Id
    @GeneratedValue
    @Column(name = "passenger_id")
    private int id;

    @Column(name = "passenger_name", table = "PASSENGERS")
    private String name;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @Column(name = "street", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String street;

    @Column(name = "number", table = "ADDRESSES", columnDefinition = "varchar(10) not null")
    private String number;

    @Column(name = "zipcode", table = "ADDRESSES", columnDefinition = "varchar(10) not null")
    private String zipCode;

    @Column(name = "city", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String city;

    @Column(name = "area", table = "PHONES", columnDefinition = "varchar(5) not null")
    private String areaCode;

    @Column(name = "prefix", table = "PHONES", columnDefinition = "varchar(5) not null")
    private String prefix;

    @Column(name = "line_number", table = "PHONES", columnDefinition = "varchar(10) not null")
    private String lineNumber;

    @ManyToMany(mappedBy = "passengers")
    private List<Ticket> tickets = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "passenger_tickets", joinColumns =  {
            @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id")
    })
    private List<EmbeddedTicket> emticket = new ArrayList<>();

    @ElementCollection
    @MapKeyColumn(name = "attribute_name")
    @Column(name = "attribute_value")
    @CollectionTable(name = "passenger_attributes", joinColumns = {
            @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id")
    })
    private Map<String, String> attributes = new HashMap<>();

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "passenger_street")),
        @AttributeOverride(name = "number", column = @Column(name = "passenger_number")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "passenger_zip_code")),
        @AttributeOverride(name = "city", column = @Column(name = "passenger_city"))
    })
    private Address address;

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<EmbeddedTicket> getEmticket() {
        return emticket;
    }

    public void setEmticket(List<EmbeddedTicket> emticket) {
        this.emticket = emticket;
    }

    public void addEmbeddedTicket(EmbeddedTicket ticket) { emticket.add(ticket); }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String attribute, String isActive) { attributes.put(attribute, isActive); }
}
