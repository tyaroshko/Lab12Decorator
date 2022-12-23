package ua.edu.ucu.apps.changeMaking;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class Handler {
    private Handler nextHandler;
    private final int quantity;

    public void process(int amount) {
        int count = amount / quantity;
        int remainder = amount % quantity;

        if (nextHandler == null && remainder != 0) {
            throw new IllegalArgumentException("Unprocessable amount.");
        }

        System.out.println("Dispensing " + count + " notes of " + quantity);

        if (remainder != 0) {
            nextHandler.process(remainder);
        }
    }
}