package tests.domain;

import com.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {
    static EventRequest eventRequestSCSEnd;

    @BeforeAll
    public static void init() throws ParseException, WrongValueException {
        eventRequestSCSEnd = new EventRequest(9, new Customer("Anna", "1234", "King 12"), "Super Wedding", "10/10/2023", "10/10/2024", "100", new ArrayList<>(), "10000");
        eventRequestSCSEnd.setFinancialComments("The expected budget is good");
        eventRequestSCSEnd.setState(States.SCS_END);
    }
    @Test
    public void testOk() {
        Event event1 = new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        assertNotNull(event1.getEventRequest());
        assertEquals("A super wedding near the beach", event1.getDescription());
        assertEquals("Pink flowers inside the church", event1.getDecorations());
        assertEquals("Red wine, fruits and chocolate", event1.getFoodDrinks());
        assertEquals("Filming the whole wedding day", event1.getFilmingPhotos());
        assertEquals("jaz", event1.getMusic());
        assertEquals("-", event1.getPcIssues());
        assertEquals("-", event1.getPosters());
        assertEquals("-", event1.getOtherNeeds());
        assertEquals(99999, event1.getBudget());
        assertEquals(99999, event1.getBudget());
    }

    @Test
    public void testNullRequest() {
       Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(null, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }

    @Test
    public void testNullDescription() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, null, 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }

    @Test
    public void testNullBudget() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", null, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }

    @Test
    public void testNullDecor() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, null, "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }

    @Test
    public void testNullFood() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", null, "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }

    @Test
    public void testNullFilming() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", null, "jaz", "-", "-", "-", 99999);
        });
    }
    @Test
    public void testNullMusic() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", null, "-", "-", "-", 99999);
        });
    }
    @Test
    public void testNullPosters() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", null, "-", "-", 99999);
        });
    }
    @Test
    public void testNullIssues() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", null, "-", 99999);
        });
    }
    @Test
    public void testEmpty1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Event(eventRequestSCSEnd, "", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }

    @Test
    public void testEmpty2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }

    @Test
    public void testEmpty3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        });
    }
    @Test
    public void testEmpty4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "", "jaz", "-", "-", "-", 99999);
        });
    }
    @Test
    public void testEmpty5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "", "-", "-", "-", 99999);
        });
    }
    @Test
    public void testEmpty6() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "", "-", "-", 99999);
        });
    }
    @Test
    public void testEmpty7() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "", "-", 99999);
        });
    }

}