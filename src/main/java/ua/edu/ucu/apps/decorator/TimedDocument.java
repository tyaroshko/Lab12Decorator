package ua.edu.ucu.apps.decorator;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class TimedDocument implements Document {
    public String gcsPath;
    @Override
    @SneakyThrows
    public String parse() {
        long start = System.currentTimeMillis();
        String text = new SmartDocument(gcsPath).parse();
        long elapsedTime = System.currentTimeMillis() - start;
        return text + "\nElapsed time in milliseconds: " + elapsedTime;
    }
}