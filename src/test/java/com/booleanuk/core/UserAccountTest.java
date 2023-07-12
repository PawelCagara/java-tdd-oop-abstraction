package com.booleanuk.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserAccountTest {
    UserAccount userAccount;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        userAccount = new UserAccount();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void setEmailTest(){
        userAccount.setEmail("malpa@com");
        Assertions.assertEquals("malpa@com", userAccount.getEmail());
        userAccount.setEmail("malpa");
        Assertions.assertEquals("malpa@com",userAccount.getEmail());
        Assertions.assertEquals("Email not contains @", outputStreamCaptor.toString().trim());
    }

    @Test
    public void getEmailTest(){
        Assertions.assertEquals("",userAccount.getEmail());
        userAccount.setEmail("malpa@com");
        Assertions.assertEquals("malpa@com", userAccount.getEmail());
    }
}
