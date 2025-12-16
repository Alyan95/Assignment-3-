// File Name: UserLoginTest.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*
 This program demonstrates Automated Testing in Java using JUnit.
 The login method contains a defect which will be IDENTIFIED and DETECTED
 by the automated test written below.
*/

public class UserLoginTest {

    // -------- Application Code (Code Under Test) --------
    public static boolean login(String username, String password) {

        // DEFECT: Password validation is missing
        if (username.equals("admin")) {
            return true;   // allows login even with wrong password
        }
        return false;
    }

    // -------- Automated Test Case --------
    @Test
    void testInvalidPasswordLogin() {

        String testUsername = "admin";
        String testPassword = "wrongpass";

        boolean result = login(testUsername, testPassword);

        // IDENTIFY / DETECT ERROR
        // Expected: login should fail for wrong password
        // Actual: login succeeds (BUG)
        assertFalse(result, "ERROR DETECTED: Login succeeded with wrong password");
    }
}
