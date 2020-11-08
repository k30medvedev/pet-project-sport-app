package by.kirill.sportsman.app.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void testToStringTest() {
        UserEntity userEntity  = new UserEntity();
        String name = "Helen";
        userEntity.setFirstName(name);
        assertTrue(userEntity.toString().contains("Helen"));

    }

    @Test
    void setIdTest() {
        Long id  = 10l;
        UserEntity userEntity  = new UserEntity();
        userEntity.setId(id);
        assertEquals(userEntity.getId(),id);
    }

    @Test
    void getIdTest() {
        UserEntity userEntity  = new UserEntity();
        Long id  = 10l;
        userEntity.setId(id);
        Long result = userEntity.getId();
        assertEquals(result,id);

    }

    @Test
    void setFirstNameTest() {
        String name = "Helen";
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(name);
        assertEquals(userEntity.getFirstName(),name);
    }

    @Test
    void getFirstNameTest() {
        UserEntity userEntity = new UserEntity();
        String name = "Helen";
        userEntity.setFirstName(name);
        String result = userEntity.getFirstName();
        assertEquals(result,name);
    }

    @Test
    void getLastNameTest() {
        UserEntity userEntity = new UserEntity();
        String name = "Helen";
        userEntity.setLastName(name);
        String result = userEntity.getLastName();
        assertEquals(result,name);
    }

    @Test
    void setLastNameTest() {
        String name = "Helen";
        UserEntity userEntity = new UserEntity();
        userEntity.setLastName(name);
        assertEquals(userEntity.getLastName(),name);
    }

    @Test
    void setEmailTest() {
        String email = "test@gmail.com";
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        assertEquals(userEntity.getEmail(),email);
    }

    @Test
    void getEmailTest() {
        UserEntity userEntity = new UserEntity();
        String email = "test@gmail.com";
        userEntity.setEmail(email);
        String result = userEntity.getEmail();
        assertEquals(result,email);
    }

    @Test
    void setBirthdayTest() {
        LocalDate birthday = LocalDate.of(1976,03,15);
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(birthday);
        assertEquals(userEntity.getBirthday(),birthday);
    }

    @Test
    void getBirthdayTest() {
        UserEntity userEntity = new UserEntity();
        LocalDate birthday = LocalDate.of(1976,03,15);
        userEntity.setBirthday(birthday);
        LocalDate result = userEntity.getBirthday();
        assertEquals(result,birthday);
    }
}