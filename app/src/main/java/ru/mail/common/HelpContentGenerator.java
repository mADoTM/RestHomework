package ru.mail.common;

import java.io.IOException;
import java.net.URL;

public class HelpContentGenerator {
    public static Object getContent() {
        try {
            return HelpContentGenerator.class
                    .getClassLoader()
                    .getResource("ru.mail/index.html")
                    .getContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
