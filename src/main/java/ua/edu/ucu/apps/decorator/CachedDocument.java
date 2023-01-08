package ua.edu.ucu.apps.decorator;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.sql.*;

@AllArgsConstructor
public class CachedDocument implements Document {
    String gcsPath;
    @SneakyThrows
    @Override
    public String parse() {
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:sqlite:documents.db"
        );
        String text;
        try {
            Statement stmt = jdbcConnection.createStatement();
            ResultSet res = stmt.executeQuery(String.format(
                    "select content from document where gcsPath=\"%s\";", gcsPath)
            );
            text = res.getString("content");
            stmt.close();
        } catch (SQLException e) {
            text = new SmartDocument(gcsPath).parse();
            Statement stmt = jdbcConnection.createStatement();
            stmt.executeUpdate(String.format(
                    "insert into document (gcsPath, content) values ('%s','%s');", gcsPath, text)
            );
            stmt.close();
        }
        return text;
    }
}