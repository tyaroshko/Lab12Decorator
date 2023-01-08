package ua.edu.ucu.apps.changeMaking;

import org.jetbrains.annotations.NotNull;

public class ATM {
    public static void process(int amount, @NotNull Handler handler) {
        handler.process(amount);
    }
    public static void main(String[] args) {
        Handler handler5 = new Handler5();
        Handler handler25 = new Handler25();
        Handler handler50 = new Handler50();
        handler50.setNextHandler(handler25);
        handler25.setNextHandler(handler5);

        ATM.process(100, handler50);
        ATM.process(80, handler50);
        ATM.process(60, handler50);
    }
}