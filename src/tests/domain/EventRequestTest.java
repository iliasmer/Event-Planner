package tests.domain;

import com.domain.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventRequestTest {
    private Customer customer;
    String date1 = "10/10/2023";
    String date2 = "14/10/2023";
    String wrongDate = "10-10-2023";

    @Before
    public void init() {
        customer = new Customer("Anna", "1234567", "King 12");
    }

    @Test
    public void testOkEventRequest() throws WrongValueException, IllegalArgumentException, ParseException {
        ArrayList<String> preferences = new ArrayList<>();
        preferences.add("Decorations");
        preferences.add("Parties");

        EventRequest eventRequest = new EventRequest(1, customer, "Party", date1, date2, "100", preferences, "1000");
        assertEquals(1, eventRequest.getRecordNumber());
        assertEquals("Party", eventRequest.getEventType());
        assertEquals(100, eventRequest.getExpectedNumberOfAttendees());
        assertEquals(1000, eventRequest.getExpectedBudget());
        assertEquals(States.SCS_INIT, eventRequest.getState());
        assertNull(eventRequest.getEvent());
        assertEquals(2, eventRequest.getPreferences().size());
    }


    @Test
    public void testWrongDate1EventRequest() {

        Assertions.assertThrows(ParseException.class, () -> {
            new EventRequest(1, customer, "Party", wrongDate, date2, "100", new ArrayList<>(), "1000");
        });
    }

    @Test
    public void testWrongDate2EventRequest() {

        Assertions.assertThrows(ParseException.class, () -> {
            new EventRequest(1, customer, "Party", date1, wrongDate, "100", new ArrayList<>(), "1000");
        });
    }

    @Test
    public void testReverseDatesEventRequest() {

        Assertions.assertThrows(WrongValueException.class, () -> {
            new EventRequest(1, customer, "Party", date2, date1, "100", new ArrayList<>(), "1000");
        });
    }

    @Test
    public void testNonPositiveAttendeesEventRequest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new EventRequest(1, customer, "Party", date1, date2, "-1", new ArrayList<>(), "1000");
        });
    }

    @Test
    public void testNonPositiveBudgetEventRequest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new EventRequest(1, customer, "Party", date1, date2, "1", new ArrayList<>(), "-1");
        });
    }
}