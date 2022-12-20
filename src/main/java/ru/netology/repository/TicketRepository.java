package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        return tickets;
    }

    public void addTicket(Ticket newTicket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];

        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }

        int index = tmp.length - 1;
        tmp[index] = newTicket;

        tickets = tmp;

    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void deleteById(int removeId) {
        if (tickets.length != 0) {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int index = 0;

            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i].getId() != removeId) {
                    if (index + 1 == tickets.length) {
                        return;
                    }
                    tmp[index] = tickets[i];
                    index++;
                }
            }
            tickets = tmp;
        }
    }
}