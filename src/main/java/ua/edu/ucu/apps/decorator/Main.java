package ua.edu.ucu.apps.decorator;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Document document = new CachedDocument("gs://oop-lab12/image.jpg");
        System.out.println(document.parse());
    }
}
