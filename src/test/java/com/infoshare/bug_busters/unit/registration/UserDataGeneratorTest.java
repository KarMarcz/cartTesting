package com.infoshare.bug_busters.unit.registration;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserDataGeneratorTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie
    @Test
    public void createsCorrectUser() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class); //tworzy moka z klasy RandomDataGenerator czyli ma dostep do pol i metod tej klasy

        when(generatorMock.prepareUserName()).thenReturn("login_ola"); //na moku wykonuje metode prepareUserName() z klasy RandomDataGenerator i mowie jej co ma zwocic
        //dzieki temu metoda prepareUserName() zwroci tylko "login_ola"
        when(generatorMock.prepareFirstName()).thenReturn("Tomasz");
        when(generatorMock.prepareLastName()).thenReturn("Nowak");
        when(generatorMock.prepareEmail()).thenReturn("Test@gamil.com");
        when(generatorMock.preparePassword()).thenReturn("Test");

        UserDataGenerator underTest = new UserDataGenerator(generatorMock); // stworzenie nowego obiektu bedacego instancja klasy UserDataGenerator ktorej metoda jest testowana
        // tworzona z konstruktora klasy UserDataGenerator ale wstrzykuje do niego zmienna mock dzieki temu obchodze wywolanie prawdziwej klasy RandomDataGenerator
        UserData result = underTest.prepareUserData();

        Assertions.assertThat(result.getUserName().substring(0, 9)).isEqualTo("login_ola");
        Assertions.assertThat(result.getFirstName()).isEqualTo("Tomasz");
        Assertions.assertThat(result.getLastName()).isEqualTo("Nowak");
        Assertions.assertThat(result.getEmail()).isEqualTo("Test@gamil.com");
        Assertions.assertThat(result.getPassword()).isEqualTo("Test");
    }

    UserDataGenerator userdataGeneratoApp = new UserDataGenerator(new RandomDataGenerator());

    @Test
    public void checkifisnotnullTest() throws IOException {
        UserData checkingValuesNotNull = userdataGeneratoApp.prepareUserData();
        assertNotNull("Username is not null", checkingValuesNotNull.getUserName());
        assertNotNull("FirstName is not null", checkingValuesNotNull.getFirstName());
        assertNotNull("LastName is not null", checkingValuesNotNull.getLastName());
        assertNotNull("Email is not null", checkingValuesNotNull.getEmail());
        assertNotNull("Password is not null", checkingValuesNotNull.getPassword());
    }


}















