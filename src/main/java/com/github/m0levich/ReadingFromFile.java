package com.github.m0levich;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFromFile {
    private File logPass = new File("login");
    private File smsCode = new File("smsCode");
    private File pass = new File("password");
    private String login;
    private String password;
    private String smsPin;

    public String getLogin() throws FileNotFoundException {
        Scanner scanner = new Scanner(logPass);
        login = scanner.nextLine();
        scanner.close();
        return login;
    }

    public String getPassword() throws FileNotFoundException {
        Scanner scanner = new Scanner(pass);
        password = scanner.nextLine();
        scanner.close();
        return password;
    }

    public String getSmsPin() throws FileNotFoundException {
        Scanner scanner = new Scanner(smsCode);
        smsPin = scanner.nextLine();
        scanner.close();
        return smsPin;
    }
}
