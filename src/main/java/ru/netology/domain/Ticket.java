package ru.netology.domain;
public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String toAirport;
    private String fromAirport;
    private int travelTIme;

    public Ticket(int id, int cost, String fromAirport, String toAirport, int travelTIme) {
        this.id = id;
        this.cost = cost;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.travelTIme = travelTIme;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public void setTravelTIme(int travelTIme) {
        this.travelTIme = travelTIme;
    }

    public int getCost() {
        return cost;
    }

    public String getToAirport() {
        return toAirport;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public int getTravelTIme() {
        return travelTIme;
    }

    public int getId() {
        return id;
    }

    public boolean matches(String text) {
        if (getFromAirport().contains(text)) {
            return true;
        }
        if (getToAirport().contains(text)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        }
        if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}