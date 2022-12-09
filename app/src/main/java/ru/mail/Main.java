package ru.mail;

import ru.mail.common.FlywayInitializer;

public class Main {
    public static void main(String[] args) throws Exception {
        FlywayInitializer.initDb();

        RestEasyLauncher.run(3466);
    }
}