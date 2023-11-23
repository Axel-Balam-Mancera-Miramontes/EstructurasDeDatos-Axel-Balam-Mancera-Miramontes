package tarea2.ejercicio_1.process;

import java.util.Objects;

public class Passenger {
    private String name;
    private int ticket;
    private boolean hasTicket;

    // Constructor
    public Passenger(String name, int ticket) {
        this.name = name;
        this.ticket = ticket;
        this.hasTicket = true;
    }

    public Passenger(String name) {
        this.name = name;
        this.ticket = -1;
        this.hasTicket = false;
    }

    public String getName() {
        return name;
    }

    public int getTicket() {
        return ticket;
    }

    public boolean hasTicket() {
        return hasTicket;
    }

    @Override
    public String toString() {
        return "SoccerPlayer{" +
                "name='" + name + '\'' +
                ", ticekt=" + ticket +
                ", hasTicket=" + hasTicket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger anomtherPassenger = (Passenger) o;
        return ticket == anomtherPassenger.ticket && hasTicket == anomtherPassenger.hasTicket && Objects.equals(name, anomtherPassenger.name);
    }

}
