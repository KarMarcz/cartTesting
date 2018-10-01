package com.infoshare.bug_busters.unit.registration;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class UserDataTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie

    UserDataGenerator userinfo = new UserDataGenerator(new RandomDataGenerator());
    @Test
    public void PrepareUserDataTest() throws IOException {
      /* assertTrue("Letter are not from A-Z", Pattern.matches("[a-zA-Z]+", userinfo.prepareUserData().getUserName()));*/
        assertTrue("Letter are not from A-Z", Pattern.matches("[a-zA-Z]+", userinfo.prepareUserData().getFirstName()));
        assertTrue("Letter are not from A-Z", Pattern.matches("[a-zA-Z]+", userinfo.prepareUserData().getLastName()));
        assertTrue("Email is not valid", Pattern.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", userinfo.prepareUserData().getEmail()));
        assertTrue("Letter are not from A-Z", Pattern.matches("[a-zA-Z]+", userinfo.prepareUserData().getPassword()));
    }

}
