package tests.domain;

import com.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testOkCustomer() {
        Customer customer = new Customer("Name", "12334567", "Address 1");
        assertEquals("Name", customer.getName());
        assertEquals("12334567", customer.getTel());
        assertEquals("Address 1", customer.getAddress());
    }

    @Test
    void testNullName() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Customer(null, "12334567", "Address 1");
        });
    }

    @Test
    void testEmptyName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Customer("", "12334567", "Address 1");
        });
    }

    @Test
    void testNullTel() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Customer("Name", null, "Address 1");
        });
    }

    @Test
    void testEmptyTel() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Customer("Name", "", "Address 1");
        });
    }


    @Test
    void testNullAddress() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Customer("Name", "12334567", null);
        });
    }

    @Test
    void testEmptyAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Customer("Name", "1234567", "");
        });
    }
}