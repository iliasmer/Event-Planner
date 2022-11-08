package tests.domain;


import com.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {
    static Event event1;
    static SubteamMember subteamMember1;
    @BeforeAll
    public static void start() throws IllegalArgumentException, ParseException, WrongValueException {
        String date1 = "10/10/2023";
        String date2 = "14/10/2023";
        Customer customer1 = new Customer("Anna", "1234567", "King 12");
        EventRequest eventRequestSCSEnd = new EventRequest(9, customer1, "Super Wedding", date1, date2, "100", new ArrayList<>(), "10000");
        eventRequestSCSEnd.setFinancialComments("The expected budget is good");
        event1 = new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        subteamMember1 = new SubteamMember("Tobias", new char[]{'1', '2', '3'}, UserRole.SubteamP, new Subteam("Photograph", new ArrayList<>()));
    }
    @Test
    void testOkTask() throws WrongValueException {
        Task task = new Task(event1, "buy pink flowers", subteamMember1, "High");
        assertEquals("buy pink flowers", task.getDescription());
        assertEquals("High", task.getPriority());
        assertNotNull(task.getEvent());
        assertNotNull(task.getAssignedTo());
    }

    @Test
    void testNullEventTask() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Task task = new Task(null, "buy pink flowers", subteamMember1, "High");

        });
    }


    @Test
    void testNullMemberTask(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            Task task = new Task(event1, "buy pink flowers", null, "High");

        });
    }

    @Test
    void testNullDescriptionTask(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            Task task = new Task(event1, null, subteamMember1, "High");

        });
    }

    @Test
    void testNullPriorityTask(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            Task task = new Task(event1, "buy pink flowers", subteamMember1, null);

        });
    }

    @Test
    void testWrongPriorityValueTask(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task(event1, "buy pink flowers", subteamMember1, "Very Low");

        });
    }

    @Test
    void testEmptyDescriptionTask(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task(event1, "", subteamMember1, "Low");

        });
    }

    @Test
    void testEmptyPriorityTask(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task(event1, "buy pink flowers", subteamMember1, "");

        });
    }
}
