package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

public class TicketManagerTest {

    private final TicketRepository repository = new TicketRepository();
    private final TicketManager manager = new TicketManager(repository);

    private final Ticket ticket1 = new Ticket(1, 4500, "LED", "DME", 70);
    private final Ticket ticket2 = new Ticket(2, 5000, "KUF", "LED", 120);
    private final Ticket ticket3 = new Ticket(3, 5500, "DME", "KUF", 60);
    private final Ticket ticket4 = new Ticket(4, 11000, "LED", "AER", 190);
    private final Ticket ticket5 = new Ticket(5, 7100, "DME", "ULV", 180);
    private final Ticket ticket6 = new Ticket(6, 5300, "KUF", "LED", 120);

    @BeforeEach
    void add() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    void shouldFindTicket() {
        Ticket[] expect = new Ticket[]{ticket3};
        Ticket[] actual = manager.findAllFromTo("DME", "KUF");

        assertArrayEquals(expect, actual);
    }

    @Test
    void shouldFindSeveralTicketsFromTo() {
        Ticket[] expect = new Ticket[]{ticket2, ticket6};
        Ticket[] actual = manager.findAllFromTo("KUF", "LED");

        assertArrayEquals(expect, actual);
    }

    @Test
    void shouldTestNoTickets() {
        Ticket[] expect = new Ticket[0];
        Ticket[] actual = manager.findAllFromTo("AER", "LED");

        assertArrayEquals(expect, actual);
    }

    @Test
    void shouldSortForPrice() {

        Ticket[] expect = new Ticket[]{ticket1, ticket2, ticket6, ticket3, ticket5, ticket4};
        Ticket[] actual = new Ticket[]{ticket1, ticket5, ticket2, ticket4, ticket6, ticket3};
        Arrays.sort(actual);

        assertArrayEquals(expect, actual);
    }
}