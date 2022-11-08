package tests.domain;

import com.domain.RecruitmentRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecruitmentRequestTest {
    @Test
    public void testOkRecruitmentRequest() {
        RecruitmentRequest recruitmentRequest = new RecruitmentRequest("Full Time", "Service", 10, "Chef", "A good and experienced chef");
        assertEquals("Full Time", recruitmentRequest.getContractType());
        assertEquals("Service", recruitmentRequest.getDepartment());
        assertEquals(10, recruitmentRequest.getYearsOfExperience());
        assertEquals("Chef", recruitmentRequest.getJobTitle());
        assertEquals("A good and experienced chef", recruitmentRequest.getJobDescription());
    }

    @Test
    public void testEmptyContract() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RecruitmentRequest("", "Service", 10, "Chef", "A good and experienced chef");
        });
    }


    @Test
    public void testEmptyTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RecruitmentRequest("Contract", "Service", 10, "", "A good and experienced chef");
        });
    }

    @Test
    public void testNegativeYears() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RecruitmentRequest("Contract", "Service", -1, "Chef", "A good and experienced chef");
        });
    }



    @Test
    public void testNullContract() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new RecruitmentRequest(null, "Service", 10, "Chef", "A good and experienced chef");
        });
    }
    

    @Test
    public void testNullTitle() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new RecruitmentRequest("Contract", "Service", 10, null, "A good and experienced chef");
        });
    }
}
